package com.yuanli.sensitivewordfiltering.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanli.sensitivewordfiltering.entity.OneWord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YuanLi
 * @version 1.0
 * @date 2022/11/10 17:04
 */
@Repository
public interface WordDao extends BaseMapper<OneWord> {

    @Select("select * from words")
    List<OneWord> getAllWords();
}
