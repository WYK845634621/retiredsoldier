package com.yikai.retiredsoldier.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @Description 企业表头
 * @Tips
 * @Author yikai.wang
 * @Date 2019/3/22 9:22
 */
public class ExcelPropertyIndexModelBusiness extends BaseRowModel {
    @ExcelProperty(value = "流水号",index = 0)
    private String id;

    @ExcelProperty(value = "公司名称",index = 1)
    private String name;

    @ExcelProperty(value = "成立时长",index = 2)
    private String age;

    @ExcelProperty(value = "联系方式",index = 3)
    private String phone;
    @ExcelProperty(value = "联系邮箱",index = 4)
    private String email;
    @ExcelProperty(value = "公司地址",index = 5)
    private String location;
    @ExcelProperty(value = "是否上市",index = 6)
    private String trade;
    @ExcelProperty(value = "公司种类",index = 7)
    private String kind;
    @ExcelProperty(value = "创建日期",index = 8)
    private String create_time;
}
