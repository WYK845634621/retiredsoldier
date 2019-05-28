package com.yikai.retiredsoldier.mapper;

import com.yikai.retiredsoldier.entity.Soldier;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author yikai.wang
 * @since 2019-02-16
 */
@Repository
public interface SoldierMapper extends BaseMapper<Soldier> {

//    List<Soldier> selectBatchSoldiers(@Param(value="soldiersIds")List<String> soldiersIds);
}
