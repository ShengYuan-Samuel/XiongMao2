package jiyun.com.xiongmao.adapter.pannaeyeadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.adapter.homeadapter.PannaeyeAdapter;
import jiyun.com.xiongmao.beans.pannaeyebeans.BigImgBean;
import jiyun.com.xiongmao.beans.pannaeyebeans.Pannaeyebeans;
import jiyun.com.xiongmao.beans.pannaeyebeans.pannaeyeysitem.ListBean;
import jiyun.com.xiongmao.beans.pannaeyebeans.pannaeyeysitem.PannaeyeItem;
import jiyun.com.xiongmao.http.Retrofit2Utils;

public class PannaEyesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Pannaeyebeans pannaeyebeans;
    private Context context;
    private final int HEAD_VIEW = 0;//这是头部局
    private final int BODY_VIEW = 1;

    public PannaEyesAdapter(Pannaeyebeans pannaeyebeans, Context context) {
        this.pannaeyebeans = pannaeyebeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder = null;
        View view = null;
        if (viewType == HEAD_VIEW) {
            view = inflater.inflate(R.layout.pannaeye_head_item, null);
            holder = new HeadHolder(view);
        } else if (viewType == BODY_VIEW) {
            view = inflater.inflate(R.layout.pannaeye_item_view, null);
            holder = new BodyHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeadHolder) {
            HeadHolder headHolder = (HeadHolder) holder;
            List<BigImgBean> bigImg = pannaeyebeans.getData().getBigImg();
            String title = bigImg.get(0).getTitle();
            String url = bigImg.get(0).getImage();
            headHolder.mTitle.setText(title);
            Glide.with(context).load(url).into(headHolder.mHeadImage);
        } else if (holder instanceof BodyHolder) {
            BodyHolder bodyHolder = (BodyHolder) holder;
            setBody(bodyHolder);
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_VIEW;
        } else if (position == 1) {
            return BODY_VIEW;
        }

        return super.getItemViewType(position);

    }


    //这是初始化头部局
    public class HeadHolder extends RecyclerView.ViewHolder {
        private ImageView mHeadImage;
        private TextView mTitle;

        public HeadHolder(View itemView) {
            super(itemView);
            mHeadImage = itemView.findViewById(R.id.pannaeye_head_image);
            mTitle = itemView.findViewById(R.id.pannaeye_head_text);
        }
    }

    //这是初始化头部局
    public class BodyHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public BodyHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.pannaeye_item_recycle);
        }
    }

    public void setBody(final BodyHolder holder) {
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));

        String url = pannaeyebeans.getData().getListurl();
        Retrofit2Utils.getIntenface().getPannaService().getPannaeyeItemList(url)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PannaeyeItem>() {
                    @Override
                    public void accept(PannaeyeItem pannaeyeItem) throws Exception {
                        List<ListBean> list = pannaeyeItem.getList();
                        PannaEyeAdapter pannaeyeAdapter = new PannaEyeAdapter(list, context);
                        holder.recyclerView.setAdapter(pannaeyeAdapter);

                    }
                });
    }

}
