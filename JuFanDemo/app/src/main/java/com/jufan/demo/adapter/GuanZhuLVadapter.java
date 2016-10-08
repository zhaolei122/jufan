package com.jufan.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jufan.demo.R;

/**
 * Created by JER on 2016/10/7.
 */

public class GuanZhuLVadapter extends BaseAdapter {
    private Context context;

    public GuanZhuLVadapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView ==null){
            convertView = View.inflate(context, R.layout.list_item,null);
        }

        return convertView;
    }
}
