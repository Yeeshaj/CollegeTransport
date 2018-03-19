package com.example.dellpc.collegetransport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {
SharedPreferences sp;
    SharedPreferences.Editor se;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sp=getSharedPreferences("Login",MODE_PRIVATE);
        se=sp.edit();
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent i=new Intent(splash.this,LoginAdmin.class);
                startActivity(i);


            }
        },1000);
        se.putString("name","admin");
        se.putString("pass","admin");

    }
}
