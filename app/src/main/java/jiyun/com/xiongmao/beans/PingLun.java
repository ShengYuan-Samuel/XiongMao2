package jiyun.com.xiongmao.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class PingLun {

    @Id
    private Long id;
    private String content;
    @Generated(hash = 1235643122)
    public PingLun(Long id, String content) {
        this.id = id;
        this.content = content;
    }
    @Generated(hash = 1473188061)
    public PingLun() {
    }

    public PingLun(String content) {
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
