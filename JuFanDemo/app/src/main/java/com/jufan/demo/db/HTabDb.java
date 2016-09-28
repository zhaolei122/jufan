package com.jufan.demo.db;

import com.jufan.demo.bean.HTabBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JER on 2016/9/26.
 */

public class HTabDb {
    private static final List<HTabBean> Selected = new ArrayList<HTabBean>();
    static{
        Selected.add(new HTabBean("关注"));
        Selected.add(new HTabBean("热门"));
        Selected.add(new HTabBean("最新"));
    }
    /***
     * 获得头部tab的所有项
     */
    public static List<HTabBean> getSelected() {
        return Selected;
    }
}
