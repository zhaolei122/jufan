package com.jufan.demo.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.jufan.demo.R;
import com.jufan.demo.bean.NewsBean;
import com.jufan.demo.net.HttpHelper;
import com.jufan.demo.net.api.HttpApi;

import java.util.List;

public class ZhiBoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_bo);
        initweb();
    }
    private void initweb() {
        new AsyncTask<String,Void,String>(){
            private List<NewsBean.ContentBean.ListBean> list;
            @Override
            protected String doInBackground(String... params) {
                String s = HttpHelper.getInstance().get(params[0]);

                return s;
            }
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Gson g = new Gson();
                NewsBean.ContentBean content = g.fromJson(s, NewsBean.class).getContent();
                list = content.getList();
            }
        }.execute(HttpApi.JUFAN_NEW);
    }

}
