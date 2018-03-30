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
import jiyun.com.xiongmao.beans.homebeans.ListBeanX;

public class ChangChengAdapter extends RecyclerView.Adapter<ChangChengAdapter.ViewHolder> {
    private List<ListBeanX> mList;
    private Context context;

    public ChangChengAdapter(List<ListBeanX> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview_ad, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textview_homepage_adtitle.setText(mList.get(position).getTitle());
       // Glide.with(context).load(mList.get(position).getImage()).into(holder.image_homepage_ad);
        Glide.with(context).load(mList.get(position).getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(holder.image_homepage_ad);

    }

    @Override
    public int getItemCount() {
        return mList.size();
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
}
