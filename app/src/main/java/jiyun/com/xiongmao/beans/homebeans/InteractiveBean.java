package jiyun.com.xiongmao.beans.homebeans;

import java.util.List;

public class InteractiveBean {
    /**
     * title : 特别策划
     * interactiveone : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/5/1496626317442_981.jpg","title":"二十四节气\u2014\u2014芒种","url":"http://webapp.cctv.com/h5/travel/U80531QU7SY7.html","type":"","vid":"","order":"1"}]
     * interactivetwo : []
     */

    private String title;
    private List<InteractiveoneBean> interactiveone;
    private List<?> interactivetwo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<InteractiveoneBean> getInteractiveone() {
        return interactiveone;
    }

    public void setInteractiveone(List<InteractiveoneBean> interactiveone) {
        this.interactiveone = interactiveone;
    }

    public List<?> getInteractivetwo() {
        return interactivetwo;
    }

    public void setInteractivetwo(List<?> interactivetwo) {
        this.interactivetwo = interactivetwo;
    }
}
