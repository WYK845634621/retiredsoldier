package com.yikai.retiredsoldier.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yikai.wang
 * @since 2019-02-16
 */
@TableName("retiredsoldier.soldier")
public class Soldier implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * uuid主键
     */
    @TableId(value = "id")
    private String id;
    /**
     * 用户id
     */
    private String userId;
    private String identityId;
    private String name;
    private Integer age;
    private Integer gender;
    /**
     * 体重
     */
    private String weight;
    /**
     * 身高
     */
    private String height;
    private String phone;
    private String email;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 国籍
     */
    private String nationality;
    /**
     * 民族
     */
    private String nation;
    /**
     * 兵种
     */
    private String kind;
    /**
     * 服役地区
     */
    private String serviceArea;
    /**
     * 住址
     */
    private String location;
    /**
     * 意向职业
     */
    private String intendJob;
    /**
     * 1.0
     */
    private Integer dataStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "modify_time")
    private Date modifyTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntendJob() {
        return intendJob;
    }

    public void setIntendJob(String intendJob) {
        this.intendJob = intendJob;
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

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", identityId='" + identityId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", idCard='" + idCard + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nation='" + nation + '\'' +
                ", kind='" + kind + '\'' +
                ", serviceArea='" + serviceArea + '\'' +
                ", location='" + location + '\'' +
                ", intendJob='" + intendJob + '\'' +
                ", dataStatus=" + dataStatus +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
