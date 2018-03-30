package jiyun.com.xiongmao.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.pannaliveadapter.PannaLiveAdapter;
import jiyun.com.xiongmao.beans.homebeans.homebeans_item.ListBean;
import jiyun.com.xiongmao.beans.homebeans.homebeans_item.ListBeanX;
import jiyun.com.xiongmao.http.Retrofit2Utils;


public class PannaLive_View_itemFragment extends Fragment {

    private View mView;
    private RecyclerView pannalive_item_rec;
    private PannaLiveAdapter adapter;
    private List<ListBeanX> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_panna_live__view_item, container, false);

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(mView);
        Bundle bundle = getArguments();
        String url = bundle.getString("url");
        //Log.d("PannaLive_View_itemFrag", url);
        loadData(url);
    }


    private void initView(View mView) {
        mList = new ArrayList<>();
        pannalive_item_rec = (RecyclerView) mView.findViewById(R.id.pannalive_item_rec);
        pannalive_item_rec.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapter = new PannaLiveAdapter(mList, getContext());
        pannalive_item_rec.setAdapter(adapter);
    }

    private void loadData(String url) {
        Retrofit2Utils.getIntenface()
                .getPannaService()
                .getHomePannaeyeList(url)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ListBean>() {
                    @Override
                    public void accept(ListBean listBean) throws Exception {
                        List<ListBeanX> list = listBean.getList();
                        mList.addAll(list);
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}
