package jiyun.com.xiongmao.adapter.cctvadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.beans.cctvbeans.pindaobeans.ListBean;

public class PinDaoAdapter extends RecyclerView.Adapter<PinDaoAdapter.ViewHolder> {
    private List<ListBean> mList;
    private Context context;


    public PinDaoAdapter(List<ListBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cctv_item_pindao_view, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position).getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(holder.mCctvPindaoImage);
        Glide.with(context).load(mList.get(position).getLiveimage()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(holder.mCctvPindapImage1);
        holder.mCctvPindaoTitle.setText(mList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mCctvPindaoImage;
        private ImageView mCctvPindapImage1;
        private TextView mCctvPindaoTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mCctvPindaoImage = itemView.findViewById(R.id.cctv_pindao_image);
            mCctvPindapImage1 = itemView.findViewById(R.id.cctv_pindap_image1);
            mCctvPindaoTitle = itemView.findViewById(R.id.cctv_pindao_title);
        }
    }
}
