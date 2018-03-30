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
import jiyun.com.xiongmao.adapter.homeadapter.HomeAdapter;
import jiyun.com.xiongmao.base.BaseFragment;
import jiyun.com.xiongmao.beans.homebeans.HomeData;
import jiyun.com.xiongmao.http.Retrofit2Utils;


public class HomeFragment extends BaseFragment {
    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private HomeAdapter homeAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
    @Override
    protected void init() {
        App.context = getContext();
        mRecyclerview = getView().findViewById(R.id.recyclerview);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mRefreshLayout = getView().findViewById(R.id.refreshLayout);
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
            }
        });
    }

    @Override
    protected void loadData() {
        Retrofit2Utils.getIntenface().getPannaService().getHomeData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<HomeData>() {
            @Override
            public void accept(HomeData homeData) throws Exception {
                homeAdapter = new HomeAdapter(homeData, getContext());
                mRecyclerview.setAdapter(homeAdapter);

            }
        });
    }

    @Override
    public void updateTitle() {
        ((MainActivity) App.context).getmTvTitle().setText("");
        ((MainActivity) App.context).getmImageHudong().setVisibility(View.VISIBLE);
        ((MainActivity) App.context).getmImageSign().setVisibility(View.VISIBLE);

    }


}
