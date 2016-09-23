package com.jufan.demo.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.jufan.demo.R;
import com.jufan.demo.net.HttpHelper;
import com.jufan.demo.net.api.HttpApi;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private HttpHelper h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyTask mTask = new MyTask();
        mTask.execute(HttpApi.JUFAN_HOT);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

    }
    private class MyTask extends AsyncTask<String, Integer, String> {
        //onPreExecute方法用于在执行后台任务前做一些UI操作
        @Override
        protected void onPreExecute() {

        }

        //doInBackground方法内部执行后台任务,不可在此方法内修改UI
        @Override
        protected String doInBackground(String... params) {

            String result =HttpHelper.getInstance().get(HttpApi.JUFAN_HOT,null);
            return result;
        }



        //onPostExecute方法用于在执行完后台任务后更新UI,显示结果
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();

        }

    }
}
