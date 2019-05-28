package com.yikai.retiredsoldier.mapper;

import com.yikai.retiredsoldier.entity.BusinessSoldier;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yikai.wang
 * @since 2019-05-26
 */
@Repository
public interface BusinessSoldierMapper extends BaseMapper<BusinessSoldier> {

    List<String> findSoldiersIdsById(String id);
    List<String> findSoldiersIdsById2(String id);
}
