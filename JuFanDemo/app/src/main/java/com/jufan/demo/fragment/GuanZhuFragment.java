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

public class GuanZhuFragment extends Fragment implements XListView.IXListViewListener {
    private XListView guanzhuxlv;
    private View view;

    private ArrayAdapter<String> mAdapter;

    //创建适配器

    private ArrayList<String> items = new ArrayList<String>();

    //这个是本例中模拟的数据
    private Handler mHandler;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mainshouye, null);
        initialize();
        mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, items);//用模拟的数据填充系统的adapter
        guanzhuxlv.setAdapter(mAdapter);//指定adapter
        guanzhuxlv.setPullRefreshEnable(true);//下拉刷新
        guanzhuxlv.setPullLoadEnable(false);
        guanzhuxlv.setXListViewListener(this);//给xListView设置监听 ******
        //给xListView条目设置监听事件
        mHandler = new Handler();
        return view;
    }

    private void initialize() {
        guanzhuxlv = (XListView) view.findViewById(R.id.guanzhu_xlv);
    }

    //或的数据后一定要加onLoad()方法，否则刷新会一直进行，根本停不下来
    private void onLoad() {
        guanzhuxlv.stopRefresh();
        guanzhuxlv.stopLoadMore();
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String hehe = dateFormat.format(now);
        guanzhuxlv.setRefreshTime(hehe);

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
