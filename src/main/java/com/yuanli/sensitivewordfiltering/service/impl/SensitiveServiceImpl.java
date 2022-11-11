package com.yuanli.sensitivewordfiltering.service.impl;

import cn.hutool.dfa.WordTree;
import com.yuanli.sensitivewordfiltering.dao.WordDao;
import com.yuanli.sensitivewordfiltering.entity.OneWord;
import com.yuanli.sensitivewordfiltering.service.SensitiveService;
import com.yuanli.sensitivewordfiltering.tool.SensitiveWordFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YuanLi
 * @version 1.0
 * @date 2022/11/11 16:35
 */
@Service
public class SensitiveServiceImpl implements SensitiveService {

    @Autowired
    WordDao wordDao;

    @Autowired
    SensitiveWordFilter sensitiveWordFilter;

    String fileName="D:\\IDEA\\SoftwareTest\\sensitive-word-filtering\\src\\main\\java\\com\\yuanli\\sensitivewordfiltering\\tool\\myku.txt";

    public void fileDataImportDatabase(){
        String[] words = sensitiveWordFilter.getSensitiveWordsByFileName(fileName,",");
        for (int i = 0; i < words.length ; i++) {
            wordDao.insert( new OneWord(words[i]));
        }
    }


}
