package jiyun.com.xiongmao.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.cctvadapter.PinDaoAdapter;
import jiyun.com.xiongmao.beans.cctvbeans.pindaobeans.ListBean;
import jiyun.com.xiongmao.beans.cctvbeans.pindaobeans.PinDaoBean;
import jiyun.com.xiongmao.http.Retrofit2Utils;

public class PinDaoFragment extends Fragment {

    private View mView;
    private RecyclerView mCctvPindaoRec;
    private List<ListBean> mList;
    private PinDaoBean bean;
    private PinDaoAdapter pinDaoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_pin_dao, container, false);
        initView(mView);
        loadData();
        return mView;
    }

    private void initView(View mView) {
        mList = new ArrayList<>();
        mCctvPindaoRec = (RecyclerView) mView.findViewById(R.id.cctv_pindao_rec);
        mCctvPindaoRec.setLayoutManager(new LinearLayoutManager(getContext()));
        pinDaoAdapter = new PinDaoAdapter(mList, getContext());
        mCctvPindaoRec.setAdapter(pinDaoAdapter);
    }
    private void loadData() {
        Retrofit2Utils.getIntenface()
                .getPannaService()
                .getPinDaoLiveList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PinDaoBean>() {
                    @Override
                    public void accept(PinDaoBean pinDaoBean) throws Exception {
                        List<ListBean> list = pinDaoBean.getList();
                        mList.addAll(list);
                        pinDaoAdapter.notifyDataSetChanged();
                    }
                });
    }

}
