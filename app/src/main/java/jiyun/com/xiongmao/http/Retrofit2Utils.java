package jiyun.com.xiongmao.http;

import android.text.TextUtils;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import jiyun.com.xiongmao.App.App;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 这是工具类  这是单一模式
 */
public class Retrofit2Utils {
    private Retrofit retrofit;
    private static Retrofit2Utils retrofit2Utils;
    private PannaService pannaService;

    public Retrofit2Utils() {
         Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //这是获取请求的url
                Log.d("Retrofit2Utils", "request.url():" + request.url());
                //获取response对象
                Response response = chain.proceed(request);
                if (TextUtils.isEmpty(response.cacheControl().toString())) {
                    Response newReponese = response.newBuilder().addHeader("Cache-Control", "max-age = 60 * 60 *365").build();
                    return newReponese;
                }

                return response;
            }
        };
        Cache cache = new Cache(App.context.getCacheDir(), 1024 * 1024 * 10);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Url.SERVICE_PANNA)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        pannaService = retrofit.create(PannaService.class);
    }

    public static Retrofit2Utils getIntenface() {
        if (retrofit2Utils == null) {
            retrofit2Utils = new Retrofit2Utils();
        }
        return retrofit2Utils;
    }

    public PannaService getPannaService() {
        return pannaService;
    }
}
