//package com.yikai.retiredsoldier.service.impl;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.yikai.retiredsoldier.entity.User;
//import com.yikai.retiredsoldier.mapper.UserMapper;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Description     实现UserDetailsService以加载springsecurity用户密码权限
// * @Author yikai.wang
// * @Date 2019/2/20 11:09
// */
//@Service
//public class CustomUserService implements UserDetailsService {
//
//    private static final Logger logger = Logger.getLogger(CustomUserService.class);
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = new User();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        try {
//            EntityWrapper<User> wrapper = new EntityWrapper<>();
//            wrapper.eq("username",username);
//            //这里后期要注意完善 数据库中的用户名不能重复,只能唯一
//            user = userMapper.selectList(wrapper).get(0);
//
//            //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉
//            authorities.add(new SimpleGrantedAuthority(user.getIdentity()));
////            authorities.add(new SimpleGrantedAuthority("企业"));
////            authorities.add(new SimpleGrantedAuthority("管理员"));
//            System.out.println(authorities.get(0));
//        }catch (Exception e){
//            logger.error("error in CustomUserService.loadUserByUsername",e);
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
//    }
//}
