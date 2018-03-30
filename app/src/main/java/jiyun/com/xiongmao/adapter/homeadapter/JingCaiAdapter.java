package jiyun.com.xiongmao.adapter.homeadapter;

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
import jiyun.com.xiongmao.beans.homebeans.ListscrollBean;

public class JingCaiAdapter extends RecyclerView.Adapter<JingCaiAdapter.ViewHolder> implements View.OnClickListener {
    private List<ListscrollBean> mlist;
    private Context context;

    public JingCaiAdapter(List<ListscrollBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview_ad, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textview_homepage_adtitle.setText(mlist.get(position).getTitle());
        //Glide.with(context).load(mlist.get(position).getImage()).into(holder.image_homepage_ad);
        Glide.with(context).load(mlist.get(position).getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(holder.image_homepage_ad);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_homepage_ad;
        private TextView textview_homepage_adtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            image_homepage_ad = itemView.findViewById(R.id.image_homepage_ad);
            textview_homepage_adtitle = itemView.findViewById(R.id.textview_homepage_adtitle);
        }
    }

    private OnClickListeren onClickListener;

    public interface OnClickListeren {
        void onCilckListeren(View view, int position);
    }

    @Override
    public void onClick(View v) {
        if (onClickListener != null) {
            onClickListener.onCilckListeren(v, (int) v.getTag());
        }
    }

    public void setOnClickListener(OnClickListeren onClick) {
        this.onClickListener = onClick;
    }
}
