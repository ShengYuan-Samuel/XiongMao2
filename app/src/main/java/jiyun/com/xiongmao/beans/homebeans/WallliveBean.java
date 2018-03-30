package jiyun.com.xiongmao.beans.homebeans;

import java.util.List;

public class WallliveBean {
    /**
     * title : 长城直播
     * list : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453447161326_398.jpg","url":"","title":"八达岭长城南四楼","id":"bgws4","vid":"http://www.ipanda.com/kehuduan/liebiao/badaling/index.json","order":"1"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453449429822_667.jpg","url":"","title":"八达岭长城北十楼","id":"bgwn10","vid":"http://www.ipanda.com/kehuduan/liebiao/badaling/index.json","order":"2"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453449966410_700.jpg","url":"","title":"山海关长城镜头一","id":"wgw05","vid":"http://www.ipanda.com/kehuduan/liebiao/shanhaiguan/index.json","order":"3"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453450730912_656.jpg","url":"","title":"山海关长城镜头二","id":"wgw06","vid":"http://www.ipanda.com/kehuduan/liebiao/shanhaiguan/index.json","order":"4"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453451106626_148.jpg","url":"","title":"水长城","id":"wgw01","vid":"http://www.ipanda.com/kehuduan/liebiao/PAGEtcPWwRQbFtXAc5XV95lh160119/index.json","order":"5"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/22/1453451567952_933.jpg","url":"","title":"嘉峪关","id":"jyg03","vid":"http://www.ipanda.com/kehuduan/liebiao/PAGEcA8N14784Rzm35Q4Ppx1160119/index.json","order":"6"}]
     */

    private String title;
    private List<ListBeanX> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ListBeanX> getList() {
        return list;
    }

    public void setList(List<ListBeanX> list) {
        this.list = list;
    }
}
