package com.example.iot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.pusher.pushnotifications.PushNotifications;



public class MainActivity extends AppCompatActivity {

    private TextView nilai1;
    private TextView nilai2;
    private TextView nilai3;
    private TextView nilai4;

    private Firebase mRef1;
    private Firebase mRef2;
    private Firebase mRef3;
    private Firebase mRef4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushNotifications.start(getApplicationContext(), "49b0dce3-1eea-426d-bdf4-966979bbda02");
        PushNotifications.addDeviceInterest("hello");

        nilai1 = (TextView) findViewById (R.id.nilai1);
        nilai2 = (TextView) findViewById (R.id.nilai2);
        nilai3 = (TextView) findViewById (R.id.nilai3);
        nilai4 = (TextView) findViewById (R.id.nilai4);

        mRef1 = new Firebase ("https://sensoriot-39203.firebaseio.com/api");
        mRef2 = new Firebase ("https://sensoriot-39203.firebaseio.com/smoke1");
        mRef3 = new Firebase ("https://sensoriot-39203.firebaseio.com/smoke2");
        mRef4 = new Firebase ("https://sensoriot-39203.firebaseio.com/suhu");

        mRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String api = dataSnapshot.getValue(String.class);
                Log.d("nilai1",""+api);
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
                nilai4.setText(suhu + " °C");
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
