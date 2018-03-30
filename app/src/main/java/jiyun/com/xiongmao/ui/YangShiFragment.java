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
import java.util.function.Consumer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.cctvadapter.CCTVYangShiAdapter;
import jiyun.com.xiongmao.beans.cctvbeans.pindaobeans.PinDaoBean;
import jiyun.com.xiongmao.beans.cctvbeans.yangshibeans.ListBean;
import jiyun.com.xiongmao.beans.cctvbeans.yangshibeans.YangShiBean;
import jiyun.com.xiongmao.http.Retrofit2Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class YangShiFragment extends Fragment {
    private View mView;
    private RecyclerView mCctvPindaoRec;
    private List<ListBean> mList;
    private CCTVYangShiAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_pin_dao, container, false);
        initView(mView);
        loadData();
        return mView;
    }

    private void loadData() {
        Retrofit2Utils.getIntenface()
                .getPannaService()
                .getYangShiList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.functions.Consumer<YangShiBean>() {
                    @Override
                    public void accept(YangShiBean yangShiBean) throws Exception {
                        List<ListBean> list = yangShiBean.getList();
                        mList.addAll(list);
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    private void initView(View mView) {
        mList = new ArrayList<>();
        mCctvPindaoRec = (RecyclerView) mView.findViewById(R.id.cctv_pindao_rec);
        mCctvPindaoRec.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CCTVYangShiAdapter(mList, getContext());
        mCctvPindaoRec.setAdapter(adapter);
    }

}
