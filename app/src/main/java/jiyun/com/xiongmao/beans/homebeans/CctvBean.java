package jiyun.com.xiongmao.beans.homebeans;

import java.util.List;

public class CctvBean {
    /**
     * title : 央视名栏
     * listlive : []
     * listurl : http://www.ipanda.com/kehuduan/shipinliebieye/cctvshipindicengye/index.json
     */

    private String title;
    private String listurl;
    private List<?> listlive;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListurl() {
        return listurl;
    }

    public void setListurl(String listurl) {
        this.listurl = listurl;
    }

    public List<?> getListlive() {
        return listlive;
    }

    public void setListlive(List<?> listlive) {
        this.listlive = listlive;
    }
}
