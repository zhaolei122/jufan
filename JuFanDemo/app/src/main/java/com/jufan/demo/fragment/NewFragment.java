package com.jufan.demo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jufan.demo.R;
import com.jufan.demo.view.xlistview.XListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JER on 2016/9/27.
 */

public class NewFragment extends Fragment implements XListView.IXListViewListener{

    private View news;
    private XListView newsxlv;
    private ArrayAdapter<String> mAdapter;

    //创建适配器

    private ArrayList<String> items = new ArrayList<String>();

    //这个是本例中模拟的数据
    private Handler mHandler;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        news = inflater.inflate(R.layout.fragment_new,null);
        initialize();
        mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, items);//用模拟的数据填充系统的adapter
        newsxlv.setAdapter(mAdapter);//指定adapter
        newsxlv.setPullRefreshEnable(true);//下拉刷新
        newsxlv.setPullLoadEnable(false);
        newsxlv.setXListViewListener(this);//给xListView设置监听 ******
        //给xListView条目设置监听事件
        mHandler = new Handler();
        return news;
    }

    private void initialize() {

        newsxlv = (XListView) news.findViewById(R.id.news_xlv);
    }
    //或的数据后一定要加onLoad()方法，否则刷新会一直进行，根本停不下来
    private void onLoad() {
        newsxlv.stopRefresh();
        newsxlv.stopLoadMore();
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String hehe = dateFormat.format(now);
        newsxlv.setRefreshTime(hehe);
    }
    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoad();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoad();
            }

        }, 2000);

    }
}
