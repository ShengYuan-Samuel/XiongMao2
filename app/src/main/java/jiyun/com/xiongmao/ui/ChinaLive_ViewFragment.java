package jiyun.com.xiongmao.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.chinaliveadapter.ChinaAdapter;
import jiyun.com.xiongmao.beans.chinalivebeans.ChinaLiveBean;
import jiyun.com.xiongmao.beans.chinalivebeans.LiveBean;
import jiyun.com.xiongmao.http.Retrofit2Utils;


public class ChinaLive_ViewFragment extends Fragment {


    private View mView;
    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private List<LiveBean> mList;
    private ChinaAdapter chinaAdapter;
    private String url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_china_live__view, container, false);
        return mView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        getLoadSata(url);
    }

    private void initView() {
        mList = new ArrayList<>();
        mRecyclerview = (RecyclerView) mView.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRefreshLayout = (SmartRefreshLayout) mView.findViewById(R.id.refreshLayout);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        chinaAdapter = new ChinaAdapter(mList, getContext());
        mRecyclerview.setAdapter(chinaAdapter);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
                getLoadSata(url);
            }
        });
    }

    private void getLoadSata(String url) {
        Retrofit2Utils.getIntenface()
                .getPannaService()
                .getChinaLiveBeanList(url)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChinaLiveBean>() {
                    @Override
                    public void accept(ChinaLiveBean chinaLiveBean) throws Exception {
                        List<LiveBean> live = chinaLiveBean.getLive();
                        mList.addAll(live);
                        chinaAdapter.notifyDataSetChanged();
                    }
                });
    }
}
