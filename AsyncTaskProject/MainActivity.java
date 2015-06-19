package com.example.hp.asynctaskproject;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.InputStream;
import java.net.URL;


public class MainActivity extends ActionBarActivity {
    // create a button
    private static Button LoadImageBnt;
    // create an frame that holds an image
    private static ImageView frame;
    // create a bitmap image
    private static Bitmap image;
    // create a status "Wait"
    private static ProgressDialog Wait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DownloadImageClick(View view) {
        // assign button id in activity_main.xml to LoadImgBnt
        LoadImageBnt = (Button) findViewById(R.id.button);
        // assign imageView id in activity_main.xml to frame
        frame = (ImageView) findViewById(R.id.imageView);
        // set on click listener when users hit Download Image From GitHub button
        LoadImageBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load image from GitHub
                new LoadImage().execute("https://raw.githubusercontent.com/tronglegit/CS6392015/master/AsyncTaskProject/boston-heart.jpg");

            }
        });


    }


    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            // message "Image is loading. Be Patient in the background while image is loading to phone
            Wait = new ProgressDialog(MainActivity.this);
            Wait.setMessage("Image is loading. Be Patient (^_^)");
            Wait.show();

        }
        protected Bitmap doInBackground(String... args) {
            try {
                // getting image on the background thread
                image = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return image;
        }

        protected void onPostExecute(Bitmap downloadedImage) {
            // done!
            if(downloadedImage != null){
                frame.setImageBitmap(downloadedImage);
                Wait.dismiss();

            }
            else{

                Wait.dismiss();

                // a message to be displayed if image does not load or any problem with network connection
                Toast.makeText(MainActivity.this, "Errors. Check your Network or Image does not exist", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
