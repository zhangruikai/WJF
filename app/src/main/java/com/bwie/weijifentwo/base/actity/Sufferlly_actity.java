package com.bwie.weijifentwo.base.actity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.weijifentwo.R;

/**
 * Created by 张瑞凯 on 2016/12/8.
 */
public class Sufferlly_actity extends Activity implements View.OnClickListener{

    private Button bt_register_login;
    private TextView tv_registername_view;
    private TextView tv_registernumber_view;
    private TextView tv_registernumber1_view;
    private String name;
    private String telNum;
    private String password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sufferlly_xml_layout);
        initdata();
        setLinster();
    }

        public void initdata(){


        //提交数据按钮
            bt_register_login = (Button) findViewById(R.id.bt_register_login);
        //会员名
            tv_registername_view = (TextView) findViewById(R.id.tv_registername_view);

           //账号第一个
            tv_registernumber_view = (TextView) findViewById(R.id.tv_registernumber_view);
            //账号第二个
            tv_registernumber1_view = (TextView) findViewById(R.id.tv_registernumber1_view);
            Intent intent = getIntent();
            name = intent.getStringExtra("n");
            telNum = intent.getStringExtra("t");
            password = intent.getStringExtra("p");
            tv_registername_view.setText("会员名："+name);
            tv_registernumber_view.setText("小毛驴账户："+telNum);
            tv_registernumber1_view.setText("小毛驴账户："+telNum);

        }


    public void setLinster(){

        bt_register_login.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {


        switch (view.getId()){
            //提交数据按钮
            case R.id.bt_register_login:
                Intent intent=new Intent(Sufferlly_actity.this,Login_main_page.class);
                intent.putExtra("telNum",telNum);
                intent.putExtra("name",name);
                intent.putExtra("password",password);
                startActivity(intent);
                finish();
                break;


        }



    }
}
