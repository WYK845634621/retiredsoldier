package com.yikai.retiredsoldier.service.impl;

import com.yikai.retiredsoldier.entity.Soldier;
import com.yikai.retiredsoldier.mapper.SoldierMapper;
import com.yikai.retiredsoldier.service.SoldierService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SoldierServiceImpl extends ServiceImpl<SoldierMapper, Soldier> implements SoldierService {

}
