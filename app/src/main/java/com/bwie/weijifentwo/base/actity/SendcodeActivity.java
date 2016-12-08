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
import com.bwie.weijifentwo.home.entity.Title;
import com.bwie.weijifentwo.home.entity.TitleData;
import com.bwie.weijifentwo.utils.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张瑞凯 on 2016/12/7.
 */
public class SendcodeActivity extends Activity implements View.OnClickListener {

    private Button bt_commit_jump;
    private Button bt_sendmsg_phone;
    private EditText ed_phone_text;
    private EditText ed_send_passore;
    private MainActivity mainActivity;

    Map<String, String> map;
    Map<String, String> map1;
    private String phonecode;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.send_main_code);
        initdata();
        setListner();
    }

    //创建一个找控件的方法

    public void initdata() {




        //提交数据按钮
        bt_commit_jump = (Button) findViewById(R.id.bt_commit_jump);
        //发送验证码按钮
        bt_sendmsg_phone = (Button) findViewById(R.id.bt_sendmsg_phone);
        //手机号控件
        ed_phone_text = (EditText) findViewById(R.id.ed_phone_text);
        //验证码
        ed_send_passore = (EditText) findViewById(R.id.ed_send_passore);

        //获取输入的手机号
        phonecode = ed_phone_text.getText().toString().trim();
        //获取输入的验证码
        code = ed_send_passore.getText().toString().trim();
    }


    //创造监听方法

    public void setListner() {

        //提交数据按钮
        bt_commit_jump.setOnClickListener(this);
        //发送验证码按钮

        bt_sendmsg_phone.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            //点击提交数据按钮
            case R.id.bt_commit_jump:

                if(null==code&&code.equals("verCode")){
                    Toast.makeText(SendcodeActivity.this, "验证码错误", Toast.LENGTH_LONG).show();
                }else{

                    getTitle2();
                }


                break;
            //点击发送验证码按钮
            case R.id.bt_sendmsg_phone:

                if (null == ed_phone_text) {
                    Toast.makeText(SendcodeActivity.this, "手机号或密码不能为空", Toast.LENGTH_LONG).show();
                } else {
                    getTitle1();
                }


                break;

        }


    }


    public void getTitle1() {

        map = new HashMap<String, String>();
        map.put("telNum","15137000350");

        String url = Constant.WJF_SERVICE + Constant.ServiceConstant.SEND_CODE + Constant.SetUrl(map);

        WJF.singleon.geturl(url, this, new Singleon.ResuleCallBack() {
            @Override
            public void onResponse(String response) {



                Toast.makeText(SendcodeActivity.this, response + "发送成功", Toast.LENGTH_LONG).show();



            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SendcodeActivity.this, "发送失败", Toast.LENGTH_LONG).show();
            }
        });


    }

    public void getTitle2() {

        map1 = new HashMap<String, String>();
        map1.put("telNum", phonecode);
        map1.put("verCode", code);
        String url = Constant.WJF_SERVICE + Constant.ServiceConstant.SEND_CODE_Suff + Constant.SetUrl(map1);

        WJF.singleon.geturl(url, this, new Singleon.ResuleCallBack() {
            @Override
            public void onResponse(String response) {



                Toast.makeText(SendcodeActivity.this,"验证成功", Toast.LENGTH_LONG).show();


                Intent intent=new Intent(SendcodeActivity.this,Register_Activity.class);


                intent.putExtra("phone",phonecode);

               startActivity(intent);


            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SendcodeActivity.this,"验证失败请重新获取", Toast.LENGTH_LONG).show();
            }
        });


    }


}
