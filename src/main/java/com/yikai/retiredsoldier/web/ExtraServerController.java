package com.yikai.retiredsoldier.web;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.yikai.retiredsoldier.entity.Business;
import com.yikai.retiredsoldier.service.BusinessService;
import com.yikai.retiredsoldier.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2019/3/16 17:21
 */
@Controller
public class ExtraServerController {

    //百度地图
    @GetMapping("/map")
    public String toMap(){
        return "extra/map";
    }

    //druid监控
    @GetMapping("/sql")
    public String toSql(){
        return "redirect:/druid/index";
    }



}
