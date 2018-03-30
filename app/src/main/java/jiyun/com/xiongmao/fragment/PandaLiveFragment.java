package jiyun.com.xiongmao.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.xiongmao.App.App;
import jiyun.com.xiongmao.MainActivity;
import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.cctvadapter.CCTVViewPagerAdapter;
import jiyun.com.xiongmao.base.BaseFragment;
import jiyun.com.xiongmao.beans.pannalivebeans.PannaLiveBean;
import jiyun.com.xiongmao.beans.pannalivebeans.TablistBean;
import jiyun.com.xiongmao.http.Retrofit2Utils;
import jiyun.com.xiongmao.ui.PannaLive_View_itemFragment;
import jiyun.com.xiongmao.ui.PannaLive_viewFragment;


public class PandaLiveFragment extends BaseFragment {


    private TabLayout pannalive_tab;
    private ViewPager pannalive_vp;
    private List<String> mTitle;
    private List<Fragment> mFragments;
    private PannaLiveBean panna;
    private CCTVViewPagerAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_live;
    }

    @Override
    protected void init() {
        mTitle = new ArrayList<>();
        mFragments = new ArrayList<>();
        pannalive_tab = getView().findViewById(R.id.pannalive_tab);
        pannalive_vp = getView().findViewById(R.id.pannalive_vp);
        adapter = new CCTVViewPagerAdapter(getActivity().getSupportFragmentManager(), mTitle, mFragments);
        pannalive_vp.setAdapter(adapter);
        pannalive_tab.setupWithViewPager(pannalive_vp);


    }

    @Override
    protected void loadData() {
        Retrofit2Utils.getIntenface()
                .getPannaService()
                .getPannaLiveList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PannaLiveBean>() {
                    @Override
                    public void accept(PannaLiveBean pannaLiveBean) throws Exception {
                        PandaLiveFragment.this.panna = pannaLiveBean;
                        initData(panna);
                    }
                });

    }

    private void initData(PannaLiveBean panna) {
        List<TablistBean> tablist = panna.getTablist();
        for (TablistBean tablistBean : tablist) {
            PannaLive_viewFragment pannaLive_viewFragment = new PannaLive_viewFragment();
            Bundle bundle = new Bundle();
            String url = tablistBean.getUrl();
            bundle.putString("url", url);
            pannaLive_viewFragment.setArguments(bundle);
            mTitle.add(tablistBean.getTitle());
            mFragments.add(pannaLive_viewFragment);
        }
      /*  for (int i = 0; i < 8; i++) {
            mFragments.add(new PannaLive_View_itemFragment());
        }*/
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateTitle() {
        ((MainActivity) App.context).getmTvTitle().setText("熊猫直播");
        ((MainActivity) App.context).getmImageHudong().setVisibility(View.INVISIBLE);
        ((MainActivity) App.context).getmImageSign().setVisibility(View.INVISIBLE);

    }
}
