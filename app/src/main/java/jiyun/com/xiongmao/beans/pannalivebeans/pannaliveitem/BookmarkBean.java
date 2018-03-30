package jiyun.com.xiongmao.beans.pannalivebeans.pannaliveitem;

import java.util.List;

public class BookmarkBean {
    private List<MultipleBean> multiple;
    private List<WatchTalkBean> watchTalk;

    public List<MultipleBean> getMultiple() {
        return multiple;
    }

    public void setMultiple(List<MultipleBean> multiple) {
        this.multiple = multiple;
    }

    public List<WatchTalkBean> getWatchTalk() {
        return watchTalk;
    }

    public void setWatchTalk(List<WatchTalkBean> watchTalk) {
        this.watchTalk = watchTalk;
    }
}
