package jiyun.com.xiongmao.beans.pannalivebeans.pannaliveitem;

import java.util.List;

public class PannaLiveItemBean {

    /**
     * live : [{"title":"成都基地高清精切线路","brief":"翻身、吃饭、睡觉、喝奶、打闹、攀爬\u2026\u2026这里是成都大熊猫繁育研究基地，24小时高清直播大熊猫生活实况的地方。成年园、幼年园、幼儿园、母子园、一号别墅，11路直播信号28个摄像头，让你零距离了解国宝们的日常起居。","image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/5/1451989464985_497.jpg","id":"xiongmaopindao01","isshow":"true","url":"http://live.ipanda.com/stream/"}]
     * bookmark : {"multiple":[{"title":"多视角直播","url":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json","order":"1"}],"watchTalk":[{"title":"边看边聊","url":"zhiboye_chat","order":"1"}]}
     */

    private BookmarkBean bookmark;
    private List<LiveBean> live;

    public BookmarkBean getBookmark() {
        return bookmark;
    }

    public void setBookmark(BookmarkBean bookmark) {
        this.bookmark = bookmark;
    }

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }
}
