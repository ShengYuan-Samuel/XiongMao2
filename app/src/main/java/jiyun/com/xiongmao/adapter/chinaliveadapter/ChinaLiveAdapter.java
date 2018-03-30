package jiyun.com.xiongmao.adapter.chinaliveadapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.xiongmao.ui.ChinaLive_ViewFragment;

public class ChinaLiveAdapter extends FragmentPagerAdapter {
    private ArrayList<String> mTitle;
    private ArrayList<ChinaLive_ViewFragment> mList;

    public ChinaLiveAdapter(FragmentManager fm, ArrayList<String> mTitle, ArrayList<ChinaLive_ViewFragment> mList) {
        super(fm);
        this.mTitle = mTitle;
        this.mList = mList;
    }
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
