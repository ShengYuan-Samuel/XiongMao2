package jiyun.com.xiongmao.ui;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.pannaliveadapter.PannaLive_ItemAdapter;
import jiyun.com.xiongmao.beans.PingLun;
import jiyun.com.xiongmao.greendao.PingLunDao;
import jiyun.com.xiongmao.http.GreenDaoUtils;


public class PannaLive_View_itemTwoFragment extends Fragment implements View.OnClickListener {
    private EditText pannalive_et;
    private Button pannalive_insert;
    private RecyclerView Rec_pannalive_item;
    private PannaLive_ItemAdapter adapter;
    private List<PingLun> mList;
    private SmartRefreshLayout pannalive_refresh;
    private PingLunDao pingLunDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_panna_live__view_item_two, container, false);
        initView(mView);
        List<PingLun> pingLuns = pingLunDao.loadAll();
        Log.d("PannaLive_View_itemTwoF", "pingLuns.size():" + pingLuns.size());
        for (PingLun pingLun : pingLuns) {
            Log.d("PannaLive_View_itemTwoF", pingLun.getContent());
        }
        mList.addAll(pingLuns);
        adapter.notifyDataSetChanged();
        return mView;
    }

    private void initView(View mView) {
        mList = new ArrayList<>();
        pingLunDao = GreenDaoUtils.getInstance(getContext());
        pannalive_et = (EditText) mView.findViewById(R.id.pannalive_et);
        pannalive_insert = (Button) mView.findViewById(R.id.pannalive_insert);
        Rec_pannalive_item = (RecyclerView) mView.findViewById(R.id.Rec_pannalive_item);
        Rec_pannalive_item.setLayoutManager(new LinearLayoutManager(getContext()));
        pannalive_refresh = (SmartRefreshLayout) mView.findViewById(R.id.pannalive_refresh);
        pannalive_insert.setOnClickListener(this);
        adapter = new PannaLive_ItemAdapter(mList);
        Rec_pannalive_item.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pannalive_insert:
                submit();
                String string = pannalive_et.getText().toString();
                pingLunDao.insert(new PingLun(string));
                break;
        }
    }

    private void submit() {
        // validate
        String et = pannalive_et.getText().toString().trim();
        if (TextUtils.isEmpty(et)) {
            Toast.makeText(getContext(), "添加评论...", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
