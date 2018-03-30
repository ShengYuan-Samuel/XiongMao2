package jiyun.com.xiongmao.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.xiongmao.App.App;
import jiyun.com.xiongmao.MainActivity;
import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.pannaeyeadapter.PannaEyesAdapter;
import jiyun.com.xiongmao.base.BaseFragment;
import jiyun.com.xiongmao.beans.pannaeyebeans.Pannaeyebeans;
import jiyun.com.xiongmao.beans.pannaeyebeans.pannaeyeysitem.PannaeyeItem;
import jiyun.com.xiongmao.http.Retrofit2Utils;


public class PandaEyeFragment extends BaseFragment {
    private SmartRefreshLayout smartRefreshLayout;
    private RecyclerView recyclerView;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panna_eye;
    }

    @Override
    protected void init() {
        smartRefreshLayout = getView().findViewById(R.id.pannaeye_srefresh);
        recyclerView = getView().findViewById(R.id.pannaeye_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });
    }

    @Override
    protected void loadData() {
        Retrofit2Utils.getIntenface()
                .getPannaService()
                .getPannaeyeBeansList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Pannaeyebeans>() {
                    @Override
                    public void accept(Pannaeyebeans pannaeyebeans) throws Exception {
                        PannaEyesAdapter adapter = new PannaEyesAdapter(pannaeyebeans, getContext());
                        recyclerView.setAdapter(adapter);
                    }
                });

    }

    @Override
    public void updateTitle() {
        ((MainActivity) App.context).getmTvTitle().setText("熊猫观察");
        ((MainActivity) App.context).getmImageHudong().setVisibility(View.INVISIBLE);
        ((MainActivity) App.context).getmImageSign().setVisibility(View.INVISIBLE);
    }


}
