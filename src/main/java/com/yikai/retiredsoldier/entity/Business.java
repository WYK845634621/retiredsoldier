package com.yikai.retiredsoldier.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yikai.wang
 * @since 2019-02-23
 */
@TableName("retiredsoldier.business")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private String id;
    private String userId;
    /**
     * 角色表的id
     */
    private Integer identityId;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 成立时长,几年
     */
    private Integer age;
    private String phone;
    private String email;
    /**
     * 公司地址
     */
    private String location;
    /**
     * 招聘的职位,唯一
     */
    private String job;
    /**
     * 职位描述
     */
    private String jobDescribe;
    /**
     * 招人要求
     */
    private String requirement;
    /**
     * 月薪+月份
     */
    private String salary;
    private String idCard;
    /**
     * 联系人
     */
    private String contact;
    private String nationality;
    /**
     * 城市
     */
    private String nation;
    /**
     * 是否上市,同理gender
     */
    private Integer trade;
    /**
     * 公司种类
     */
    private String kind;
    /**
     * 1存在,2招聘,3培训
     */
    private Integer dataStatus;
    private Date createTime;
    private Date modifyTime;
    /**
     * 培训的项目
     */
    private String trainProject;
    /**
     * 培训是否花钱1花,2不花
     */
    private Integer cost;
    /**
     * 培训时长
     */
    private String trainTime;
    /**
     * 培训地点
     */
    private String trainArea;
    /**
     * 培训人电话
     */
    private String trainPhone;
    /**
     * 培训公司的优势
     */
    private String advantage;
    /**
     * 详细文档的id
     */
    private String trainId;


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

    public Integer getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Integer identityId) {
        this.identityId = identityId;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobDescribe() {
        return jobDescribe;
    }

    public void setJobDescribe(String jobDescribe) {
        this.jobDescribe = jobDescribe;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public Integer getTrade() {
        return trade;
    }

    public void setTrade(Integer trade) {
        this.trade = trade;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public String getTrainProject() {
        return trainProject;
    }

    public void setTrainProject(String trainProject) {
        this.trainProject = trainProject;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(String trainTime) {
        this.trainTime = trainTime;
    }

    public String getTrainArea() {
        return trainArea;
    }

    public void setTrainArea(String trainArea) {
        this.trainArea = trainArea;
    }

    public String getTrainPhone() {
        return trainPhone;
    }

    public void setTrainPhone(String trainPhone) {
        this.trainPhone = trainPhone;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    @Override
    public String toString() {
        return "Business{" +
                ", id=" + id +
                ", userId=" + userId +
                ", identityId=" + identityId +
                ", name=" + name +
                ", age=" + age +
                ", phone=" + phone +
                ", email=" + email +
                ", location=" + location +
                ", job=" + job +
                ", jobDescribe=" + jobDescribe +
                ", requirement=" + requirement +
                ", salary=" + salary +
                ", idCard=" + idCard +
                ", contact=" + contact +
                ", nationality=" + nationality +
                ", nation=" + nation +
                ", trade=" + trade +
                ", kind=" + kind +
                ", dataStatus=" + dataStatus +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", trainProject=" + trainProject +
                ", cost=" + cost +
                ", trainTime=" + trainTime +
                ", trainArea=" + trainArea +
                ", trainPhone=" + trainPhone +
                ", advantage=" + advantage +
                ", trainId=" + trainId +
                "}";
    }
}
