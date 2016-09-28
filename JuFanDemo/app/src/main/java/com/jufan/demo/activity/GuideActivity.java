package com.jufan.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jufan.demo.R;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {
    private ArrayList<View> list = new ArrayList<View>();
    private ViewPager vp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        vp = (ViewPager) findViewById(R.id.vp);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v1 = inflater.inflate(R.layout.layout1, null);
        View v2 = inflater.inflate(R.layout.layout2, null);
        View v3 = inflater.inflate(R.layout.layout3, null);
        ImageView imageView3=(ImageView) v3.findViewById(R.id.image_three);
        list.add(v1);
        list.add(v2);
        list.add(v3);
        //适配器
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(list.get(position));
                return list.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击跳转登陆页面
                startActivity(new Intent(GuideActivity.this,LoginActivity.class));
                finish();
            }
        });

    }
}
