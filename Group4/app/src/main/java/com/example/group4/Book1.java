package com.example.group4;// MainActivity.java
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.net.Uri;
import android.app.DownloadManager;


import androidx.appcompat.app.AppCompatActivity;

public class Book1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book1);

        Button button7 = findViewById(R.id.button7);
        Button downloadButton = findViewById(R.id.button13);



        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileUrl = "https://api.papermc.io/v2/projects/paper/versions/1.20.1/builds/196/downloads/paper-1.20.1-196.jar";
                downloadFile(fileUrl);
            }

            private void downloadFile(String fileUrl) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(fileUrl));
                request.setTitle("File Download");
                request.setDescription("Downloading file...");

                // Set the destination folder for the downloaded file
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "bamboo.java");

                // Get the DownloadManager system service
                DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

                // Enqueue the download request
                if (manager != null) {
                    manager.enqueue(request);
                }
            }
        });


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.guaduabamboo.com/bamboo-pdfs/");
            }
        });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));


    }
}

