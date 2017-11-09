package cn.com.bianlz.data.delivery.api.vo;

import java.util.Date;

/**
 * Created by bianlanzhou on 17/11/9.
 * Description
 */
public class Area {
    private String id;
    private Integer areaId;
    private String areaName;
    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
