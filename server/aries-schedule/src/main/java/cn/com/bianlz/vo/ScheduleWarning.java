package cn.com.bianlz.vo;

import java.util.Date;

public class ScheduleWarning {
    private Long id;
    private Long uuid;
    private String category;
    private String location;
    private Long cpm;
    private Long actualConsume;
    private String percent;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getCpm() {
        return cpm;
    }

    public void setCpm(Long cpm) {
        this.cpm = cpm;
    }

    public Long getActualConsume() {
        return actualConsume;
    }

    public void setActualConsume(Long actualConsume) {
        this.actualConsume = actualConsume;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
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

    @Override
    public String toString() {
        return "ScheduleWarning{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                ", cpm=" + cpm +
                ", actualConsume=" + actualConsume +
                ", percent='" + percent + '\'' +
                ", dateStamp='" + dateStamp + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
