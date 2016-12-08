package com.bwie.weijifentwo.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.weijifentwo.R;
import com.bwie.weijifentwo.base.entity.BaseFragment;

/**
 * Created by 张瑞凯 on 2016/12/2.
 */
public class FragmentAdvert extends BaseFragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_advert,null);
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

    }

    @Override
    public void initWiget() {

    }

    @Override
    public void initonclistener() {

    }

    @Override
    public void onClick(View view) {

    }
}
