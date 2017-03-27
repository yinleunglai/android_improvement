package sharefiles.lsmore.com.sharefilethroughlocal;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SecondPageActivity extends AppCompatActivity {
    String path = Environment.getExternalStorageDirectory()+"/savefile.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

    }

    public void onResume(){
        super.onResume();
        getObjectFromFile();
    }

    public void getObjectFromFile(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
                    try {
                        AnotherUser user = (AnotherUser) inputStream.readObject();
                        Log.e("SecondActivity","user:"+user.getUserName());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }) .start();

    }

}
