package com.example.project_ppkd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private int waktu_loading = 3000; //400 ms = 4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed (new Runnable() {
            @Override
            public void run(){
                //setelah loading 4 detik, akan berpindah ke menu utama
                Intent welcome = new Intent(MainActivity.this, Welcome.class);
                startActivity(welcome);
                finish();
            }
        },waktu_loading);
    }
}