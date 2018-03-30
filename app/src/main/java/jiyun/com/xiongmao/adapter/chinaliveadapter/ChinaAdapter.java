package jiyun.com.xiongmao.adapter.chinaliveadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.beans.chinalivebeans.LiveBean;

public class ChinaAdapter extends RecyclerView.Adapter<ChinaAdapter.ViewHolder> {
    private List<LiveBean> mList;
    private Context context;
    private int count = 0;

    public ChinaAdapter(List<LiveBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chinalive_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextviewItemTitle.setText("[正在直播]" + mList.get(position).getTitle());
       // Glide.with(context).load(mList.get(position).getImage()).into(holder.mImageviewItemIcon);
        Glide.with(context).load(mList.get(position).getImage()).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(holder.mImageviewItemIcon);
        holder.mTvContent.setText(mList.get(position).getBrief());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageviewItemIcon;
        private TextView mTextviewItemTitle;
        private Button mButton;
        private TextView mTvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageviewItemIcon = (ImageView) itemView.findViewById(R.id.imageview_item_icon);
            mTextviewItemTitle = (TextView) itemView.findViewById(R.id.textview_item_title);
            mButton = (Button) itemView.findViewById(R.id.button);
            mTvContent = (TextView) itemView.findViewById(R.id.tv_content);
            mButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    count++;
                    if (count % 2 == 0) {
                        mButton.setBackgroundResource(R.drawable.live_china_detail_up);
                    } else {
                        mButton.setBackgroundResource(R.drawable.live_china_detail_down);

                    }
                    if (mTvContent.getVisibility() == View.GONE) {
                        mTvContent.setVisibility(View.VISIBLE);
                    } else {
                        mTvContent.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}