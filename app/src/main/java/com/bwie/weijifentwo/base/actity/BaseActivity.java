package com.bwie.weijifentwo.base.actity;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.bwie.weijifentwo.R;
import com.bwie.weijifentwo.WJF;
import com.bwie.weijifentwo.base.entity.Singleon;
import com.bwie.weijifentwo.home.entity.Person;
import com.bwie.weijifentwo.utils.Constant;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张瑞凯 on 2016/12/2.
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {


    //宏定义
    public static final int LEFT_IMAGE_RIGHT_IMAGE = 1;//左边照片和右边照片
    public static final int LEFT_IMAGE_RIGHT_TEXT = 2;//左边照片和右边照片
    public static final int LEFT_IMAGE_RIGHT_NO = 3;//左边照片和右边照片
    public static final int LEFT_TEXT_RIGHT_IMAGE = 4;//左边照片和右边照片
    public static final int LEFT_TEXT_RIGHT_TEXT = 5;//左边照片和右边照片
    public static final int LEFT_TEXT_RIGHT_NO = 6;//左边照片和右边照片
    public static final int LEFT_NO_RIGHT_IMAGE = 7;//左边照片和右边照片
    public static final int LEFT_NO_RIGHT_TEXT = 8;//左边照片和右边照片
    public static final int LEFT_NO_RIGHT_NO = 9;//左边照片和右边照片


    private ImageView iv_Left_ImageView;
    private ImageView iv_right_view;
    private TextView tv_left_textview;
    private TextView tv_main_titvitle;
    private TextView tv_right_title_setting;
    private LinearLayout ll_left_layout;


    public  Map<String,String> map;

    //解析数据使用的

    public Gson gson=new Gson();

    //初始化头部
    public abstract void initHelder();

    //初始化 控件
    public abstract void initWiget();

    //实现监听事件
    public abstract void initonclistener();


    //找到所创建的控件

    public void initHelderWiget() {

        map=new HashMap<String, String>();

        map.put("terminalType","MOBIE");
        map.put("os","ANDROID");


        iv_Left_ImageView = (ImageView) findViewById(R.id.iv_Left_ImageView);
        iv_right_view = (ImageView) findViewById(R.id.iv_right_view);
        tv_left_textview = (TextView) findViewById(R.id.tv_left_textview);
        tv_right_title_setting = (TextView) findViewById(R.id.tv_right_title_setting);
        tv_main_titvitle = (TextView) findViewById(R.id.tv_main_titvitle);
        ll_left_layout = (LinearLayout) findViewById(R.id.ll_left_layout);
    }

    public void setLeftImageShow(View.OnClickListener listener) {

        iv_Left_ImageView.setVisibility(View.VISIBLE);
        iv_Left_ImageView.setOnClickListener(listener);

    }

    public void setLeftImageShow(View.OnClickListener listener, int id) {

        iv_Left_ImageView.setVisibility(View.VISIBLE);
        iv_Left_ImageView.setOnClickListener(listener);
        iv_Left_ImageView.setImageResource(id);

    }

    public void setLeftTextShow(View.OnClickListener listener) {

        tv_left_textview.setVisibility(View.VISIBLE);
        tv_left_textview.setOnClickListener(listener);


    }

    public void setLeftTextShow(View.OnClickListener listener, String title) {

        tv_left_textview.setVisibility(View.VISIBLE);
        tv_left_textview.setOnClickListener(listener);
        tv_left_textview.setText(title);

    }

    public void setrightTextShow(View.OnClickListener listener) {

        tv_right_title_setting.setVisibility(View.VISIBLE);
        tv_right_title_setting.setOnClickListener(listener);


    }

    public void setrightTextShow(View.OnClickListener listener, String title) {

        tv_right_title_setting.setVisibility(View.VISIBLE);
        tv_right_title_setting.setOnClickListener(listener);
        tv_right_title_setting.setText(title);

    }

    public void setrightImageShow(View.OnClickListener listener) {

        iv_right_view.setVisibility(View.VISIBLE);
        iv_right_view.setOnClickListener(listener);

    }

    public void setrightImageShow(View.OnClickListener listener, int id) {

        iv_right_view.setVisibility(View.VISIBLE);
        iv_right_view.setOnClickListener(listener);
        iv_right_view.setImageResource(id);

    }


    //设置中间文字内容

    public void setTitle(String title) {
        //设置中间文字的内容

        tv_left_textview.setVisibility(View.GONE);
        tv_right_title_setting.setVisibility(View.GONE);
        tv_main_titvitle.setText(title);
        iv_Left_ImageView.setVisibility(View.GONE);
        iv_right_view.setVisibility(View.GONE);



    }

    public void LeftImage() {
        iv_Left_ImageView.setVisibility(View.VISIBLE);
    }

    public void LeftText() {
        tv_left_textview.setVisibility(View.VISIBLE);
    }

    public void RightImage() {
        iv_right_view.setVisibility(View.VISIBLE);
    }

    public void RightText() {
        tv_right_title_setting.setVisibility(View.VISIBLE);
    }

    public void gone() {
        iv_Left_ImageView.setVisibility(View.GONE);
        tv_left_textview.setVisibility(View.GONE);
        iv_right_view.setVisibility(View.GONE);
        tv_right_title_setting.setVisibility(View.GONE);
    }

    public void setLeftAndRight(int id) {

        switch (id) {

            case LEFT_IMAGE_RIGHT_IMAGE:

                LeftImage();
                RightImage();

                break;
            case LEFT_IMAGE_RIGHT_TEXT:
                LeftImage();
                RightText();
                break;
            case LEFT_IMAGE_RIGHT_NO:
                LeftImage();
                gone();
                break;
            case LEFT_TEXT_RIGHT_IMAGE:
                LeftText();
                RightImage();

                break;
            case LEFT_TEXT_RIGHT_TEXT:
                LeftText();
                RightText();

                break;
            case LEFT_TEXT_RIGHT_NO:
                LeftText();
                gone();
                break;
            case LEFT_NO_RIGHT_IMAGE:
                RightImage();

                break;
            case LEFT_NO_RIGHT_TEXT:
                RightText();
                gone();
                break;
            case LEFT_NO_RIGHT_NO:
                gone();

                break;

        }


    }




}
