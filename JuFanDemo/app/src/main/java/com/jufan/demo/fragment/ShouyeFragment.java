package com.jufan.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jufan.demo.R;
import com.jufan.demo.activity.FuHaoActivity;
import com.jufan.demo.activity.SearchActivity;
import com.jufan.demo.util.IntentUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JER on 2016/9/27.
 */

public class ShouyeFragment extends Fragment implements View.OnClickListener{

    private View shouye;
    private ImageView searchimgid;
    private RadioButton gboneid;
    private RadioButton gbtwoid;
    private RadioButton gbthreeid;
    private RadioGroup gpid;
    private LinearLayout lallid;
    private ImageView championimgid;
    private ViewPager vpid;
    private List<Fragment> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        shouye = inflater.inflate(R.layout.fragment_shouye,null);
        initialize();
        initFragment();

        vpid.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));
        vpid.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        gboneid.setChecked(true);
                        gboneid.setTextSize(25);
                        gbtwoid.setTextSize(17);
                        gbthreeid.setTextSize(17);
                        break;
                    case 1:
                        gbtwoid.setChecked(true);
                        gbtwoid.setTextSize(25);
                        gboneid.setTextSize(17);
                        gbthreeid.setTextSize(17);
                        break;
                    case 2:
                        gbthreeid.setChecked(true);
                        gbthreeid.setTextSize(25);
                        gbtwoid.setTextSize(17);
                        gboneid.setTextSize(17);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return shouye;
    }




    private void initFragment() {
        GuanZhuFragment guanzhu = new GuanZhuFragment();
        HoeFragment hot = new HoeFragment();
        NewFragment news = new NewFragment();
        list.add(guanzhu);
        list.add(hot);
        list.add(news);




    }
    //添加fragment
    private void initialize() {
        searchimgid = (ImageView) shouye.findViewById(R.id.search_img_id);
        gboneid = (RadioButton) shouye.findViewById(R.id.gb_one_id);
        gbtwoid = (RadioButton) shouye.findViewById(R.id.gb_two_id);
        gbthreeid = (RadioButton) shouye.findViewById(R.id.gb_three_id);
        gpid = (RadioGroup) shouye.findViewById(R.id.gp_id);
        lallid = (LinearLayout) shouye.findViewById(R.id.l_all_id);
        championimgid = (ImageView) shouye.findViewById(R.id.champion_img_id);
        vpid = (ViewPager) shouye.findViewById(R.id.vp_id);
        searchimgid.setOnClickListener(this);
        championimgid.setOnClickListener(this);
        gboneid.setOnClickListener(this);
        gbtwoid.setOnClickListener(this);
        gbthreeid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_img_id:
                IntentUtils.intentClass(getActivity(), SearchActivity.class);
                break;
            case R.id.gb_one_id:
                vpid.setCurrentItem(0);

                gboneid.setTextSize(25);
                gbtwoid.setTextSize(17);
                gbthreeid.setTextSize(17);
                break;
            case R.id.gb_two_id:
                vpid.setCurrentItem(1);

                gbtwoid.setTextSize(25);
                gboneid.setTextSize(17);
                gbthreeid.setTextSize(17);
                break;
            case R.id.gb_three_id:
                vpid.setCurrentItem(2);
                gbthreeid.setTextSize(25);
                gbtwoid.setTextSize(17);
                gboneid.setTextSize(17);
                break;
            case R.id.champion_img_id:
                IntentUtils.intentClass(getActivity(), FuHaoActivity.class);
                break;

        }
    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

}
