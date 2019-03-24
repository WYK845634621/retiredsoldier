package com.yikai.retiredsoldier.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.yikai.retiredsoldier.entity.Kind;
import com.yikai.retiredsoldier.entity.Soldier;
import com.yikai.retiredsoldier.service.KindService;
import com.yikai.retiredsoldier.service.SoldierService;
import com.yikai.retiredsoldier.util.ExcelUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yikai.wang
 * @since 2019-02-16
 */
@Controller
public class SoldierController {

    private static final Logger logger = Logger.getLogger(SoldierController.class);
    @Autowired
    private SoldierService soldierService;
    @Autowired
    private KindService kindService;

    /**
     * @Note: 导出士兵的Excel
     * @Date:2019/3/24 13:37 @Auth:yikai.wang @Desc(V/B):〈〉
     */
    @GetMapping("/exportSoldierExcel")
    public void exportSoldierExcel(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Soldier> soldiers = soldierService.selectList(null);
            ExcelUtil.generateExcel2(response,soldiers);
        }catch (Exception e){
            logger.error("error in SoldierController.exportSoldierExcel", e);
        }
    }


    /**
     * @Date:2019/2/17 9:57 @Auth:yikai.wang @Desc(V/B):〈查询所有士兵返回列表页面〉
     */
    @GetMapping("/soldiers")
    public String soldiers(@RequestParam(value = "pn", defaultValue = "1") int pn, Model model) {
        try {
//            Soldier soldier = new Soldier();
//            soldier.setId(UUID.randomUUID().toString().replaceAll("-", ""));
//            soldier.setName(soldier.getId().substring(0,3));
//            soldier.setAge((int) (Math.random()*10));
//            soldier.setCreateTime(new Date());
//            soldierService.insert(soldier);
            Page<Soldier> page = new Page<>(pn, 1);
            page = soldierService.selectPage(page, null);
            if (!CollectionUtils.isEmpty(page.getRecords())) {
                model.addAttribute("page", page);
            }
        } catch (Exception e) {
            logger.error("error in SoldierController.soldiers", e);
        }
        return "soldier/list";
    }

    /**
     * @Date:2019/2/17 9:57 @Auth:yikai.wang @Desc(V/B):〈跳转添加士兵页面〉
     */
    @GetMapping("/soldier")
    public String toAddPage(Model model) {
        try {

            List<Kind> kinds = kindService.selectList(null);
            if (!CollectionUtils.isEmpty(kinds)) {
                model.addAttribute("kinds", kinds);
            }
        } catch (Exception e) {
            logger.error("error in SoldierController.toAddPage", e);
        }
        return "soldier/add";
    }

    /**
     * @Date:2019/2/17 10:38 @Auth:yikai.wang @Desc(V/B):〈添加士兵〉
     */
    @PostMapping("/soldier")
    public String addSoldier(Soldier soldier) {
        try {
            //此处  新增士兵的同时并没有新增登录用户名密码
            if (soldier != null) {
                soldier.setCreateTime(new Date());
                soldier.setDataStatus(1);
                soldierService.insert(soldier);
            }
        } catch (Exception e) {
            logger.error("error in SoldierController.addSoldier", e);
        }
        //跳转到list页面
        return "redirect:/soldiers";
    }


    //来到修改页面,先查出士兵信息进行回显
    @GetMapping("/soldier/{id}")
    public String toEditPage(@PathVariable("id") String id, Model model) {
        Soldier soldier = null;
        try {
            if (!StringUtils.isEmpty(id)) {
                soldier = soldierService.selectById(id);
            }
            if (soldier != null) {
                model.addAttribute("soldier", soldier);
            }
            List<Kind> kinds = kindService.selectList(null);
            if (!CollectionUtils.isEmpty(kinds)) {
                model.addAttribute("kinds", kinds);
            }
        } catch (Exception e) {
            logger.error("error in SoldierController.toEditPage", e);
        }

        //修改添加二合一
        return "soldier/add";
    }

    //修改
    @PutMapping("/soldier")
    public String updateSoldier(Soldier soldier) {
        try {
            if (soldier != null && !StringUtils.isEmpty(soldier.getId())) {
                soldierService.updateById(soldier);
            }
        } catch (Exception e) {
            logger.error("error in SoldierController.updateSoldier", e);
        }
        return "redirect:/soldiers";
    }

//    //按钮删除
//    @DeleteMapping("/soldier/{id}")
//    public String deleteSoldier(@PathVariable("id") String id){
//        try {
//            if (!StringUtils.isEmpty(id)){
//                soldierService.deleteById(id);
//            }
//        }catch (Exception e){
//            logger.error("error in SoldierController.deleteSoldier",e);
//        }
//        return "redirect:/soldiers";
//    }

    /**
     * @Date:2019/2/24 13:10 @Auth:yikai.wang @Desc(V/B):〈超链接删除士兵〉
     */
    @GetMapping("/soldier/delete/{id}")
    public String deleteSoldier(@PathVariable("id") String id) {
        try {
            if (!StringUtils.isEmpty(id)) {
                soldierService.deleteById(id);
            }
        } catch (Exception e) {
            logger.error("error in BusinessController.deleteTrain", e);
        }
        return "redirect:/trains";
    }


}

