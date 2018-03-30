package jiyun.com.xiongmao.beans.homebeans;

import java.util.List;

public class PandaeyeBean {
    /**
     * title : 熊猫观察
     * pandaeyelogo : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/27/1453878224122_861.png
     * items : [{"title":"东北虎五胞胎取名谐音为\u201c东北欢迎你\u201d","bgcolor":"#ff0a5a","brief":"新生","url":"http://panview.ipanda.com/2017/06/14/VIDEQ2MhA0Ejp9OgTUcZXJV0170614.shtml","id":"TITE1497403113884217","pid":"26097f927eb34babad51340659d08fe1","vid":"","order":"1"},{"title":"萌娃\u201c越狱\u201d 哥哥助弟弟下床","bgcolor":"#ff0a5a","brief":"趣闻","url":"http://panview.ipanda.com/2017/06/14/VIDEDitkvohE2rnEJQlg1opd170614.shtml","id":"TITE1497403079074598","pid":"3adc37e20dea44a9be56433d80234fa7","vid":"","order":"2"}]
     * pandaeyelist : http://www.ipanda.com/kehuduan/shipinliebieye/xiongmaoguancha/index.json
     */

    private String title;
    private String pandaeyelogo;
    private String pandaeyelist;
    private List<ItemsBean> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPandaeyelogo() {
        return pandaeyelogo;
    }

    public void setPandaeyelogo(String pandaeyelogo) {
        this.pandaeyelogo = pandaeyelogo;
    }

    public String getPandaeyelist() {
        return pandaeyelist;
    }

    public void setPandaeyelist(String pandaeyelist) {
        this.pandaeyelist = pandaeyelist;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }
}
