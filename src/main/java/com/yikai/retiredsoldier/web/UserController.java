package com.yikai.retiredsoldier.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yikai.retiredsoldier.entity.Administrator;
import com.yikai.retiredsoldier.entity.Business;
import com.yikai.retiredsoldier.entity.Soldier;
import com.yikai.retiredsoldier.entity.User;
import com.yikai.retiredsoldier.service.AdministratorService;
import com.yikai.retiredsoldier.service.BusinessService;
import com.yikai.retiredsoldier.service.SoldierService;
import com.yikai.retiredsoldier.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yikai.wang
 * @since 2019-02-16
 */
@Controller
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private SoldierService soldierService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }


    @GetMapping("/userInfo/{username}")
    public String toUserInfo(@PathVariable("username") String username, Model model){
        User user = new User();
        Soldier soldier = new Soldier();
        Business business = new Business();
        Administrator administrator = new Administrator();
        try {
            if (!StringUtils.isEmpty(username)){
                user = userService.selectOne(new EntityWrapper<User>().eq("username",username));
            }
            if (StringUtils.isEmpty(user.getId())){
                return "error/5xx";
            }
            if (user != null){
                model.addAttribute("role",user);
            }
        }catch (Exception e){
            logger.error("error in UserController.toUserInfo()",e);
        }
        return "user/userInfo";
    }

}

