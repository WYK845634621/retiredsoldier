package com.yikai.retiredsoldier.service.impl;

import com.yikai.retiredsoldier.entity.User;
import com.yikai.retiredsoldier.mapper.UserMapper;
import com.yikai.retiredsoldier.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yikai.wang
 * @since 2019-02-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
