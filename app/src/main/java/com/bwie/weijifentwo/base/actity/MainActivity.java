package com.bwie.weijifentwo.base.actity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.VolleyError;
import com.bwie.weijifentwo.R;
import com.bwie.weijifentwo.WJF;
import com.bwie.weijifentwo.base.entity.ShowFragment;
import com.bwie.weijifentwo.base.entity.Singleon;
import com.bwie.weijifentwo.base.fragment.FragmentAdvert;
import com.bwie.weijifentwo.base.fragment.FragmentAppy;
import com.bwie.weijifentwo.base.fragment.FragmentGoods;
import com.bwie.weijifentwo.base.fragment.FragmentHome;
import com.bwie.weijifentwo.base.fragment.FragmentMy;
import com.bwie.weijifentwo.home.entity.Person;
import com.bwie.weijifentwo.utils.Constant;
import com.bwie.weijifentwo.utils.PreferencesUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张瑞凯 on 2016/12/2.
 */
public class MainActivity extends BaseActivity {


    private Button bt_main_home;
    private Button bt_main_advert;
    private Button bt_main_apply;
    private Button bt_main_goods;
    private Button bt_main_my;
    private FragmentAdvert fragmentadvert;
    private FragmentHome fragmenthome;
    private FragmentAppy fragmentapply;
    private FragmentGoods fragmentgoods;
    private FragmentMy fragmentmy;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    //创建一个添加Fragment的集合

