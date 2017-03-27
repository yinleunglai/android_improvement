package sharefiles.lsmore.com.sharefilethroughlocal;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    String path = Environment.getExternalStorageDirectory()+"/savefile.txt";
    AnotherUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         user = new AnotherUser(1002,"simon");



    }

    public void onResume(){
        super.onResume();
        persistenToFile(user);
    }

    public void persistenToFile(final AnotherUser user){
        new Thread(){
            @Override
            public void run() {
                super.run();
                File file = new File(path);
                if (!file.exists()){
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
                    outputStream.writeObject(user);
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }


    public void clickToNextActivity(View view){
        Intent intent = new Intent(this,SecondPageActivity.class);
        startActivity(intent);
    }
}
