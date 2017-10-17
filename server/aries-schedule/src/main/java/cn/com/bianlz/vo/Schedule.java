package cn.com.bianlz.vo;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
public class Schedule {
    private Long sId;

    private Long id;

    private Long uuid;

    private String dateStamp;

    @SerializedName("cast_speed")
    private Integer castSpeed;

    private Integer cpm;

    private Integer repair;

    private String frequence;

    @SerializedName("from")
    private String source;

    @SerializedName("third_plat")
    private String thirdPlat;

    @SerializedName("full_amount")
    private String fullAmount;

    @SerializedName("none")
    private String hours;

    @SerializedName("hours")
    private List<String> hoursList;

    @SerializedName("refresh_round")
    private String refreshRound;

    @SerializedName("order_type")
    private String orderType;

    @SerializedName("idea_type")
    private String ideaType;

    private Date createDate;

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

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

    public Integer getCastSpeed() {
        return castSpeed;
    }

    public void setCastSpeed(Integer castSpeed) {
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
        this.frequence = frequence == null ? null : frequence.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getThirdPlat() {
        return thirdPlat;
    }

    public void setThirdPlat(String thirdPlat) {
        this.thirdPlat = thirdPlat == null ? null : thirdPlat.trim();
    }

    public String getFullAmount() {
        return fullAmount;
    }

    public void setFullAmount(String fullAmount) {
        this.fullAmount = fullAmount == null ? null : fullAmount.trim();
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours == null ? null : hours.trim();
    }

    public String getRefreshRound() {
        return refreshRound;
    }

    public void setRefreshRound(String refreshRound) {
        this.refreshRound = refreshRound == null ? null : refreshRound.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getIdeaType() {
        return ideaType;
    }

    public void setIdeaType(String ideaType) {
        this.ideaType = ideaType == null ? null : ideaType.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<String> getHoursList() {
        return hoursList;
    }

    public void setHoursList(List<String> hoursList) {
        this.hoursList = hoursList;
    }

    public String getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(String dateStamp) {
        this.dateStamp = dateStamp;
    }
}
