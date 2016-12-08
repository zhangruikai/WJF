package com.bwie.weijifentwo.base.entity;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
/**
 * Created by 张瑞凯 on 2016/12/2.
 */
public class Singleon {

    private static volatile Singleon singleton;
    private RequestQueue mQueue;
    private StringRequest stringRequest;

    private Singleon() {

    }

    public static Singleon getInStance() {


        if(singleton==null){

            synchronized (Singleon.class){

                if(singleton==null){

                 singleton=new Singleon();

                }
            }
        }

        return  singleton;

    }

//get网络请求

    //get 网络请求
    public void geturl(String url, Context context, final ResuleCallBack resuleCallBack) {

        //声明队列
        RequestQueue mQueue = Volley.newRequestQueue(context);

        //接口回调
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        resuleCallBack.onResponse(response);

                        //内部类访问外部类的时候会隐式的持有外部类的对象的锁.
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                resuleCallBack.onErrorResponse(error);
            }
        });

        //加入队列
        mQueue.add(stringRequest);

        //需要通过接口回调的方式将数据传递activity
        //接口回调方式有两种
        //1:抽象类里面放抽象方法
        //2:写观察者模式

    }









    //接口回调先创建抽象类进行接口回调


    public static abstract class ResuleCallBack{

        public abstract void onResponse(String response);

        public abstract void onErrorResponse(VolleyError error);
    }






}
