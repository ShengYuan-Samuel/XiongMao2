package jiyun.com.xiongmao.adapter.pannaliveadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.beans.PingLun;

public class PannaLive_ItemAdapter extends RecyclerView.Adapter<PannaLive_ItemAdapter.ViewHolder> {
    private List<PingLun> mList;

    public PannaLive_ItemAdapter(List<PingLun> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ed_textview, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(mList.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_ed_pannalive);
        }
    }
}
