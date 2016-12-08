package com.bwie.weijifentwo.advert.adapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.bwie.weijifentwo.advert.entity.AppMenus;
import com.bwie.weijifentwo.advert.fragment.Fragment_adverts;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 张瑞凯 on 2016/12/5.
 */
public class IndicaterAdapter extends FragmentPagerAdapter {
    //用来刷新的数据
    List<AppMenus> appMenus = new ArrayList<AppMenus>();

    TabPageIndicator mian_tabpageindicator;

    public IndicaterAdapter(FragmentManager fm,TabPageIndicator mian_tabpageindicator) {
        super(fm);
        this.mian_tabpageindicator = mian_tabpageindicator;
    }

    //用来刷新数据的方法
    public void addrest(List<AppMenus> appMenus){
        this.appMenus.clear();
        this.appMenus.addAll(appMenus);
        this.notifyDataSetChanged();
        mian_tabpageindicator.notifyDataSetChanged();
    }
    @Override
    public Fragment getItem(int position) {

        Fragment_adverts fragmentDetail = new Fragment_adverts();
        //fragment 之间传递参数
        Bundle bundle = new Bundle();
        bundle.putString(Fragment_adverts.FRAGMENT_ID,appMenus.get(position).classifyId);
        fragmentDetail.setArguments(bundle);

        return fragmentDetail;
    }

    @Override
    public int getCount() {
        return appMenus.size();
    }

    //用来title的数据
    @Override
    public CharSequence getPageTitle(int position) {

        Log.d("当前标题",appMenus.get(position).name);
        return appMenus.get(position).name;
    }
}
