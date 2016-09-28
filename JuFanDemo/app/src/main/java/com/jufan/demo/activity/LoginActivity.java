package com.jufan.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.jufan.demo.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //找到控件
        ImageView qq=(ImageView) findViewById(R.id.qq);
        ImageView weixin=(ImageView) findViewById(R.id.weixin);
        ImageView phone=(ImageView) findViewById(R.id.phone);
        ImageView weibo=(ImageView) findViewById(R.id.weibo);

        weixin.setOnClickListener(this);
    }
    //点击登陆事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.qq:

                break;
            case R.id.weixin:
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
                break;
            case R.id.phone:
                break;
            case R.id.weibo:
                break;
        }
    }
}
