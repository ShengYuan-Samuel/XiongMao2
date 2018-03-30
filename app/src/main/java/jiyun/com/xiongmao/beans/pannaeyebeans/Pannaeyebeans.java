package jiyun.com.xiongmao.beans.pannaeyebeans;

import jiyun.com.xiongmao.beans.pannaeyebeans.DataBean;

public class Pannaeyebeans {

    /**
     * data : {"bigImg":[{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/13/1497337653079_517.jpg","title":"旅日大熊猫\u201c仙女\u201d成功产下2017首胎海外熊猫幼仔","url":"http://news.ipanda.com/2017/06/12/ARTIBdwYiZE71cob9CQLUz79170612.shtml","id":"ARTIBdwYiZE71cob9CQLUz79170612","type":"5","stype":"","pid":"","vid":"","order":"1"}],"listurl":"http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1449807494852603,PAGE1451473625420136,PAGE1449807502866458,PAGE1451473627439140,PAGE1451473547108278,PAGE1451473628934144&serviceId=panda"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }
}
