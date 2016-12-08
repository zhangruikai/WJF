package com.bwie.weijifentwo.advert.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.weijifentwo.R;
import com.bwie.weijifentwo.advert.entity.Detailadvertisements;
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



            viewHolder.iv_xlvshow_image= (ImageView) converview.findViewById(R.id.iv_xlvshow_image);

            viewHolder.tv_xlvname_show= (TextView) converview.findViewById(R.id.tv_xlvname_show);

            converview.setTag(viewHolder);

        }else{
            viewHolder= (ViewHolder) converview.getTag();
        }

        ImageLoader.getInstance().displayImage(advertisements.get(position).adHomepage,viewHolder.iv_xlvshow_image);
        viewHolder.tv_xlvadvUrl_show.setText(advertisements.get(position).advUrl);
        viewHolder.tv_xlvcreateTime_show.setText(advertisements.get(position).createTime);
        viewHolder.tv_xlvname_show.setText(advertisements.get(position).name);

        return converview;
    }

    class ViewHolder{
    ImageView iv_xlvshow_image;
        TextView tv_xlvname_show,tv_xlvadvUrl_show,tv_xlvcreateTime_show;

    }

}
