package com.sx.banner.adapter;

import android.view.View;

/**
 * @Author sunxin
 * @Date 2017/9/5 17:06
 * @Description Adapter模式
 */

public abstract class BannerAdapter {

    /**
     * 根据位置获取ViewPager的子View
     *
     * @param position
     * @return
     */
    public abstract View getView(int position, View convertView);

    /**
     * 获取轮播图的数量
     *
     * @return
     */
    public abstract int getCount();

    /**
     * 广告位描述
     *
     * @param position
     * @return
     */
    public String getBannerDesc(int position){
        return "";
    }
}
