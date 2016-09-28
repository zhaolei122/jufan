package com.jufan.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jufan.demo.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Timer timer=new Timer();
        SharedPreferences sp = getSharedPreferences("first", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        boolean isfirt=sp.getBoolean("isfirst",true);
        if(isfirt){//第一次进入，引导页面
            editor.putBoolean("isfirst",false).commit();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
                    finish();
                }
            },2000);
        }else {//进入登陆页面

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                    finish();
                }
            },2000);
        }


    }


}
