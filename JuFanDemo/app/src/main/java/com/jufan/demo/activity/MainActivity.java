package com.jufan.demo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jufan.demo.R;
import com.jufan.demo.fragment.MyFragment;
import com.jufan.demo.fragment.ShouyeFragment;
import com.jufan.demo.util.IntentUtils;

public class MainActivity extends FragmentActivity implements View.OnClickListener{


    private RadioButton rbmy;
    private ImageView rbonwer;
    private RadioGroup sygpid;
    private RadioButton rbshouye;
    private FrameLayout mainfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //查找控件

        initialize();
        //进入app首先展示HomeFragment
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new ShouyeFragment(), "ShouyeFragment").commit();
    }



    private void initialize() {
        rbmy = (RadioButton) findViewById(R.id.rb_my);
        rbonwer = (ImageView) findViewById(R.id.rb_onwer);
        sygpid = (RadioGroup) findViewById(R.id.sy_gp_id);
        rbshouye = (RadioButton) findViewById(R.id.rb_shouye);
        mainfragment = (FrameLayout) findViewById(R.id.main_fragment);
        rbmy.setOnClickListener(this);
        rbshouye.setOnClickListener(this);
        rbonwer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.rb_onwer:
                IntentUtils.intentClass(MainActivity.this,OnwerActivity.class);
                break;
            case R.id.rb_shouye:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new ShouyeFragment(), "ShouyeFragment").commit();
                break;
            case R.id.rb_my:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new MyFragment(), "MyFragment").commit();
                break;
        }
    }
}
