package com.jufan.demo.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.jufan.demo.R;
import com.jufan.demo.activity.ZhiBoActivity;
import com.jufan.demo.adapter.NewsListAdapter;
import com.jufan.demo.bean.NewsBean;
import com.jufan.demo.net.HttpHelper;
import com.jufan.demo.net.api.HttpApi;
import com.jufan.demo.view.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JER on 2016/9/27.
 */

public class NewFragment extends Fragment{

    private View news;
    private XListView newsxlv;
    private NewsListAdapter mAdapter;
    //创建适配器
    private ArrayList<String> items = new ArrayList<String>();
    //这个是本例中模拟的数据
    private Handler mHandler;
    private GridView newsgv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        news = inflater.inflate(R.layout.fragment_new,null);
        initialize();
        initweb();//异步网络请求
        return news;
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
                NewsListAdapter adapter = new NewsListAdapter(getActivity(),list);
                newsgv.setAdapter(adapter);
            }
        }.execute(HttpApi.JUFAN_NEW);
    }


    private void initialize() {

        newsgv = (GridView) news.findViewById(R.id.news_gv);
        newsgv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ZhiBoActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }
}
