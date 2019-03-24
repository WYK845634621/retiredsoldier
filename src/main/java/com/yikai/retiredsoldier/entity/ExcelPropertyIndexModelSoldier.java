package com.yikai.retiredsoldier.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2019/3/24 14:03
 */
public class ExcelPropertyIndexModelSoldier extends BaseRowModel {

    @ExcelProperty(value = "流水号",index = 0)
    private String id;

    @ExcelProperty(value = "姓名",index = 1)
    private String name;

    @ExcelProperty(value = "年龄",index = 2)
    private String age;

    @ExcelProperty(value = "性别",index = 3)
    private String gender;
    @ExcelProperty(value = "联系电话",index = 3)
    private String phone;
    @ExcelProperty(value = "联系邮箱",index = 4)
    private String email;
    @ExcelProperty(value = "身份证",index = 5)
    private String idCard;
    @ExcelProperty(value = "国籍",index = 6)
    private String nationality;
    @ExcelProperty(value = "名族",index = 7)
    private String nation;
    @ExcelProperty(value = "兵种",index = 8)
    private String kind;
    @ExcelProperty(value = "服役地区",index = 8)
    private String serviceArea;
    @ExcelProperty(value = "现居地址",index = 8)
    private String location;
    @ExcelProperty(value = "创建时间",index = 8)
    private String createTime;
}
