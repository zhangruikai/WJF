package com.bwie.weijifentwo.home.entity;

/**
 * 作    者：张瑞凯
 * 时    间：16/12/4
 * 描    述：
 * 修改时间：
 */
public class Person {

    public String errno;
    public String errmsg;
    public Data data;


    @Override
    public String toString() {
        return "Person{" +
                "errno='" + errno + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }
}
