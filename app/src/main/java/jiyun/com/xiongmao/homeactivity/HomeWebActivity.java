package jiyun.com.xiongmao.homeactivity;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import jiyun.com.xiongmao.R;
import jiyun.com.xiongmao.base.BaseActivity;

public class HomeWebActivity extends BaseActivity {
    private WebView mWvFirst;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_web;
    }

    @Override
    protected void init() {
        mWvFirst = findViewById(R.id.wv_first);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mWvFirst.loadUrl(url);
        mWvFirst.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

        });
    }

    @Override
    protected void loadData() {

    }
}
