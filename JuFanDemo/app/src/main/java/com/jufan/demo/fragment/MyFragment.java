package com.jufan.demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jufan.demo.R;

/**
 * Created by JER on 2016/9/27.
 */

public class MyFragment extends Fragment {
    private View my;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        my = inflater.inflate(R.layout.fragment_my,null);

        return my;
    }
}
