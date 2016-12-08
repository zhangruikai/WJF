package com.bwie.weijifentwo.base.actity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bwie.weijifentwo.R;
import com.bwie.weijifentwo.WJF;
import com.bwie.weijifentwo.base.entity.Singleon;
import com.bwie.weijifentwo.home.entity.RegisterData;
import com.bwie.weijifentwo.utils.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张瑞凯 on 2016/12/7.
 */
public class Register_Activity extends Activity implements View.OnClickListener{

    private Button bt_register_jump;
    private EditText et_register_name;
    private EditText et_register_password;
    private EditText et_register_passwore01;

    Map<String,String> map=new HashMap<String,String>();
    private String name;
    private String password;
    private String password_one;
    private String phone;

    MainActivity mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activituy_layout);
        initdata();
        setLinster();
    }


    //获得控件的方法

    public void initdata(){




            //获取提交按钮控件
        bt_register_jump = (Button) findViewById(R.id.bt_register_jump);
            //获取会员名控件
        et_register_name = (EditText) findViewById(R.id.et_register_name);
            //获取会员密码控件
        et_register_password = (EditText) findViewById(R.id.et_register_password);
            //获取重复会员密码控件
        et_register_passwore01 = (EditText) findViewById(R.id.et_register_passwore01);


        name= et_register_name.getText().toString().trim();
        password= et_register_password.getText().toString().trim();
        password_one= et_register_passwore01.getText().toString().trim();

        Intent intent = getIntent();

        phone = intent.getStringExtra("phone");


    }
//    http://114.112.104.151:8203/LvScore_Service/visit/user_register.do?telNum=18500704988&name=godboy&password=123456
//
//    telNum=185
//            00704988&name=godboy&password=123456

    public void setLinster(){

        //获取提交按钮监听事件
        bt_register_jump.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            //获取提交按钮监听点击事件
            case R.id.bt_register_jump:

                if(password.equals(password_one)){

                    if(null==name&&null==password){
                        Toast.makeText(Register_Activity.this,"用户名或密码不能为空~",Toast.LENGTH_LONG).show();
                    }else{

                            getdata();

                    }


                }else{
                    Toast.makeText(Register_Activity.this,"两次密码输入不同~请重新输入",Toast.LENGTH_LONG).show();
                }



                break;
        }


    }


    public void getdata(){

        map.put("telNum",phone);
        map.put("name",name);
        map.put("password",password);

        String url= Constant.WJF_SERVICE+Constant.ServiceConstant.REGISTER_VIP+Constant.SetUrl(map);


        WJF.singleon.geturl(url, this, new Singleon.ResuleCallBack() {
            @Override
            public void onResponse(String response) {




                Log.e("response",name+password+phone+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

                Toast.makeText(Register_Activity.this,"注册成功",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(Register_Activity.this,Sufferlly_actity.class);

                intent.putExtra("t",phone);
                intent.putExtra("n",name);
                intent.putExtra("p",password);
                startActivity(intent);



            }

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Register_Activity.this,"注册失败~请重新尝试",Toast.LENGTH_LONG).show();

            }
        });






    }




}
