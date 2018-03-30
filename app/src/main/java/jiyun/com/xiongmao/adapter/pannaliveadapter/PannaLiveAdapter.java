package jiyun.com.xiongmao.adapter.pannaliveadapter;

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
import jiyun.com.xiongmao.beans.homebeans.homebeans_item.ListBeanX;

public class PannaLiveAdapter extends RecyclerView.Adapter<PannaLiveAdapter.ViewHolder> {
    private List<ListBeanX> mList;
    private Context context;

    public PannaLiveAdapter(List<ListBeanX> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pannalive_one_item_view, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position).getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(holder.pannaliveoneitemimage);
        holder.pannaliveoneitemtitle.setText(mList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private android.widget.ImageView pannaliveoneitemimage;
        private android.widget.TextView pannaliveoneitemtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            pannaliveoneitemtitle = (TextView) itemView.findViewById(R.id.pannalive_oneitem_title);
            pannaliveoneitemimage = (ImageView) itemView.findViewById(R.id.pannalive_oneitem_image);
        }
    }
}
