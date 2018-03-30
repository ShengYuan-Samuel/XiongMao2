package jiyun.com.xiongmao;


import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import jiyun.com.xiongmao.base.BaseActivity;
import jiyun.com.xiongmao.fragment.CCTVFragment;
import jiyun.com.xiongmao.fragment.ChinaLiveFragment;
import jiyun.com.xiongmao.fragment.HomeFragment;
import jiyun.com.xiongmao.fragment.PandaEyeFragment;
import jiyun.com.xiongmao.fragment.PandaLiveFragment;
public class MainActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mImageSign;
    private TextView mTvTitle;
    private ImageView mImagePerson;
    private ImageView mImageHudong;
    private RadioButton mHomeBtn;
    private RadioButton mPandaEyeBtn;
    private RadioButton mPandaLiveBtn;
    private RadioButton mLiveChinaBtn;
    private RadioButton mCctvBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        mImageSign = findViewById(R.id.image_sign);
        mTvTitle = findViewById(R.id.tv_title);
        mImagePerson = findViewById(R.id.image_person);
        mImageHudong = findViewById(R.id.image_hudong);
        mHomeBtn = findViewById(R.id.homeBtn);
        mPandaEyeBtn = findViewById(R.id.pandaEyeBtn);
        mPandaLiveBtn = findViewById(R.id.pandaLiveBtn);
        mLiveChinaBtn = findViewById(R.id.liveChinaBtn);
        mCctvBtn = findViewById(R.id.cctvBtn);
        mHomeBtn.setOnClickListener(this);
        mPandaEyeBtn.setOnClickListener(this);
        mPandaLiveBtn.setOnClickListener(this);
        mLiveChinaBtn.setOnClickListener(this);
        mCctvBtn.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        setContentView(HomeFragment.class);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeBtn:
                setContentView(HomeFragment.class).updateTitle();
                break;
            case R.id.pandaEyeBtn:
                setContentView(PandaEyeFragment.class).updateTitle();
                break;
            case R.id.pandaLiveBtn:
                setContentView(PandaLiveFragment.class).updateTitle();
                break;
            case R.id.liveChinaBtn:
                setContentView(ChinaLiveFragment.class).updateTitle();

                break;
            case R.id.cctvBtn:
                setContentView(CCTVFragment.class).updateTitle();

                break;
        }
    }

    public ImageView getmImageSign() {
        return mImageSign;
    }

    public TextView getmTvTitle() {
        return mTvTitle;
    }

    public ImageView getmImagePerson() {
        return mImagePerson;
    }

    public ImageView getmImageHudong() {
        return mImageHudong;
    }
}
