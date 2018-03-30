package jiyun.com.xiongmao.http;

import io.reactivex.Observable;
import jiyun.com.xiongmao.beans.cctvbeans.pindaobeans.PinDaoBean;
import jiyun.com.xiongmao.beans.cctvbeans.yangshibeans.YangShiBean;
import jiyun.com.xiongmao.beans.chinalivebeans.ChinaLive;
import jiyun.com.xiongmao.beans.chinalivebeans.ChinaLiveBean;
import jiyun.com.xiongmao.beans.homebeans.HomeData;
import jiyun.com.xiongmao.beans.homebeans.homebeans_item.ListBean;
import jiyun.com.xiongmao.beans.pannaeyebeans.Pannaeyebeans;
import jiyun.com.xiongmao.beans.pannaeyebeans.pannaeyeysitem.PannaeyeItem;
import jiyun.com.xiongmao.beans.pannalivebeans.PannaLiveBean;
import jiyun.com.xiongmao.beans.pannalivebeans.pannaliveitem.PannaLiveItemBean;
import retrofit2.http.GET;

public interface PannaService {
    @GET(Url.CHINA_LIVE)
    Observable<ChinaLive> getChinaList();

    @GET
    Observable<ChinaLiveBean> getChinaLiveBeanList(@retrofit2.http.Url String url);

    @GET(Url.HOME_URL)
    Observable<HomeData> getHomeData();

    //这是获取主页熊猫观察的方法
    @GET
    Observable<ListBean> getHomePannaeyeList(@retrofit2.http.Url String url);

    //这是获取熊猫观察页面的方法
    @GET(Url.PANNAEYE_URL)
    Observable<Pannaeyebeans> getPannaeyeBeansList();

    //这是获取内部的json数据
    @GET
    Observable<PannaeyeItem> getPannaeyeItemList(@retrofit2.http.Url String url);

    //这是获取cctv频道直播的方法
    @GET(Url.PINDAOLIVE_URL)
    Observable<PinDaoBean> getPinDaoLiveList();

    //这是央视
    @GET(Url.CCTV_MINGLAN_URL)
    Observable<YangShiBean> getYangShiList();

    //这是熊猫直播的方法
    @GET(Url.PANNALIVE_URL)
    Observable<PannaLiveBean> getPannaLiveList();

    //这是熊猫直播的zi
    @GET
    Observable<PannaLiveItemBean> getPannaLiveItemList(@retrofit2.http.Url String url);


}
