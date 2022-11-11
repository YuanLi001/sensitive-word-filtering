package com.yuanli.sensitivewordfiltering.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YuanLi
 * @version 1.0
 * @date 2022/11/10 17:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("words")
public class OneWord {
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;

    private String word;

    public OneWord(String word) {
        this.word = word;
    }
}
