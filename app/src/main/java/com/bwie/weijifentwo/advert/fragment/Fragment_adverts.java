package com.bwie.weijifentwo.advert.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.bawei.xlistview.view.XListView;
import com.bwie.weijifentwo.R;
import com.bwie.weijifentwo.WJF;
import com.bwie.weijifentwo.advert.adapter.xlv_adapter;
import com.bwie.weijifentwo.advert.entity.Detail;
import com.bwie.weijifentwo.advert.entity.DetailData;
import com.bwie.weijifentwo.advert.entity.Detailadvertisements;
import com.bwie.weijifentwo.base.actity.MainActivity;
import com.bwie.weijifentwo.base.entity.BaseFragment;
import com.bwie.weijifentwo.base.entity.Singleon;
import com.bwie.weijifentwo.utils.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 张瑞凯 on 2016/12/1.
 */
public class Fragment_adverts extends BaseFragment implements XListView.IXListViewListener {

    Map<String,String> map=new HashMap<String, String>();
    //页面之间传值

    public static final String FRAGMENT_ID = "fragment_detail_id";

    //页面传递过来的id

    String fragment_detail_id;

    //上下文
    MainActivity activity;
    public int page = 1;
    private XListView xlv_fragment_detail_home_show;
    private xlv_adapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dafail, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initHelder();
        initWiget();
        initonclistener();
        getTitle1();

    }


    @Override
    public void initHelder() {
//获得对象
        activity = (MainActivity) getActivity();
    }

    @Override
    public void initWiget() {
//接收传过来的Id
        fragment_detail_id = getArguments().getString(FRAGMENT_ID);

        xlv_fragment_detail_home_show = (XListView) getView().findViewById(R.id.xlv_fragment_detail_home_show);


        adapter = new xlv_adapter(getActivity());

        xlv_fragment_detail_home_show.setAdapter(adapter);


        xlv_fragment_detail_home_show.setPullLoadEnable(true);
        xlv_fragment_detail_home_show.setPullRefreshEnable(true);
        xlv_fragment_detail_home_show.setXListViewListener(this);


    }

    @Override
    public void initonclistener() {

    }


    public void getTitle1() {

        map.put("telNum",fragment_detail_id);




        Log.e("count",activity.map.size()+"..............");
        String url = Constant.WJF_SERVICE + Constant.ServiceConstant.NOT_LOGIN_MAIN_FRAGMENT + Constant.SetUrl(map);

        WJF.singleon.geturl(url, getActivity(), new Singleon.ResuleCallBack() {
            @Override
            public void onResponse(String response) {




                Detail detail = activity.gson.fromJson(response, Detail.class);

                DetailData detailData = detail.data;
                List<Detailadvertisements> advertisements = detailData.advertisements;

                Log.d("Response",advertisements+"--------------");


                if (page == 1) {

                    adapter.addrest(advertisements);

                }else{
                    adapter.addrest1(advertisements);
                }


                xlv_fragment_detail_home_show.stopLoadMore();
                xlv_fragment_detail_home_show.stopRefresh();
                xlv_fragment_detail_home_show.setRefreshTime("2016-12-6");

            }





            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


    }


    @Override
    public void onRefresh() {
        page = 1;
        getTitle1();


    }

    @Override
    public void onLoadMore() {
        page++;
        getTitle1();


    }
}
