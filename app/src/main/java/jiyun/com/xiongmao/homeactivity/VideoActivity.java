package jiyun.com.xiongmao.homeactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.base.BaseActivity;

public class VideoActivity extends BaseActivity {

    private VideoView mVvFirst;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    protected void init() {
        mVvFirst = (VideoView) findViewById(R.id.vv_first);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        if (url != null) {
            mVvFirst.setMediaController(new MediaController(this));
            mVvFirst.setVideoURI(Uri.parse(url));
            mVvFirst.start();
        }
    }

    @Override
    protected void loadData() {

    }


}
