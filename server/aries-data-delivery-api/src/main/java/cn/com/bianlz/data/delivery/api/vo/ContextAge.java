package cn.com.bianlz.data.delivery.api.vo;

import java.util.Date;

/**
 * Created by bianlanzhou on 17/11/3.
 * Description
 */
public class ContextAge {
    private Integer id;
    private Long uuid;
    private String age;
    private String dateStamp;
    private Date createDate = new Date();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(String dateStamp) {
        this.dateStamp = dateStamp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
