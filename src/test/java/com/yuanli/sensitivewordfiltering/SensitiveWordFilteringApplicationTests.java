package com.yuanli.sensitivewordfiltering;

import com.yuanli.sensitivewordfiltering.dao.WordDao;
import com.yuanli.sensitivewordfiltering.entity.OneWord;
import com.yuanli.sensitivewordfiltering.tool.SensitiveWordFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SensitiveWordFilteringApplicationTests {


    @Autowired
    WordDao wordDao;

    @Autowired
    SensitiveWordFilter sensitiveWordFilter;

    @Test
    void contextLoads() {

    }

    @Test
    void initializationByFileNameTest() {
        String fileName="D:\\IDEA\\SoftwareTest\\sensitive-word-filtering\\src\\main\\java\\com\\yuanli\\sensitivewordfiltering\\tool\\myku.txt";
        String[] words = sensitiveWordFilter.getSensitiveWordsByFileName(fileName);
        for (int i = 0; i < words.length ; i++) {
            wordDao.insert( new OneWord(words[i]));
        }
        System.out.println("初始化完毕");
    }

}
