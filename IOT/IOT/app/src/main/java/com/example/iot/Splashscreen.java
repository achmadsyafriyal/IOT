package com.example.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Thread thread = new Thread() {
            public void run (){
                try {
                    sleep(1100);
                } catch (InterruptedException e ) {
                    e.printStackTrace();
            }finally {
                    startActivity(new Intent(Splashscreen.this, MainActivity.class));
                    finish();
                }
                }
        };
        thread.start();
    }
}