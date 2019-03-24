package com.yikai.retiredsoldier.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yikai.retiredsoldier.entity.*;
import com.yikai.retiredsoldier.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author wangyikai
 * @Date 2018/12/14 - 17:08
 */
@Controller
public class LoginController {
    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private SoldierService soldierService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private AdministratorService administratorService;

    /**
     * @Date:2019/2/19 9:01 @Auth:yikai.wang @Desc(V/B):〈输入用户名密码进行登录〉
     */
    @PostMapping("/user/login")
    public String login(@RequestParam String username, @RequestParam String password, Map<String, Object> map, HttpSession session) {
        User user = new User();
        try {
            EntityWrapper<User> wrapper = new EntityWrapper<>();
            wrapper.eq("username", username);
            if (userService.selectOne(wrapper) == null) {
                map.put("msg", "用户名输入错误");
                return "login";
            }
            user = userService.selectOne(wrapper);
            if (!StringUtils.isEmpty(username) && user.getPassword().equals(password)) {
                session.setAttribute("loginUser", username);
                //使用和重定向解决表单重复提交的问题
                return "redirect:/main.html";
            } else {
                map.put("msg", "密码输入错误");
                return "login";
            }
        } catch (Exception e) {
            logger.error("error in LoginController.login", e);
        }
        return "login";
    }

    /**
     * @Date:2019/2/19 9:00 @Auth:yikai.wang @Desc(V/B):〈跳转到注册页〉
     */
    @GetMapping("/user/register")
    public String toRegisterPage(Model model) {
        try {

            List<Identity> identities = identityService.selectList(null);
            if (!CollectionUtils.isEmpty(identities)) {
                model.addAttribute("identities", identities);
            }
        } catch (Exception e) {
            logger.error("error in LoginController.toRegisterPage", e);
        }
        return "user/regist";
    }

    /**
     * @Date:2019/2/19 9:01 @Auth:yikai.wang @Desc(V/B):〈进行注册〉
     */
    @PostMapping("/user")
    public String register(User user) {
        Soldier soldier = new Soldier();
        Administrator administrator = new Administrator();
        Business business = new Business();
        try {
            if (user != null) {
                user.setCreateTime(new Date());
                userService.insert(user);
            }
            //在创建登录名密码的同时,根据角色信息新建角色
            switch (user.getIdentity()) {
                case "退役士兵":
                    soldier.setUserId(user.getId());
                    soldier.setCreateTime(new Date());
                    soldier.setDataStatus(1);
                    soldierService.insert(soldier);
                    break;
                case "企业":
                    business.setUserId(user.getId());
                    business.setCreateTime(new Date());
                    business.setDataStatus(1);
                    businessService.insert(business);
                    break;
                case "管理员":
                    administrator.setUserId(user.getId());
                    administrator.setCreateTime(new Date());
                    administrator.setDataStatus(1);
                    administratorService.insert(administrator);
                    break;
            }
        } catch (Exception e) {
            logger.error("error in LoginController.register", e);
        }
        return "/login";
    }


    /**
     * @Date:2019/2/19 9:01 @Auth:yikai.wang @Desc(V/B):〈点击注销,跳转首页〉
     */
    @GetMapping("/user/logout")
    public String logout() {
        return "/login";
    }

}

