package com.yuanli.sensitivewordfiltering.tool;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

/**
 * @author YuanLi
 * @version 1.0
 * @date 2022/11/10 13:29
 */
@Component
public class SensitiveWordFilter {
//    public static void main(String[] args) throws IOException {
//        String fileName = "D:\\IDEA\\SoftwareTest\\sensitive-word-filtering\\src\\main\\java\\com\\yuanli\\sensitivewordfiltering\\tool\\sensitive_words.txt";
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
////        StringBuilder stringBuilder = new StringBuilder();
//        String line;
//        long startTime=System.currentTimeMillis();   //获取开始时间
//        line = reader.readLine();
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
////        if ((line = reader.readLine()) != null) {
////
////        }
//
////        line.split(/)
////        System.out.println(line);
//
//        reader.close();
//    }
//48603


    public static void main(String[] args) throws IOException {
        String fileName = "D:\\IDEA\\SoftwareTest\\sensitive-word-filtering\\src\\main\\java\\com\\yuanli\\sensitivewordfiltering\\tool\\sensitive_words_lines.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
//        long startTime=System.currentTimeMillis();   //获取开始时间
        while ((line = reader.readLine()) != null){
            if(line.length()>30){
                continue;
            }
            stringBuilder.append(line);
            stringBuilder.append(',');
        }
//            line = reader.readLine();
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//        if ((line = reader.readLine()) != null) {
//
//        }

//        line.split(/)
//        System.out.println(line);
        System.out.println(stringBuilder);
        reader.close();
    }

//    public static void main(String[] args) throws IOException {
//        String fileName = "D:\\IDEA\\SoftwareTest\\sensitive-word-filtering\\src\\main\\java\\com\\yuanli\\sensitivewordfiltering\\tool\\qwe.txt";
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
//        StringBuilder stringBuilder = new StringBuilder();
//        String line;
////        long startTime=System.currentTimeMillis();   //获取开始时间
//        line = reader.readLine();
////        long endTime=System.currentTimeMillis(); //获取结束时间
////        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//        String[] split = line.split(",");
//        System.out.println(split[0]);
//        System.out.println(split[split.length-1]);
//
//        reader.close();
//    }
//
//    //文件内容为一行
////    public String[] getSensitiveWords(String fileName){
////
////    }




    public String[] getSensitiveWordsByFileName(String fileName) {
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
        String[] words = stringBuilder.toString().split(",");
        return words;
    }

//    public static void main(String[] args) {
//        String fileName="D:\\IDEA\\SoftwareTest\\sensitive-word-filtering\\src\\main\\java\\com\\yuanli\\sensitivewordfiltering\\tool\\qwe.txt";
//        String[] words =getSensitiveWordsByFileName(fileName);
//        System.out.println(words[999]);
//        System.out.println(words[1000]);
//        System.out.println(words[1001]);
//
//        System.out.println(words.length);
//        System.out.println(words[0]);
//        System.out.println(words[48602]);
//    }

//    //返回所有的敏感词 or null
//    public Set<String> getAllWords(String str){
//
//    }
}
