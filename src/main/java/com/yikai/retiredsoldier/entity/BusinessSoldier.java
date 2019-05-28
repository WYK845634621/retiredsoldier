package com.yikai.retiredsoldier.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yikai.wang
 * @since 2019-05-26
 */
public class BusinessSoldier implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 企业id主键
     */
    private String businessId;
    /**
     * 退役士兵id主键
     */
    private String soldierId;
    /**
     * 1在用，0逻辑删除
     */
    private Integer dataStatus;
    private Date createTime;
    private Date modifyTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getSoldierId() {
        return soldierId;
    }

    public void setSoldierId(String soldierId) {
        this.soldierId = soldierId;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "BusinessSoldier{" +
        ", id=" + id +
        ", businessId=" + businessId +
        ", soldierId=" + soldierId +
        ", dataStatus=" + dataStatus +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
