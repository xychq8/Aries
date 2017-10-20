package cn.com.bianlz.vo;

import java.util.Date;

/**
 * Created by bianlanzhou on 17/10/20.
 * Description
 */
public class Consume {
    private Long id;
    private Long uuid;
    private Long consume;
    private Long actualConsume;
    private String dateStamp;
    private Date createDate = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public Long getConsume() {
        return consume;
    }

    public void setConsume(Long consume) {
        this.consume = consume;
    }

    public Long getActualConsume() {
        return actualConsume;
    }

    public void setActualConsume(Long actualConsume) {
        this.actualConsume = actualConsume;
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
