package com.yuanli.sensitivewordfiltering.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanli.sensitivewordfiltering.entity.OneWord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author YuanLi
 * @version 1.0
 * @date 2022/11/10 17:04
 */
@Repository
//@Mapper
public interface WordDao extends BaseMapper<OneWord> {

}
