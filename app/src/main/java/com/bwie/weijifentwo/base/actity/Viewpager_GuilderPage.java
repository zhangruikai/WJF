package com.bwie.weijifentwo.base.actity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.weijifentwo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张瑞凯 on 2016/12/6.
 */
public class Viewpager_GuilderPage extends Activity{

    private ViewPager vp_guilder_pager;
    private List<View> viewlist;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main_guilder);


        preferences = getSharedPreferences("config", MODE_PRIVATE);


       boolean flag= preferences.getBoolean("flag",true);

        if(flag){


            vp_guilder_pager = (ViewPager) findViewById(R.id.vp_guilder_pager);


            View page1 = View.inflate(this, R.layout.pager1, null);
            View page2 = View.inflate(this, R.layout.pager2, null);
            View page3 = View.inflate(this, R.layout.pager3, null);
            View page4 = View.inflate(this, R.layout.pager4, null);


            viewlist = new ArrayList<View>();


            viewlist.add(page1);
            viewlist.add(page2);
            viewlist.add(page3);
            viewlist.add(page4);


            vp_guilder_pager.setAdapter(new Guilder());


            page4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                 preferences.edit().putBoolean("flag",false).commit();

                    Intent intent=new Intent(Viewpager_GuilderPage.this,Login_main_page.class);

                    startActivity(intent);

                    finish();
                }
            });


        }else{

            Intent intent=new Intent(this,Login_main_page.class);

            startActivity(intent);

            finish();


        }





    }

    class Guilder extends PagerAdapter {

        @Override
        public int getCount() {
            return viewlist.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(viewlist.get(position));


        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(viewlist.get(position));
            return viewlist.get(position);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
