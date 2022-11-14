package com.yuanli.sensitivewordfiltering.config;

import cn.hutool.dfa.WordTree;
import com.yuanli.sensitivewordfiltering.dao.WordDao;
import com.yuanli.sensitivewordfiltering.entity.OneWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author YuanLi
 * @version 1.0
 * @date 2022/11/11 20:14
 */
@Configuration
public class SensitiveConfig {


    @Autowired
    WordDao wordDao;

    @Bean
    public WordTree wordTree(){
//        long startTime=System.currentTimeMillis();   //获取开始时间
        WordTree wordTree=new WordTree();
        List<OneWord> allWords = wordDao.getAllWords();
        for (int i = 0; i < allWords.size(); i++) {
            wordTree.addWord(allWords.get(i).getWord());
        }
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        return wordTree;
    }

}
