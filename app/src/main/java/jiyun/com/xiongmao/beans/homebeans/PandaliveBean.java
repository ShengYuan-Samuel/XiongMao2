package jiyun.com.xiongmao.beans.homebeans;

import java.util.List;

public class PandaliveBean {
    /**
     * title : 熊猫直播
     * list : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/14/1452765186225_780.jpg","url":"","title":"成都基地高清精切线路","id":"ipanda","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE1450178789681331211/index.json","order":"1"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/14/1452765209983_511.jpg","url":"","title":"成都直播：熊猫母子园","id":"xiongmao07","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE1450178789681331211/index.json","order":"2"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/14/1452765227283_786.jpg","url":"","title":"成都直播：熊猫一号别墅","id":"xiongmao09","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE1450178789681331211/index.json","order":"3"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/4/1/1491013180946_553.jpg","url":"","title":"卧龙直播：熊猫\u201c宝宝\u201d","id":"xiongmao11","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE145017878968133121/index.json","order":"4"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/14/1452765258608_842.jpg","url":"","title":"卧龙直播：熊猫\u201c青青\u201d","id":"xiongmao12","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE145017878968133121/index.json","order":"5"},{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/6/1/1464765552815_663.jpg","url":"","title":"雅安基地幼儿园","id":"xiongmao18","vid":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE145017878968133121/index.json","order":"6"}]
     */

    private String title;
    private List<ListBean> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }
}
