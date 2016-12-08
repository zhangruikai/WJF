package com.bwie.weijifentwo.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.bwie.weijifentwo.R;
import com.bwie.weijifentwo.WJF;
import com.bwie.weijifentwo.base.actity.MainActivity;
import com.bwie.weijifentwo.base.entity.BaseFragment;
import com.bwie.weijifentwo.base.entity.Singleon;
import com.bwie.weijifentwo.home.adapter.IndicaterAdapter;
import com.bwie.weijifentwo.home.entity.AppMenus;
import com.bwie.weijifentwo.home.entity.Title;
import com.bwie.weijifentwo.home.entity.TitleData;
import com.bwie.weijifentwo.utils.Constant;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张瑞凯 on 2016/12/2.
 */
public class FragmentHome extends BaseFragment {

    //注册上下文
    MainActivity mainActivity;
    private ViewPager vp_fragment_home_detail;
    private IndicaterAdapter adapter;
    private TabPageIndicator mian_tabpageindicator;

    public List<AppMenus> appMenus = new ArrayList<AppMenus>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHelder();
        initWiget();
        initonclistener();
    }

    @Override
    public void initHelder() {
        //获得上下文对象

        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void initWiget() {

        vp_fragment_home_detail = (ViewPager) getView().findViewById(R.id.vp_fragment_home_detail);

        mian_tabpageindicator = (TabPageIndicator) getView().findViewById(R.id.mian_tabpageindicator);


        adapter = new IndicaterAdapter(getActivity().getSupportFragmentManager(),mian_tabpageindicator);

        vp_fragment_home_detail.setAdapter(adapter);

        mian_tabpageindicator.setViewPager(vp_fragment_home_detail);

    }

    @Override
    public void initonclistener() {
        mian_tabpageindicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                Log.d("当前位置", position + " ");

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();

        getTitle();

    }

    public void getTitle() {




        String url = Constant.WJF_SERVICE + Constant.ServiceConstant.HOME_TITLE + Constant.SetUrl(mainActivity.map);

        WJF.singleon.geturl(url, getActivity(), new Singleon.ResuleCallBack() {
            @Override
            public void onResponse(String response) {

                Title title = mainActivity.gson.fromJson(response, Title.class);

                TitleData titleData = title.data;
                appMenus = titleData.appMenus;

                Log.d("appMenus",appMenus+"--------------");

                adapter.addrest(appMenus);

                Log.d("response", response);


            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


    }
}