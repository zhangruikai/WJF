package com.bwie.weijifentwo.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.weijifentwo.R;
import com.bwie.weijifentwo.home.entity.Detailadvertisements;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张瑞凯 on 2016/12/6.
 */
public class xlv_adapter extends BaseAdapter{

    Context context;

    List<Detailadvertisements> advertisements=new ArrayList<Detailadvertisements>();

    public xlv_adapter(Context context){
        this.context=context;
    }

    public void addrest(List<Detailadvertisements> advertisements){
        this.advertisements.clear();
        this.advertisements.addAll(advertisements);
        this.notifyDataSetChanged();
    }
    public void addrest1(List<Detailadvertisements> advertisements){
        this.advertisements.addAll(advertisements);
        this.notifyDataSetChanged();
    }




    @Override
    public int getCount() {
        return advertisements.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View converview, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(converview==null){
            converview=LayoutInflater.from(context).inflate(R.layout.xlv_detaildata_adapter,null);
            viewHolder=new ViewHolder();
            viewHolder.iv_xiazai_image= (ImageView) converview.findViewById(R.id.iv_xiazai_image);
            viewHolder.iv_xlvshow_image= (ImageView) converview.findViewById(R.id.iv_xlvshow_image);
            viewHolder.tv_xlvname_show= (TextView) converview.findViewById(R.id.tv_xlvname_show);
            viewHolder.tv_xlvmory_show= (TextView) converview.findViewById(R.id.tv_xlvmory_show);
            viewHolder.tv_xlvliuiang_show= (TextView) converview.findViewById(R.id.tv_xlvliuiang_show);
            viewHolder.tv_xlvadtime_show= (TextView) converview.findViewById(R.id.tv_xlvadtime_show);
            viewHolder.tv_time_show= (TextView) converview.findViewById(R.id.tv_time_show);
            viewHolder.tv_play_show= (TextView) converview.findViewById(R.id.tv_play_show);
            converview.setTag(viewHolder);

        }else{
            viewHolder= (ViewHolder) converview.getTag();
        }
        ImageLoader.getInstance().displayImage(advertisements.get(position).adHomepage,viewHolder.iv_xlvshow_image);
        viewHolder.tv_xlvname_show.setText(advertisements.get(position).name);
        viewHolder.tv_xlvmory_show.setText(advertisements.get(position).price+"");
        viewHolder.tv_xlvliuiang_show.setText(advertisements.get(position).adSize);
        viewHolder.tv_xlvadtime_show.setText(advertisements.get(position).duration);
        viewHolder.tv_time_show.setText(advertisements.get(position).validityPeriod);
        viewHolder.tv_play_show.setText(advertisements.get(position).playNum);





        return converview;
    }

    class ViewHolder{
    ImageView iv_xlvshow_image,iv_xiazai_image;
        TextView tv_xlvname_show,tv_xlvmory_show,tv_xlvliuiang_show,tv_xlvadtime_show,tv_time_show,tv_play_show;

    }

}
