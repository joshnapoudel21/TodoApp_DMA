package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_msg);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("todo_pref", 0);
                Boolean authentication = preferences.getBoolean("authentication", false);
                if(authentication){
                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class
                    );
                    startActivity(intent);
                }else{
                    Intent intent =  new Intent(WelcomeActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 4000);
    }
}