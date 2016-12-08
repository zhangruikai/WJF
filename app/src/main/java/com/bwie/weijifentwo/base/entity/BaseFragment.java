package com.bwie.weijifentwo.base.entity;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by 张瑞凯 on 2016/12/2.
 */
public abstract  class BaseFragment extends Fragment implements View.OnClickListener{

    //初始化头部
    public abstract void initHelder();

    //初始化 控件
    public abstract void initWiget();

    //实现监听事件
    public abstract void initonclistener();

    @Override
    public void onClick(View view) {

    }
}
