package jiyun.com.xiongmao.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.xiongmao.App.App;
import jiyun.com.xiongmao.MainActivity;
import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.cctvadapter.CCTVViewPagerAdapter;
import jiyun.com.xiongmao.base.BaseFragment;
import jiyun.com.xiongmao.ui.PinDaoFragment;
import jiyun.com.xiongmao.ui.YangShiFragment;


public class CCTVFragment extends BaseFragment {


    private TabLayout cctv_tab;
    private ViewPager cctv_vp;
    private List<String> mTitle;
    private List<Fragment> mFragments;
    private CCTVViewPagerAdapter cctvViewPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cctv;
    }

    @Override
    protected void init() {
        mTitle = new ArrayList<>();
        mFragments = new ArrayList<>();
        mTitle.add("频道直播");
        mTitle.add("央视名栏");
        mFragments.add(new PinDaoFragment());
        mFragments.add(new YangShiFragment());
        cctv_tab = getView().findViewById(R.id.cctv_tab);
        cctv_vp = getView().findViewById(R.id.cctv_vp);
        cctv_tab.setupWithViewPager(cctv_vp);
        cctvViewPagerAdapter = new CCTVViewPagerAdapter(getActivity().getSupportFragmentManager(), mTitle, mFragments);
        cctv_vp.setAdapter(cctvViewPagerAdapter);


    }

    @Override
    protected void loadData() {

    }

    @Override
    public void updateTitle() {
        ((MainActivity) App.context).getmTvTitle().setText("CCTV");
        ((MainActivity) App.context).getmImageHudong().setVisibility(View.INVISIBLE);
        ((MainActivity) App.context).getmImageSign().setVisibility(View.INVISIBLE);
    }
    public void getData(){}
}
