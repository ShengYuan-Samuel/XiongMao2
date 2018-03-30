package jiyun.com.xiongmao.adapter.homeadapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.beans.homebeans.AreaBean;
import jiyun.com.xiongmao.beans.homebeans.BigImgBean;
import jiyun.com.xiongmao.beans.homebeans.CctvBean;
import jiyun.com.xiongmao.beans.homebeans.ChinaliveBean;
import jiyun.com.xiongmao.beans.homebeans.DataBean;
import jiyun.com.xiongmao.beans.homebeans.HomeData;
import jiyun.com.xiongmao.beans.homebeans.InteractiveBean;
import jiyun.com.xiongmao.beans.homebeans.InteractiveoneBean;
import jiyun.com.xiongmao.beans.homebeans.ListBeanXX;
import jiyun.com.xiongmao.beans.homebeans.ListBeanXXX;
import jiyun.com.xiongmao.beans.homebeans.PandaeyeBean;
import jiyun.com.xiongmao.beans.homebeans.PandaliveBean;
import jiyun.com.xiongmao.beans.homebeans.WallliveBean;
import jiyun.com.xiongmao.beans.homebeans.homebeans_item.ListBean;
import jiyun.com.xiongmao.beans.homebeans.homebeans_item.ListBeanX;
import jiyun.com.xiongmao.homeactivity.HomeWebActivity;
import jiyun.com.xiongmao.homeactivity.VideoActivity;
import jiyun.com.xiongmao.http.Retrofit2Utils;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private HomeData homeData;
    private Context context;
    private DataBean data;
    private final int BANNER_TYPE_VIEW = 0;//这是轮播图布局
    private final int CHANNEL_VIEW_TYPE = 1; //这是频道图
    private final int XIONAMAOGUANCHA_VIEW = 2; //这是熊猫观察
    private final int XIONGMAOZHIBO_VIEW = 3; //这是熊猫直播
    private final int CHANGCHENG_VIEW = 4;//这是长城直播
    private final int CHINA_VIEW = 5;//这是中国直播
    private final int TEBIECEHUA_VIEW = 6;//这是特别策划的页面
    private final int CCTV_VIE = 7;//这是cctv页面
    private final int GUANGYING_VIEW = 8;//这是最后一个


    public HomeAdapter(HomeData homeData, Context context) {
        this.homeData = homeData;
        this.context = context;
        data = homeData.getData();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder = null;
        View view = null;
        if (viewType == BANNER_TYPE_VIEW) {
            view = inflater.inflate(R.layout.home_banner_view, null);
            holder = new BannerHolder(view);
        } else if (viewType == CHANNEL_VIEW_TYPE) {
            view = inflater.inflate(R.layout.home_jingcai_view, null);
            holder = new JingCaiHolder(view);
        } else if (viewType == XIONAMAOGUANCHA_VIEW) {
            view = inflater.inflate(R.layout.home_pannaeye_view, null);
            holder = new PannaeyeHolder(view);
        } else if (viewType == XIONGMAOZHIBO_VIEW) {
            view = inflater.inflate(R.layout.home_pannalive_view, parent, false);
            holder = new PannaLiveHolder(view);
        } else if (viewType == CHANGCHENG_VIEW) {
            view = inflater.inflate(R.layout.home_changcheng_view, parent, false);
            holder = new ChangChengLiveHolder(view);
        } else if (viewType == CHINA_VIEW) {
            view = inflater.inflate(R.layout.home_chinalive_view, parent, false);
            holder = new ChinaLiveHolder(view);
        } else if (viewType == TEBIECEHUA_VIEW) {
            view = inflater.inflate(R.layout.home_tebiecehua_view, parent, false);
            holder = new TeBieHolder(view);
        } else if (viewType == CCTV_VIE) {
            view = inflater.inflate(R.layout.home_cctv_view, parent, false);
            holder = new CCTVHolder(view);
        } else if (viewType == GUANGYING_VIEW) {
            view = inflater.inflate(R.layout.home_guangying_view, parent, false);
            holder = new GuangYingHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerHolder) {
            BannerHolder bannerHolder = (BannerHolder) holder;
            setBanner(bannerHolder);
        } else if (holder instanceof JingCaiHolder) {
            JingCaiHolder jingCaiHolder = (JingCaiHolder) holder;
            setJingCai(jingCaiHolder);
        } else if (holder instanceof PannaeyeHolder) {
            PannaeyeHolder pannaeyeHolder = (PannaeyeHolder) holder;
            setPannaEye(pannaeyeHolder);
        } else if (holder instanceof PannaLiveHolder) {
            PannaLiveHolder pannaLiveHolder = (PannaLiveHolder) holder;
            setPannaLive(pannaLiveHolder);
        } else if (holder instanceof ChangChengLiveHolder) {
            ChangChengLiveHolder changChengLiveHolder = (ChangChengLiveHolder) holder;
            setChangCheng(changChengLiveHolder);
        } else if (holder instanceof ChinaLiveHolder) {
            ChinaLiveHolder chinaLiveHolder = (ChinaLiveHolder) holder;
            setChinaLive(chinaLiveHolder);
        } else if (holder instanceof TeBieHolder) {
            TeBieHolder teBieHolder = (TeBieHolder) holder;
            setTeBie(teBieHolder);
        } else if (holder instanceof CCTVHolder) {
            CCTVHolder cctvHolder = (CCTVHolder) holder;
            setCCTV(cctvHolder);
        } else if (holder instanceof GuangYingHolder) {
            GuangYingHolder guangYingHolder = (GuangYingHolder) holder;
            setGuangYing(guangYingHolder);
        }
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_TYPE_VIEW;
        } else if (position == 1) {
            return CHANNEL_VIEW_TYPE;
        } else if (position == 2) {
            return XIONAMAOGUANCHA_VIEW;
        } else if (position == 3) {
            return XIONGMAOZHIBO_VIEW;
        } else if (position == 4) {
            return CHANGCHENG_VIEW;
        } else if (position == 5) {
            return CHINA_VIEW;
        } else if (position == 6) {
            return TEBIECEHUA_VIEW;
        } else if (position == 7) {
            return CCTV_VIE;
        } else if (position == 8) {
            return GUANGYING_VIEW;
        }
        return super.getItemViewType(position);
    }


    //这是轮播的布局参数
    public class BannerHolder extends RecyclerView.ViewHolder {
        private Banner banner;

        public BannerHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.home_banner);
        }
    }

    //这是初始化数据的
    public void setBanner(BannerHolder holder) {
        final List<BigImgBean> bigImg = data.getBigImg();
        //创建一个标题
        ArrayList<String> mTitle = new ArrayList<>();
        //创建一个照片的集合
        ArrayList<String> mPhoto = new ArrayList<>();
        for (BigImgBean bigImgBean : bigImg) {
            mTitle.add(bigImgBean.getTitle());
            mPhoto.add(bigImgBean.getImage());
        }

        //设置一个样式
        holder.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //解析图片的
        holder.banner.setImageLoader(new ImageLoader() {

            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                //Glide.with(context).load((String) path).into(imageView);
                Glide.with(context).load((String)path).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(imageView);
            }
        });
        //设置一个图片集合
        holder.banner.setImages(mPhoto);
        //设置标题集合
        holder.banner.setBannerTitles(mTitle);
        //设置动画
        holder.banner.setBannerAnimation(Transformer.Default);
        //设置滚动时间
        holder.banner.setDelayTime(3000);
        //设置自动轮播
        holder.banner.isAutoPlay(true);
        //设置一个标题位置
        holder.banner.setIndicatorGravity(BannerConfig.RIGHT)
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        String url = bigImg.get(position).getUrl();
                        Intent intent = new Intent(context, HomeWebActivity.class);
                        intent.putExtra("url", url);
                        context.startActivity(intent);

                    }
                })
                .start();

    }

    //这是精彩推荐的布局参数
    public class JingCaiHolder extends RecyclerView.ViewHolder {
        private ImageView mHomeJingcaiImage;
        private TextView mHomeJingcaiText;
        private RecyclerView mHomeJingcaiRecycler;

        public JingCaiHolder(View itemView) {
            super(itemView);
            mHomeJingcaiImage = itemView.findViewById(R.id.home_jingcai_image);
            mHomeJingcaiText = itemView.findViewById(R.id.home_jingcai_text);
            mHomeJingcaiRecycler = itemView.findViewById(R.id.home_jingcai_recycler);

        }
    }

    //这是精彩推荐的初始化数据
    public void setJingCai(JingCaiHolder jingCai) {
        final AreaBean area = data.getArea();
        String title = area.getTitle();
        String image = area.getImage();
        jingCai.mHomeJingcaiText.setText(title);
        Glide.with(context).load(image).into(jingCai.mHomeJingcaiImage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        jingCai.mHomeJingcaiRecycler.setLayoutManager(linearLayoutManager);
        JingCaiAdapter jingCaiAdapter = new JingCaiAdapter(area.getListscroll(), context);
        jingCai.mHomeJingcaiRecycler.setAdapter(jingCaiAdapter);
        jingCaiAdapter.setOnClickListener(new JingCaiAdapter.OnClickListeren() {
            @Override
            public void onCilckListeren(View view, int position) {
                String url = area.getListscroll().get(position).getUrl();
                Intent intent = new Intent(context, VideoActivity.class);
                intent.putExtra("url", url);
                context.startActivity(intent);
            }
        });
    }

    //这是熊猫观察的布局
    public class PannaeyeHolder extends RecyclerView.ViewHolder {
        private TextView home_pannaeye_title;
        private ImageView home_pannaeye_image;
        private TextView home_pannaeye_text1;
        private TextView home_pannaeye_text2;
        private TextView home_pannaeye_text3;
        private TextView home_pannaeye_text4;
        private RecyclerView home_pannaeye_reycycler;

        public PannaeyeHolder(View itemView) {
            super(itemView);
            home_pannaeye_title = itemView.findViewById(R.id.home_pannaeye_title);
            home_pannaeye_text1 = itemView.findViewById(R.id.home_pannaeye_text1);
            home_pannaeye_text2 = itemView.findViewById(R.id.home_pannaeye_text2);
            home_pannaeye_text3 = itemView.findViewById(R.id.home_pannaeye_text3);
            home_pannaeye_text4 = itemView.findViewById(R.id.home_pannaeye_text4);
            home_pannaeye_image = itemView.findViewById(R.id.home_pannaeye_image);
            home_pannaeye_reycycler = itemView.findViewById(R.id.home_pannaeye_reycycler);

        }
    }

    //这是初始化熊猫观察的数据
    public void setPannaEye(final PannaeyeHolder holder) {
        PandaeyeBean pandaeye = data.getPandaeye();
        holder.home_pannaeye_title.setText(pandaeye.getTitle());
        Glide.with(context).load(pandaeye.getPandaeyelogo()).into(holder.home_pannaeye_image);
        holder.home_pannaeye_text1.setText(pandaeye.getItems().get(0).getBrief());
        holder.home_pannaeye_text2.setText(pandaeye.getItems().get(0).getTitle());
        holder.home_pannaeye_text3.setText(pandaeye.getItems().get(1).getBrief());
        holder.home_pannaeye_text4.setText(pandaeye.getItems().get(1).getTitle());
        holder.home_pannaeye_reycycler.setLayoutManager(new LinearLayoutManager(context));
        String url = pandaeye.getPandaeyelist();
        Retrofit2Utils.getIntenface()
                .getPannaService()
                .getHomePannaeyeList(url)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ListBean>() {
            @Override
            public void accept(ListBean listBean) throws Exception {
                List<ListBeanX> list = listBean.getList();
                PannaeyeAdapter pannaeyeAdapter = new PannaeyeAdapter(list, context);
                holder.home_pannaeye_reycycler.setAdapter(pannaeyeAdapter);
            }
        });

    }

    //这是熊猫直播的布局
    public class PannaLiveHolder extends RecyclerView.ViewHolder {
        private TextView home_pannalive_text;
        private RecyclerView home_pannalive_recycler;

        public PannaLiveHolder(View itemView) {
            super(itemView);
            home_pannalive_text = itemView.findViewById(R.id.home_pannalive_text);
            home_pannalive_recycler = itemView.findViewById(R.id.home_pannalive_recycler);
        }
    }

    //这是初始化熊猫直播数据的布局
    public void setPannaLive(PannaLiveHolder holder) {
        PandaliveBean pandalive = data.getPandalive();
        holder.home_pannalive_text.setText(pandalive.getTitle());
        List<jiyun.com.xiongmao.beans.homebeans.ListBean> list = pandalive.getList();
        holder.home_pannalive_recycler.setLayoutManager(new GridLayoutManager(context, 3));
        PannaLiveAdapter pannaLiveAdapter = new PannaLiveAdapter(list, context);
        holder.home_pannalive_recycler.setAdapter(pannaLiveAdapter);
    }

    //这是长城直播的布局
    public class ChangChengLiveHolder extends RecyclerView.ViewHolder {
        private TextView home_pannalive_text;
        private RecyclerView home_pannalive_recycler;

        public ChangChengLiveHolder(View itemView) {
            super(itemView);
            home_pannalive_text = itemView.findViewById(R.id.home_changcheng_text);
            home_pannalive_recycler = itemView.findViewById(R.id.home_changcheng_recycler);
        }
    }

    //这是初始化长城直播de数据
    public void setChangCheng(ChangChengLiveHolder holder) {
        WallliveBean walllive = data.getWalllive();
        holder.home_pannalive_text.setText(walllive.getTitle());
        List<jiyun.com.xiongmao.beans.homebeans.ListBeanX> list = walllive.getList();
        holder.home_pannalive_recycler.setLayoutManager(new GridLayoutManager(context, 3));
        ChangChengAdapter changChengAdapter = new ChangChengAdapter(list, context);
        holder.home_pannalive_recycler.setAdapter(changChengAdapter);
    }

    //这是中国直播的布局
    public class ChinaLiveHolder extends RecyclerView.ViewHolder {
        private TextView home_pannalive_text;
        private RecyclerView home_pannalive_recycler;

        public ChinaLiveHolder(View itemView) {
            super(itemView);
            home_pannalive_text = itemView.findViewById(R.id.home_chinalive_text);
            home_pannalive_recycler = itemView.findViewById(R.id.home_chinalive_recycler);
        }
    }

    //这是中国直播初始化数据
    public void setChinaLive(ChinaLiveHolder holder) {
        ChinaliveBean walllive = data.getChinalive();
        holder.home_pannalive_text.setText(walllive.getTitle());
        List<ListBeanXX> list = walllive.getList();
        holder.home_pannalive_recycler.setLayoutManager(new GridLayoutManager(context, 3));
        ChinaLiveAdapter chinaLiveAdapter = new ChinaLiveAdapter(list, context);
        holder.home_pannalive_recycler.setAdapter(chinaLiveAdapter);


    }

    //这是特别策划的布局
    public class TeBieHolder extends RecyclerView.ViewHolder {
        private TextView home_tebie_title;
        private ImageView home_tebie_image;
        private TextView home_tebie_content;

        public TeBieHolder(View itemView) {
            super(itemView);
            home_tebie_title = itemView.findViewById(R.id.home_tebie_title);
            home_tebie_image = itemView.findViewById(R.id.home_tebie_image);
            home_tebie_content = itemView.findViewById(R.id.home_tebie_content);
        }
    }

    //这是初始化特别策划的布局
    public void setTeBie(TeBieHolder holder) {
        InteractiveBean interactive = data.getInteractive();
        String title = interactive.getTitle();
        final List<InteractiveoneBean> interactiveone = interactive.getInteractiveone();
        String image = interactiveone.get(0).getImage();
        String title1 = interactiveone.get(0).getTitle();
        holder.home_tebie_title.setText(title);
        holder.home_tebie_content.setText(title1);
        Glide.with(context).load(image).into(holder.home_tebie_image);
        holder.home_tebie_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = interactiveone.get(0).getUrl();
                Intent intent = new Intent(context, HomeWebActivity.class);
                intent.putExtra("url", url);
                context.startActivity(intent);
            }
        });

    }

    //这是初始化cctv布局方法
    public class CCTVHolder extends RecyclerView.ViewHolder {
        private TextView home_pannalive_text;
        private RecyclerView home_pannalive_recycler;

        public CCTVHolder(View itemView) {
            super(itemView);
            home_pannalive_text = itemView.findViewById(R.id.home_cctv_text);
            home_pannalive_recycler = itemView.findViewById(R.id.home_cctv_recycler);
        }
    }

    //这是初始化光影中国数据的
    public void setCCTV(final CCTVHolder holder) {
        CctvBean cctv = data.getCctv();
        String url = cctv.getListurl();
        String title = cctv.getTitle();
        holder.home_pannalive_text.setText(title);
        holder.home_pannalive_recycler.setLayoutManager(new GridLayoutManager(context, 2));
        Retrofit2Utils.getIntenface().getPannaService().getHomePannaeyeList(url)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ListBean>() {
                    @Override
                    public void accept(ListBean listBean) throws Exception {
                        List<ListBeanX> list = listBean.getList();
                        CCTVAdapter cctvAdapter = new CCTVAdapter(list, context);
                        holder.home_pannalive_recycler.setAdapter(cctvAdapter);
                    }
                });

    }

    //这是初始化光影中国布局方法
    public class GuangYingHolder extends RecyclerView.ViewHolder {
        private TextView home_guangying_text;
        private RecyclerView home_guangying_recycler;

        public GuangYingHolder(View itemView) {
            super(itemView);
            home_guangying_text = itemView.findViewById(R.id.home_guangying_text);
            home_guangying_recycler = itemView.findViewById(R.id.home_guangying_recycler);
        }
    }

    public void setGuangYing(final GuangYingHolder holder) {
        List<ListBeanXXX> list = data.getList();
        String title = list.get(0).getTitle();
        holder.home_guangying_text.setText(title);
        String url = list.get(0).getListUrl();
        holder.home_guangying_recycler.setLayoutManager(new LinearLayoutManager(context));
        Retrofit2Utils.getIntenface().getPannaService().getHomePannaeyeList(url)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ListBean>() {
                    @Override
                    public void accept(ListBean listBean) throws Exception {
                        List<ListBeanX> list = listBean.getList();
                        PannaeyeAdapter pannaeyeAdapter = new PannaeyeAdapter(list, context);
                        holder.home_guangying_recycler.setAdapter(pannaeyeAdapter);
                    }
                });

    }

}
