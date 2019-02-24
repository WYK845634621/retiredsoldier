package com.yikai.retiredsoldier.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.yikai.retiredsoldier.entity.Business;
import com.yikai.retiredsoldier.entity.Businesskind;
import com.yikai.retiredsoldier.service.BusinessService;
import com.yikai.retiredsoldier.service.BusinesskindService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  企业信息相关  招聘中心也在这里
 * </p>
 *
 * @author yikai.wang
 * @since 2019-02-18
 */
@Controller
public class BusinessController {
    private static final Logger logger = Logger.getLogger(BusinessController.class);

    @Autowired
    private BusinessService businessService;
    @Autowired
    private BusinesskindService businesskindService;

    /**
     * @Date:2019/2/19 10:44 @Auth:yikai.wang @Desc(V/B):〈跳转到企业列表〉
     */
    @GetMapping("/businesses")
    public String businessList(@RequestParam(value = "pn",defaultValue = "1") int pn, Model model){
        List<Business> businesses = null;
        try {
            //注意这里的pagehelper应该是github的
            Page<Business> page = new Page<>(pn,10);
            if (!CollectionUtils.isEmpty(businessService.selectList(null))){
                page = businessService.selectPage(page,null);
                model.addAttribute("page",page);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.soldiers",e);
        }
        return "business/list";
    }

    /**
     * @Date:2019/2/19 10:44 @Auth:yikai.wang @Desc(V/B):〈点击添加,跳转到添加页面〉
     */
    @GetMapping("/business")
    public String toAddPage(Model model){
        try {
            List<Businesskind> businesskinds = businesskindService.selectList(null);
            model.addAttribute("businesskinds",businesskinds);
        }catch (Exception e){
            logger.error("error in BusinessController.toAddPage",e);
        }
        return "business/add";
    }

    /**
     * @Date:2019/2/19 11:10 @Auth:yikai.wang @Desc(V/B):〈添加操作〉
     */
    @PostMapping("/business")
    public String addBusiness(Business business){
        try {
            if (business != null){
                business.setCreateTime(new Date());
                business.setDataStatus(1);
                businessService.insert(business);
                System.out.println("============" + business.getJobDescribe());
            }
        }catch (Exception e){
            logger.error("error in BusinessController.addBusiness",e);
        }
        return "redirect:/businesses";
    }

    /**
     * @Date:2019/2/19 13:51 @Auth:yikai.wang @Desc(V/B):〈先查出回显,跳到修改页面〉
     */
    @GetMapping("/business/{id}")
    public String toEditPage(@PathVariable("id") String id,Model model){
        Business business = null;
        try {
            if (!StringUtils.isEmpty(id)) {
                business = businessService.selectById(id);
            }
            if (business != null){
                model.addAttribute("business",business);
            }
            List<Businesskind> businesskinds = businesskindService.selectList(null);
            if (!CollectionUtils.isEmpty(businesskinds)){
                model.addAttribute("businesskinds",businesskinds);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.toEditPage",e);
        }
        return "business/add";
    }

    /**
     * @Date:2019/2/19 14:19 @Auth:yikai.wang @Desc(V/B):〈修改〉
     */
    @PutMapping("/business")
    public String updateBusiness(Business business){
        try {
            if (business != null && !StringUtils.isEmpty(business.getId())){
                businessService.updateById(business);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.updateBusiness",e);
        }
        return "redirect:/businesses";
    }

    //使用按钮的方式删除会报错
    /**
     * @Date:2019/2/19 14:30 @Auth:yikai.wang @Desc(V/B):〈删除〉
     */
    @DeleteMapping("/business/{id}")
    public String deleteBusiness(@PathVariable("id") String id){
        try {
            if (!StringUtils.isEmpty(id)){
                businessService.deleteById(id);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.deleteBusiness",e);
        }
        return "redirect:/businesses";
    }

    //使用超链接的方式进行删除
    @GetMapping("/business/delete/{id}")
    public String delete(@PathVariable("id") String id){
        try {
            if (!StringUtils.isEmpty(id)){
                businessService.deleteById(id);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.delete",e);
        }
        return "redirect:/businesses";
    }




    //=======================================================================以下为招聘中心的内容=================================

    /**
     * @Date:2019/2/20 16:40 @Auth:yikai.wang @Desc(V/B):〈招聘中心列表〉
     */
    @GetMapping("/recruits")
    public String recruitsList(@RequestParam(value = "pn",defaultValue = "1") int pn,Model model){
        List<Business> recruits = null;
        try {
            EntityWrapper<Business> wrapper = new EntityWrapper<>();
            Page<Business> page = new Page<>(pn,1);
            wrapper.eq("data_status","2");
            if (!CollectionUtils.isEmpty(businessService.selectList(wrapper))){
                page = businessService.selectPage(page,wrapper);
                model.addAttribute("page",page);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.recruitsList",e);
        }
        return "recruit/list";
    }


    /**
     * @Date:2019/2/20 16:54 @Auth:yikai.wang @Desc(V/B):〈点击发布,跳转到增加页面〉
     */
    @GetMapping("/recruit")
    public String toRecruitAddPage(Model model){
        try {
            List<Businesskind> businesskinds = businesskindService.selectList(null);
            model.addAttribute("businesskinds",businesskinds);
        }catch (Exception e){
            logger.error("error in BusinessController.toRecruitAddPage",e);
        }
        return "recruit/add";
    }

    /**
     * @Date:2019/2/20 17:07 @Auth:yikai.wang @Desc(V/B):〈添加招聘操作〉
     */
    @PostMapping("/recruit")
    public String addRecruit(Business business){
        try {
            if (business != null){
                business.setDataStatus(2);
                business.setCreateTime(new Date());
                businessService.insert(business);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.addRecruit",e);
        }
        return "redirect:/recruits";
    }

    /**
     * @Date:2019/2/20 17:18 @Auth:yikai.wang @Desc(V/B):〈点击编辑招聘,跳转〉
     */
    @GetMapping("/recruit/{id}")
    public String toEditRecruitPage(@PathVariable("id") String id,Model model){
        Business business = null;
        try {
            if (!StringUtils.isEmpty(id)){
                business = businessService.selectById(id);
            }
            if (business != null){
                model.addAttribute("recruit",business);
            }
            List<Businesskind> businesskinds = businesskindService.selectList(null);
            if (!CollectionUtils.isEmpty(businesskinds)){
                model.addAttribute("businesskinds",businesskinds);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.toEditRecruitPage",e);
        }
        return "recruit/add";
    }

    /**
     * @Date:2019/2/20 17:29 @Auth:yikai.wang @Desc(V/B):〈修改招聘〉
     */
    @PutMapping("/recruit")
    public String editRecruit(Business business){
        try {
            if (business != null && !StringUtils.isEmpty(business.getId())){
                businessService.updateById(business);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.editRecruit",e);
        }
        return "redirect:/recruits";
    }

    /**
     * @Date:2019/2/20 17:37 @Auth:yikai.wang @Desc(V/B):〈删除招聘〉
     */
    @GetMapping("/recruit/delete/{id}")
    public String deleteRecruit(@PathVariable("id") String id){
        try {
            if (!StringUtils.isEmpty(id)){
                businessService.deleteById(id);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.deleteRecruit",e);
        }
        return "redirect:/recruits";
    }


    //=======================================================================以下为培训服务的内容=================================
    /**
     * @Date:2019/2/23 16:21 @Auth:yikai.wang @Desc(V/B):〈点击bar,跳转培训列表〉
     */
    @GetMapping("/trains")
    public String trainList(@RequestParam(value = "pn",defaultValue = "1")int pn,Model model){
        try {
            Page<Business> page = new Page<>(pn,10);
            EntityWrapper<Business> wrapper = new EntityWrapper<>();
            wrapper.eq("data_status",3);
            if (!CollectionUtils.isEmpty(businessService.selectPage(page,wrapper).getRecords())){
                page = businessService.selectPage(page,wrapper);
                model.addAttribute("page",page);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.trainList",e);
        }
        return "train/list";
    }

    
    /**
     * @Date:2019/2/23 19:11 @Auth:yikai.wang @Desc(V/B):〈点击添加,跳到添加页面〉
     */
    @GetMapping("/train")
    public String toAddTrainPage(Model model){
        try {
            List<Businesskind> businesskinds = businesskindService.selectList(null);
            model.addAttribute("businesskinds",businesskinds);
        }catch (Exception e){
            logger.error("error in BusinessController.toAddTrainPage",e);
        }
        return "train/add";
    }

    /**
     * @Date:2019/2/24 10:30 @Auth:yikai.wang @Desc(V/B):〈添加培训机构〉
     */
    @PostMapping("/train")
    public String addTrain(Business business){
        try {
            if (business != null){
                business.setDataStatus(3);
                business.setCreateTime(new Date());
                businessService.insert(business);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.toAddTrainPage",e);
        }
        return "redirect:/trains";
    }

    /**
     * @Date:2019/2/24 10:36 @Auth:yikai.wang @Desc(V/B):〈去编辑页〉
     */
    @GetMapping("/train/{id}")
    public String toEditTrainPage(@PathVariable("id")String id,Model model){
        Business train = null;
        try {
            if (!StringUtils.isEmpty(id)){
                train = businessService.selectById(id);
            }
            if (train != null){
                model.addAttribute("train",train);
            }
            List<Businesskind> businesskinds = businesskindService.selectList(null);
            if (!CollectionUtils.isEmpty(businesskinds)){
                model.addAttribute("businesskinds",businesskinds);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.toEditTrainPage",e);
        }
        return "train/add";
    }



    /**
     * @Date:2019/2/24 10:44 @Auth:yikai.wang @Desc(V/B):〈修改培训〉
     *
     * @Param:  [train]
     * @return  java.lang.String
     */
    @PutMapping("/train")
    public String editTrain(Business train){
        try {
            if (!StringUtils.isEmpty(train.getId())){
                businessService.updateById(train);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.editTrain",e);
        }
        return "redirect:/trains";
    }


    /**
     * @Date:2019/2/24 10:52 @Auth:yikai.wang @Desc(V/B):〈删除培训〉
     *
     * @Param:  [id]
     * @return  java.lang.String
     */
    @GetMapping("/train/delete/{id}")
    public String deleteTrain(@PathVariable("id")String id){
        try {
            if (!StringUtils.isEmpty(id)){
                businessService.deleteById(id);
            }
        }catch (Exception e){
            logger.error("error in BusinessController.deleteTrain",e);
        }
        return "redirect:/trains";
    }

}

