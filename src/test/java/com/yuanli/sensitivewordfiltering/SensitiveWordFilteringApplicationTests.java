package com.yuanli.sensitivewordfiltering;

import com.yuanli.sensitivewordfiltering.dao.WordDao;
import com.yuanli.sensitivewordfiltering.entity.OneWord;
import com.yuanli.sensitivewordfiltering.tool.SensitiveWordFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        String[] words = sensitiveWordFilter.getSensitiveWordsByFileName(fileName,",");
        for (int i = 0; i < words.length ; i++) {
            wordDao.insert( new OneWord(words[i]));
        }
        System.out.println("初始化完毕");
    }

    @Test
    void getAllSensitiveWordsTest(){
        String text1="傻逼123赌博哈哈AV";
        String text2="哈哈哈哈";
        String text3="傻@@@逼123赌%%博哈哈A‘’V";
        List<String> allSensitiveWords1 = sensitiveWordFilter.getAllSensitiveWords(text1);
        List<String> allSensitiveWords2 = sensitiveWordFilter.getAllSensitiveWords(text2);
        List<String> allSensitiveWords3 = sensitiveWordFilter.getAllSensitiveWords(text3);
        System.out.println(allSensitiveWords1);
        System.out.println(allSensitiveWords2);
        System.out.println(allSensitiveWords3);
    }

    @Test
    void getFirstSensitiveWordTest(){
        String text1="傻逼123赌博哈哈AV";
        String text2="哈哈哈哈";
        String text3="傻@@@逼123赌%%博哈哈A‘’V";
        String firstSensitiveWord1 = sensitiveWordFilter.getFirstSensitiveWord(text1);
        String firstSensitiveWord2 = sensitiveWordFilter.getFirstSensitiveWord(text2);
        String firstSensitiveWord3 = sensitiveWordFilter.getFirstSensitiveWord(text3);
        System.out.println(firstSensitiveWord1);
        System.out.println(firstSensitiveWord2);
        System.out.println(firstSensitiveWord3);
    }

    @Test
    void sensitiveWordReplacedByStarTest(){
        String text1="傻逼123赌博哈哈AV";
        String text2="哈哈哈哈";
        String text3="傻@@@逼123赌%%博哈哈A‘’V";
        String s1 = sensitiveWordFilter.sensitiveWordReplacedByChar(text1, '*');
        String s2 = sensitiveWordFilter.sensitiveWordReplacedByChar(text2, '*');
        String s3 = sensitiveWordFilter.sensitiveWordReplacedByChar(text3, '*');
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
