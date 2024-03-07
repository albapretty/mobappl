package com.example.group4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LocationMap extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_map);

        Button button3 = findViewById(R.id.button5);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/maps/place/Ateneoville+Covered+Court/@14.6696661,121.110366,19z/data=!3m1!4b1!4m6!3m5!1s0x3397b988d7b17a1f:0x6a0f89bd8a7454f9!8m2!3d14.6696648!4d121.1110111!16s%2Fg%2F11gg6m_lnn?entry=ttu");
            }
        });

    }

        private void gotoUrl(String s) {
            Uri uri = Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW,uri));


    }
}
