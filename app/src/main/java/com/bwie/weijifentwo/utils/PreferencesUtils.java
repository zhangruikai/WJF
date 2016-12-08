package com.bwie.weijifentwo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bwie.weijifentwo.R;

/**
 * Created by 张瑞凯 on 2016/12/8.
 */
public class PreferencesUtils {

    public static SharedPreferences preferences;

    //初始化 SharedPreferences

    public static void init(Context context){

        if(null==preferences){
            preferences = context.getSharedPreferences(context.getString(R.string.app_name),Context.MODE_PRIVATE);
        }
    }

    public static  <T> void put(Context context,String key, T values){

        init(context);

        SharedPreferences.Editor editor = preferences.edit();

        //判断当前是什么类型
        if(values instanceof String){
            editor.putString(key,values.toString());
        }else if(values instanceof Integer){
            editor.putInt(key,((Integer) values).intValue());
        }else if(values instanceof Long){
            editor.putLong(key,((Long) values).longValue());
        }else if(values instanceof Boolean){
            editor.putBoolean(key,((Boolean)values).booleanValue());
        }else if(values instanceof Float){
            editor.putFloat(key,((Float) values).floatValue());
        }

        editor.commit();
        editor.apply();

    }


    //将数据取出来
    // T 默认返回数据
    public static <T> T get(Context context,String key,T values){

        init(context);

        Object o = null;

        if(values instanceof String){
            o = preferences.getString(key,values.toString());
        }else if(values instanceof Integer){
            o = preferences.getInt(key,((Integer) values).intValue());
        }else if(values instanceof Long){
            o = preferences.getLong(key,((Long) values).longValue());
        }else if(values instanceof Boolean){
            o = preferences.getBoolean(key,((Boolean) values).booleanValue());
        }else if(values instanceof Float){
            o = preferences.getFloat(key,((Float) values).floatValue());
        }

        T t = (T)o;

        return t;
    }


    public static void clear() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }


}
