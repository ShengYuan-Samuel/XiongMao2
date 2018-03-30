package jiyun.com.xiongmao.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.cctvadapter.CCTVViewPagerAdapter;
import jiyun.com.xiongmao.beans.pannalivebeans.pannaliveitem.LiveBean;
import jiyun.com.xiongmao.beans.pannalivebeans.pannaliveitem.MultipleBean;
import jiyun.com.xiongmao.beans.pannalivebeans.pannaliveitem.PannaLiveItemBean;
import jiyun.com.xiongmao.http.Retrofit2Utils;


public class PannaLive_viewFragment extends Fragment implements View.OnClickListener {

    private View mView;
    private ImageView pannalive_image_live;
    private TextView pannalive_text_title;
    private Button pannalive_button;
    private TextView tv_content;
    private List<String> mTitle;
    private List<Fragment> mFragment;
    private TabLayout pannalive_tab_live;
    private ViewPager pannalive_pv_live;
    private PannaLiveItemBean panna;
    private int count = 0;
    private RelativeLayout pannalive_rl;
    private CCTVViewPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_panna_live_view, container, false);

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(mView);
        Bundle bundle = getArguments();
        String url = bundle.getString("url");
        if (!(url.equals(""))) {
            pannalive_rl.setVisibility(View.VISIBLE);
            initData(url);
        }

    }

    private void initData(String url) {
        Retrofit2Utils.getIntenface()
                .getPannaService()
                .getPannaLiveItemList(url)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PannaLiveItemBean>() {
                    @Override
                    public void accept(PannaLiveItemBean pannaLiveItemBean) throws Exception {
                        PannaLive_viewFragment.this.panna = pannaLiveItemBean;
                        getDataView(panna);
                    }
                });

    }

    private void getDataView(PannaLiveItemBean panna) {
        List<LiveBean> live = panna.getLive();
        LiveBean liveBean = live.get(0);
        Glide.with(getContext()).load(liveBean.getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(pannalive_image_live);
        pannalive_text_title.setText("[正在直播]" + liveBean.getTitle());
        tv_content.setText(liveBean.getBrief());
        String title = panna.getBookmark().getMultiple().get(0).getTitle();
        String title1 = panna.getBookmark().getWatchTalk().get(0).getTitle();
        mTitle.add(title);
        mTitle.add(title1);
        PannaLive_View_itemFragment pannaLive_view_itemFragment = new PannaLive_View_itemFragment();
        PannaLive_View_itemTwoFragment pannaLive_view_itemTwoFragment = new PannaLive_View_itemTwoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url",panna.getBookmark().getMultiple().get(0).getUrl());
        pannaLive_view_itemFragment.setArguments(bundle);
        mFragment.add(pannaLive_view_itemFragment);
        mFragment.add(pannaLive_view_itemTwoFragment);
        adapter.notifyDataSetChanged();

    }

    private void initView(View mView) {
        mTitle = new ArrayList<>();
        mFragment = new ArrayList<>();
        pannalive_rl = mView.findViewById(R.id.pannalive_rl);
        pannalive_image_live = (ImageView) mView.findViewById(R.id.pannalive_image_live);
        pannalive_text_title = (TextView) mView.findViewById(R.id.pannalive_text_title);
        pannalive_button = (Button) mView.findViewById(R.id.pannalive_button);
        tv_content = (TextView) mView.findViewById(R.id.pannalive_text_content);
        pannalive_tab_live = (TabLayout) mView.findViewById(R.id.pannalive_tab_live);
        pannalive_pv_live = (ViewPager) mView.findViewById(R.id.pannalive_pv_live);
        pannalive_button.setOnClickListener(this);
        adapter = new CCTVViewPagerAdapter(getActivity().getSupportFragmentManager(), mTitle, mFragment);
        pannalive_pv_live.setAdapter(adapter);
        pannalive_tab_live.setupWithViewPager(pannalive_pv_live);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pannalive_button:
                count++;
                if (count % 2 == 0) {
                    pannalive_button.setBackgroundResource(R.drawable.live_china_detail_up);
                } else {
                    pannalive_button.setBackgroundResource(R.drawable.live_china_detail_down);

                }
                if (tv_content.getVisibility() == View.GONE) {
                    tv_content.setVisibility(View.VISIBLE);
                } else {
                    tv_content.setVisibility(View.GONE);
                }
                break;
        }
    }
}
