package com.yuanli.sensitivewordfiltering.tool;

import cn.hutool.dfa.WordTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author YuanLi
 * @version 1.0
 * @date 2022/11/10 13:29
 */
@Component
public class SensitiveWordFilter {

    @Autowired
    WordTree wordTree;

    /**
     * 从文件中读取敏感词
     * @param fileName 文件路径
     * @param delimiter 敏感词分隔符 如：","
     * @return
     */
    public String[] getSensitiveWordsByFileName(String fileName,String delimiter) {
        BufferedReader reader = null;
        StringBuilder stringBuilder=null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String[] words = stringBuilder.toString().split(delimiter);
        return words;
    }

    //返回所有的敏感词 or null
    public List<String> getAllSensitiveWords(String text){
        List<String> list = wordTree.matchAll(text, -1, false, false);
        return list;
    }

    //返回字符串中包含的第一个敏感词，否则返回null
    public String getFirstSensitiveWord(String text){
        return wordTree.match(text);
    }

    //将字符串中的敏感词替换成指定符号
    public String sensitiveWordReplacedByChar(String text,char ch){
        String str=""+ch+ch;
        String resultStr=text;
        List<String> allSensitiveWords = getAllSensitiveWords(text);
        for(String s:allSensitiveWords){
            resultStr= resultStr.replace(s,str);
        }
        return resultStr;
    }

}
