package com.bwie.weijifentwo.base.actity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.weijifentwo.R;

/**
 * Created by 张瑞凯 on 2016/12/7.
 */
public class Login_main_page extends Activity implements View.OnClickListener {

    public Button bt_logmain_login;
    public Button bt_zhucenmain_login;
    public TextView tv_login_name;
    public TextView tv_login_password;
    public TextView tv_login_wangpassword;
    private String name;
    private String telNum;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_pager_layout);

        initdata();
        setonlinlister();
    }


    //创建一个找控件方法
    public void initdata() {




        //登录按钮控件
        bt_logmain_login = (Button) findViewById(R.id.bt_logmain_login);
        //注册按钮控件
        bt_zhucenmain_login = (Button) findViewById(R.id.bt_zhucenmain_login);
        //输入用户名控件
        tv_login_name = (TextView) findViewById(R.id.tv_login_name);
        //输入密码控件
        tv_login_password = (TextView) findViewById(R.id.tv_login_password);
        //忘记密码控件
        tv_login_wangpassword = (TextView) findViewById(R.id.tv_login_wangpassword);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        telNum = intent.getStringExtra("telNum");

        password = intent.getStringExtra("password");

        tv_login_name.setText(telNum);

        tv_login_password.setText(password);



        SharedPreferences preferences = getSharedPreferences("aa", MODE_PRIVATE);


        preferences.edit().putString("telNum", telNum).
                putString("password", password).commit();


    }


    //设置监听控件

    public void setonlinlister() {
        //登录监听
        bt_logmain_login.setOnClickListener(this);
        //注册监听
        bt_zhucenmain_login.setOnClickListener(this);
        //忘记密码监听
        tv_login_wangpassword.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            //登录按钮控件
            case R.id.bt_logmain_login:
                if (null == tv_login_name && null == tv_login_password) {
                    Toast.makeText(Login_main_page.this, "用户名或密码不能为空~", Toast.LENGTH_LONG).show();
                } else {
                        if (tv_login_name.equals(telNum) && tv_login_password.equals(password)) {

                            SharedPreferences preferences = getSharedPreferences("config", MODE_PRIVATE);

                            preferences.edit().putBoolean("flag",true).commit();

                            Toast.makeText(Login_main_page.this, "登录成功~", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Login_main_page.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                        }

                }


                break;
            //注册按钮控件
            case R.id.bt_zhucenmain_login:

                Intent intent1 = new Intent(Login_main_page.this, SendcodeActivity.class);

                startActivity(intent1);

                finish();

                break;
            //忘记密码控件
            case R.id.tv_login_wangpassword:


                break;


        }


    }
}
