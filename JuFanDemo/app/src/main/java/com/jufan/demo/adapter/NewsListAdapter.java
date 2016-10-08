package com.jufan.demo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.jufan.demo.R;
import com.jufan.demo.bean.NewsBean;

import java.util.List;

/**
 * Created by JER on 2016/9/28.
 */

public class NewsListAdapter extends BaseAdapter {

    private Context context;
    private List<NewsBean.ContentBean.ListBean> list;
    private TextView textView4;
    private ImageView newgvimage;
    private TextView textView3;
    private TextView textView5;

    public NewsListAdapter(Context context,List<NewsBean.ContentBean.ListBean> list){
        super();
        this.context = context;
        this.list=list;

    }

    @Override
    public int getCount() {
        return list.size();
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
        final ViewHolder holder;
        if (convertView ==null){
            convertView = View.inflate(context,R.layout.fragment_news_gvitem,null);
            holder = new ViewHolder();

            holder.textView4 = (TextView) convertView.findViewById(R.id.textView4);
            holder.newgvimage = (ImageView) convertView.findViewById(R.id.new_gv_image);
            holder.textView3 = (TextView) convertView.findViewById(R.id.textView3);
            holder.textView5 = (TextView) convertView.findViewById(R.id.textView5);
            convertView.setTag(holder);
       }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textView3.setText(list.get(position).getName());
        holder.textView4.setText(list.get(position).getPlace());
        holder.textView5.setText("LIVE "+list.get(position).getOnline());
        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(
                list.get(position).getSmallheadimg(),
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        holder.newgvimage.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                holder.newgvimage.setImageResource(R.drawable.li_default_head);
            }
        });
        mQueue.add(imageRequest);
        return convertView;
    }
    static class ViewHolder  {
        TextView textView4,textView3,textView5;
        ImageView newgvimage;
    }
}