    List<ShowFragment> fragmentList = new ArrayList<ShowFragment>();
    private SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            initHelder();
            //初始化控件
            initWiget();
            //设置监听事件
            initonclistener();
     }





    //初始化头部
    @Override
    public void initHelder() {

        initHelderWiget();

        setTitle("首页");





    }

    //初始化控件
    @Override
    public void initWiget() {


        bt_main_home = (Button) findViewById(R.id.bt_main_home);
        bt_main_advert = (Button) findViewById(R.id.bt_main_advert);
        bt_main_apply = (Button) findViewById(R.id.bt_main_apply);
        bt_main_goods = (Button) findViewById(R.id.bt_main_goods);
        bt_main_my = (Button) findViewById(R.id.bt_main_my);
        //获得一个管理者

        manager = getSupportFragmentManager();
        fragmentadvert = new FragmentAdvert();
        fragmenthome = new FragmentHome();
        fragmentapply = new FragmentAppy();
        fragmentgoods = new FragmentGoods();
        fragmentmy = new FragmentMy();


        addfragmentList();
        addfragment(0);


    }

    public void addfragmentList() {

        for (int i = 0; i < 5; i++) {

            ShowFragment fragment = new ShowFragment();

            switch (i) {
                case 0:
                    fragment.fragment = fragmenthome;

                    break;
                case 1:
                    fragment.fragment = fragmentadvert;
                    break;
                case 2:
                    fragment.fragment = fragmentapply;
                    break;
                case 3:
                    fragment.fragment = fragmentgoods;
                    break;
                case 4:
                    fragment.fragment = fragmentmy;
                    break;
            }
            fragmentList.add(fragment);
        }
    }


    //加载Fragment

    public void addfragment(int position) {

        //获得事务
        transaction = manager.beginTransaction();
        //判断fragmentLit的长度进行添加
        for (int i = 0; i <fragmentList.size(); i++) {
            //如果长度不等于所定义的坐标则隐藏
            if (i!=position){
                transaction.hide(fragmentList.get(i).fragment);
            }
        }
        //如果定义的坐标与fragment的显示标记相等那么就添加显示并且坐标加1
        if (fragmentList.get(position).statue == 0) {
            transaction.add(R.id.fragmnet_count, fragmentList.get(position).fragment, position + "");
            fragmentList.get(position).statue = 1;
            transaction.show(fragmentList.get(position).fragment);
        } else {
            //如果不相等则显示当前fragment
            transaction.show(fragmentList.get(position).fragment);
        }

        transaction.commit();
    }

    //展示Fragment
    public void showFragment(Fragment addfragment, Fragment hide1,Fragment hide2, Fragment hide3, Fragment hide4) {

        transaction.hide(hide1).hide(hide2).hide(hide3).hide(hide4).show(addfragment).commit();
    }

    //设置监听
    @Override
    public void initonclistener() {
        bt_main_home.setOnClickListener(this);
        bt_main_advert.setOnClickListener(this);
        bt_main_apply.setOnClickListener(this);
        bt_main_goods.setOnClickListener(this);
        bt_main_my.setOnClickListener(this);

        setTouchButtonFour(R.id.bt_main_home);


        setLeftAndRight(LEFT_IMAGE_RIGHT_NO);

    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.bt_main_home:

                setTouchButtonFour(R.id.bt_main_home);
                setLeftAndRight(LEFT_IMAGE_RIGHT_NO);
                addfragment(0);
                break;
            case R.id.bt_main_advert:
                setTouchButtonFour(R.id.bt_main_advert);
                setLeftAndRight(LEFT_NO_RIGHT_IMAGE);
                addfragment(1);
                break;
            case R.id.bt_main_apply:
                setTouchButtonFour(R.id.bt_main_apply);
                setLeftAndRight(LEFT_IMAGE_RIGHT_IMAGE);
                addfragment(2);
                break;
            case R.id.bt_main_goods:
                setTouchButtonFour(R.id.bt_main_goods);
                setLeftAndRight(LEFT_NO_RIGHT_IMAGE);
                addfragment(3);
                break;
            case R.id.bt_main_my:
                setTouchButtonFour(R.id.bt_main_my);
                setLeftAndRight(LEFT_NO_RIGHT_NO);
                addfragment(4);
                break;


        }

    }


    public void setTouchButtonFour(int position) {

        switch (position) {

            case R.id.bt_main_home:

                bt_main_my.setSelected(false);
                bt_main_goods.setSelected(false);
                bt_main_apply.setSelected(false);
                bt_main_advert.setSelected(false);
                bt_main_home.setSelected(true);
                setTitle("首页");

                break;
            case R.id.bt_main_advert:
                bt_main_my.setSelected(false);
                bt_main_goods.setSelected(false);
                bt_main_apply.setSelected(false);
                bt_main_advert.setSelected(true);
                bt_main_home.setSelected(false);
                setTitle("广告");
                break;
            case R.id.bt_main_apply:
                bt_main_my.setSelected(false);
                bt_main_goods.setSelected(false);
                bt_main_apply.setSelected(true);
                bt_main_advert.setSelected(false);
                bt_main_home.setSelected(false);
                setTitle("应用");
                break;
            case R.id.bt_main_goods:
                bt_main_my.setSelected(false);
                bt_main_goods.setSelected(true);
                bt_main_apply.setSelected(false);
                bt_main_advert.setSelected(false);
                bt_main_home.setSelected(false);
                setTitle("商店");
                break;
            case R.id.bt_main_my:
                bt_main_my.setSelected(true);
                bt_main_goods.setSelected(false);
                bt_main_apply.setSelected(false);
                bt_main_advert.setSelected(false);
                bt_main_home.setSelected(false);
                setTitle("我的");
                break;


        }


    }
    public void getData() {

        //添加参数
        map.put("cate","yzdr");
        map.put("pageno","1");
        map.put("pagenum","10");
        map.put("__version","1.0.1.1300");
        map.put("__plat","android");

        String url = Constant.WJF_SERVICE+Constant.SetUrl(map);

        WJF.singleon.geturl(url,getApplicationContext(),new Singleon.ResuleCallBack(){
            @Override
            public void onResponse(String response) {


                Gson gson = new Gson();
                Person person = gson.fromJson(response,Person.class);
                Log.d("person",person.toString());
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    @Override
    protected void onDestroy() {


        super.onDestroy();








    }

}
