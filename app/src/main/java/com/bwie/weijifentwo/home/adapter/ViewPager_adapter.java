package com.bwie.weijifentwo.home.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张瑞凯 on 2016/12/8.
 */
public class ViewPager_adapter extends PagerAdapter{


    List<ImageView> imageViewList=new ArrayList<ImageView>();

    public ViewPager_adapter(List<ImageView> imageViewList) {
        this.imageViewList = imageViewList;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {


        container.removeView(imageViewList.get(position % imageViewList.size()));



    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView=imageViewList.get(position % imageViewList.size());

        if(imageView.getParent()!=null){

            ViewPager viewPager= (ViewPager) imageView.getParent();

            viewPager.removeView(imageView);

        }

        container.addView(imageView);




        return imageView;
    }
}
