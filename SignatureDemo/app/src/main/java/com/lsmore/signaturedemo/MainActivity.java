package com.lsmore.signaturedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.simplify.ink.InkView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    InkView inkView;
    String savePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inkView = (InkView) findViewById(R.id.inkView);
        inkView.setColor(getResources().getColor(android.R.color.holo_red_dark));
        inkView.setMinStrokeWidth(1.5f);
        inkView.setMaxStrokeWidth(6f);
        inkView.setFlags(InkView.FLAG_INTERPOLATION);
        Log.e("Test", (Utils.isSDCardMounted()?Utils.getSDCardBaseDir():"no sdcard mounted")+ "free size:"+Utils.getSDCardFreeSize());

    }

    public void onResume(){
        super.onResume();
       Log.e("Test", Utils.isSDCardMounted()?Utils.getSDCardBaseDir():"no sdcard mounted");
    }



    public void onReset(View view){
        inkView.clear();
    }

    public void onSaveSingature(View view){
      final Bitmap bitmap = inkView.getBitmap(getResources().getColor(android.R.color.white));
        new Thread(new Runnable() {
            @Override
            public void run() {





                File file = new File(Utils.getSDCardBaseDir()+"/"+"singnature");
                if (!file.exists()){

                        file.mkdirs();

                }

                File file2 = new File(Utils.getSDCardBaseDir()+"/"+"singnature/"+new Date().getTime()+".png");
                try {
                    OutputStream outputStream = new FileOutputStream(file2);
                    bitmap.compress(Bitmap.CompressFormat.PNG,88,outputStream);
                    outputStream.flush();
                    outputStream.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }




            }
        }).start();
    }
}
