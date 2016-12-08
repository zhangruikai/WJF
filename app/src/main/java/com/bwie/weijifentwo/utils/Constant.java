package com.bwie.weijifentwo.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by 张瑞凯 on 2016/12/5.
 */
public class Constant {

    //封装服务器地址

    public static final String WJF_SERVICE = "http://114.112.104.151:8203/LvScore_Service/";


    public class ServiceConstant {

        /**
         * 发送验证码接口
         */
        public static final String SEND_CODE = "visit/user_getverificationcode.do?";
        /**
         * 验证验证码接口
         */
        public static final String SEND_CODE_Suff ="visit/user_checkVerificationCode.do?";


        /**
         * 注册接口
         */



        public static final String REGISTER_VIP ="visit/user_register.do?";


        /*
             * 获取首页头部接口
             */
        public static final String HOME_TITLE = "visit/getMeun.do?";
        /**
         * 未登陆首页接口
         */
        public static final String NOT_LOGIN_MAIN_FRAGMENT = "visit/noLoginHomePage.do?";

        /**
         * 登陆首页接口
         */
        public static final String NOT_LOGIN_MAIN = "visit/user_login.do?";


    }


//拼接参数的方法

    public static String SetUrl(Map<String, String> map) {

        int index = 0;
        String url = "";

        Iterator<Map.Entry<String, String>> entryIterator = map.entrySet().iterator();

        while (entryIterator.hasNext()) {

            Map.Entry<String, String> entry = entryIterator.next();

            if (index == 0) {
                url += entry.getKey() + "=" + entry.getValue();
            } else {
                url += entry.getKey() + "=" + entry.getValue();
            }
            index++;

        }


        return url;

    }


}
