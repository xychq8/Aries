package cn.com.bianlz.data.delivery.api.vo;

/**
 * Created by bjbianlanzhou on 2017/10/17.
 */
public class Schedule {
    private Long sid;
    private Long id;
    private String uuid;
    private String castSpeed;
    private Integer cpm;
    private Integer repair;
    private String frequence;
    private String orderType;
    private String ideaType;
    private String hours;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCastSpeed() {
        return castSpeed;
    }

    public void setCastSpeed(String castSpeed) {
        this.castSpeed = castSpeed;
    }

    public Integer getCpm() {
        return cpm;
    }

    public void setCpm(Integer cpm) {
        this.cpm = cpm;
    }

    public Integer getRepair() {
        return repair;
    }

    public void setRepair(Integer repair) {
        this.repair = repair;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getIdeaType() {
        return ideaType;
    }

    public void setIdeaType(String ideaType) {
        this.ideaType = ideaType;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
