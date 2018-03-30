package jiyun.com.xiongmao.beans.homebeans;

import java.util.List;

public class ChinaliveBean {
    /**
     * title : 直播中国
     * list : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/19/1474274866009_775.jpg","url":"","title":"【直播】张家界","id":"zjjmht","vid":"http://livechina.ipanda.com/zhangjiajie/01/index.shtml","order":"1"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/9/19/1474274669741_123.jpg","url":"","title":"【直播】凤凰古城","id":"fhgcdgm","vid":"http://livechina.ipanda.com/fenghuang/01/index.shtml","order":"2"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463646740047_989.jpg","url":"","title":"【直播】中央电视塔","id":"ztd","vid":"http://livechina.ipanda.com/zhongta/02/index.shtml","order":"3"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463646628905_109.jpg","url":"","title":"【直播】悬空寺","id":"hsxksqj","vid":"http://livechina.ipanda.com/hengshan/01/index.shtml","order":"4"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463646593298_50.jpg","url":"","title":"【直播】黄果树","id":"hgsljtgpt","vid":"http://livechina.ipanda.com/huangguoshu/02/index.shtml","order":"5"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/5/19/1463646137373_456.jpg","url":"","title":"【直播】黄龙","id":"hlwxt","vid":"http://www.ipanda.com/kehuduan/liebiao/huanglong/index.json","order":"6"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453182053209_224.jpg","url":"","title":"【直播】泰山","id":"taishan01","vid":"http://www.ipanda.com/kehuduan/liebiao/PAGE1451288906969388/index.json","order":"7"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453182136725_375.jpg","url":"","title":"【直播】黄山","id":"hssxf","vid":"http://www.ipanda.com/kehuduan/liebiao/huangshan/index.json","order":"8"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/19/1453182395917_608.jpg","url":"","title":"【直播】峨眉山","id":"emsarm","vid":"http://www.ipanda.com/kehuduan/liebiao/emeishan/index.json","order":"9"}]
     */

    private String title;
    private List<ListBeanXX> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ListBeanXX> getList() {
        return list;
    }

    public void setList(List<ListBeanXX> list) {
        this.list = list;
    }
}
