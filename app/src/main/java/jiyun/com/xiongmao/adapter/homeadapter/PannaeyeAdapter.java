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
import jiyun.com.xiongmao.beans.homebeans.homebeans_item.ListBeanX;

public class PannaeyeAdapter extends RecyclerView.Adapter<PannaeyeAdapter.ViewHolder> {
    private List<ListBeanX> mList;
    private Context context;

    public PannaeyeAdapter(List<ListBeanX> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_pannaeye_view, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textviewhomepagemolihuatitle.setText(mList.get(position).getTitle());
        holder.textviewhomepagemolihuatime.setText(mList.get(position).getDaytime());
        holder.textviewhomepagepandaeyelistvideolength.setText(mList.get(position).getVideoLength());
       // Glide.with(context).load(mList.get(position).getImage()).into(holder.imagehomepagemolihua);
        Glide.with(context).load(mList.get(position).getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(holder.imagehomepagemolihua);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textviewhomepagemolihuatime;
        TextView textviewhomepagemolihuatitle;
        TextView textviewhomepagepandaeyelistvideolength;
        ImageView imagehomepagemolihua;

        public ViewHolder(View itemView) {
            super(itemView);
            textviewhomepagemolihuatime = itemView.findViewById(R.id.textview_homepage_molihuatime);
            textviewhomepagemolihuatitle = (TextView) itemView.findViewById(R.id.textview_homepage_molihuatitle);
            textviewhomepagepandaeyelistvideolength = (TextView) itemView.findViewById(R.id.textview_homepage_pandaeyelist_videolength);
            imagehomepagemolihua = (ImageView) itemView.findViewById(R.id.image_homepage_molihua);
        }
    }
}
