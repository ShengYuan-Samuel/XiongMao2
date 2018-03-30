package jiyun.com.xiongmao.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.xiongmao.App.App;
import jiyun.com.xiongmao.MainActivity;

import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.chinaliveadapter.ChinaLiveAdapter;
import jiyun.com.xiongmao.base.BaseFragment;
import jiyun.com.xiongmao.beans.chinalivebeans.ChinaLive;
import jiyun.com.xiongmao.beans.chinalivebeans.TablistBean;
import jiyun.com.xiongmao.http.Retrofit2Utils;
import jiyun.com.xiongmao.ui.ChinaLive_ViewFragment;


public class ChinaLiveFragment extends BaseFragment {
    private TabLayout mChinaliveTab;
    private ViewPager mChinaliveVp;
    private ChinaLive chinaLive;
    private ArrayList<String> mTitle;
    private ArrayList<ChinaLive_ViewFragment> mFragments;
    private ChinaLiveAdapter chinaLiveAdapter;


    @Override

    protected int getLayoutId() {
        return R.layout.fragment_china_live;
    }

    @Override
    protected void init() {
        mTitle = new ArrayList<>();
        mFragments = new ArrayList<>();
        mChinaliveTab = getView().findViewById(R.id.chinalive_Tab);
        mChinaliveVp = getView().findViewById(R.id.chinalive_Vp);
        mChinaliveTab.setupWithViewPager(mChinaliveVp);
        chinaLiveAdapter = new ChinaLiveAdapter(getActivity().getSupportFragmentManager(), mTitle, mFragments);
        mChinaliveVp.setAdapter(chinaLiveAdapter);

    }

    @Override
    protected void loadData() {
        chinaLiveData();
    }

    private void chinaLiveData() {
        Retrofit2Utils.getIntenface()
                .getPannaService()
                .getChinaList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChinaLive>() {
                    @Override
                    public void accept(ChinaLive chinaLive) throws Exception {
                        ChinaLiveFragment.this.chinaLive = chinaLive;
                        showTabLayout(chinaLive);
                    }
                });

    }

    private void showTabLayout(ChinaLive chinaLive) {
        List<TablistBean> tablist = chinaLive.getTablist();
        for (TablistBean tablistBean : tablist) {
            ChinaLive_ViewFragment chinaLive_viewFragment = new ChinaLive_ViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", tablistBean.getUrl());
            chinaLive_viewFragment.setArguments(bundle);
            String title = tablistBean.getTitle();
            mTitle.add(title);
            mFragments.add(chinaLive_viewFragment);
        }
        chinaLiveAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateTitle() {
        ((MainActivity) App.context).getmTvTitle().setText("直播中国");
        ((MainActivity) App.context).getmImageHudong().setVisibility(View.INVISIBLE);
        ((MainActivity) App.context).getmImageSign().setVisibility(View.INVISIBLE);

    }


}
