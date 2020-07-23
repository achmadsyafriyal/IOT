package com.example.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //inisialisasi text nilai

    private TextView nilai1;
    private TextView nilai2;
    private TextView nilai3;
    private TextView nilai4;
    private TextView Status;



    //buat reference untuk firebase (koneksi server / host firebase)

    private Firebase mRef1;
    private Firebase mRef2;
    private Firebase mRef3;
    private Firebase mRef4;
    private Firebase mRef5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nilai1 = (TextView) findViewById (R.id.nilai1);
        nilai2 = (TextView) findViewById (R.id.nilai2);
        nilai3 = (TextView) findViewById (R.id.nilai3);
        nilai4 = (TextView) findViewById (R.id.nilai4);
        Status = (TextView) findViewById (R.id.Status);

        mRef1 = new Firebase ("https://sensoriot-39203.firebaseio.com/api");
        mRef2 = new Firebase ("https://sensoriot-39203.firebaseio.com/smoke1");
        mRef3 = new Firebase ("https://sensoriot-39203.firebaseio.com/smoke2");
        mRef4 = new Firebase ("https://sensoriot-39203.firebaseio.com/suhu");
        mRef5 = new Firebase ("https://sensoriot-39203.firebaseio.com/status");

        mRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String api = dataSnapshot.getValue(String.class);
                nilai1.setText(api);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        mRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String smoke1 = dataSnapshot.getValue(String.class);
                        nilai2.setText(smoke1);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        mRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String smoke2 = dataSnapshot.getValue(String.class);
                nilai3.setText(smoke2);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        mRef4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String suhu = dataSnapshot.getValue(String.class);
                nilai4.setText(suhu);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        mRef5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String status = dataSnapshot.getValue(String.class);
                Status.setText(status);
           }
           @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
       });

    }
    public void panduan  (View view) {
        Intent intent = new Intent(MainActivity. this, Panduan.class);
        startActivity(intent);
    }
}
