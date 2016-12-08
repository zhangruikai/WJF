package com.bwie.weijifentwo;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.weijifentwo.base.entity.Singleon;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class WJF extends Application{



    public static  Singleon singleon;

    @Override
    public void onCreate() {
        super.onCreate();

        singleon=Singleon.getInStance();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this).build();


        ImageLoader.getInstance().init(configuration);

    }
}
