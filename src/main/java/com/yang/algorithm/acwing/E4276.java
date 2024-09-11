package com.yang.algorithm.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E4276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = new String[7*26]; //读入ABC... 对应的拼写，由于是26个字母，每个字母是7行
        String loopLine; //读入要进行展示的字符串
        List<String> prints = new ArrayList<>(); //将要进行展示的字符串转化为多个单词
        int start;
        for (int i = 0; i < 182; i++) {
            words[i] = br.readLine();
        }
        loopLine = br.readLine();

        //当要展示的字符串末尾单词为大写单词时，需要在后面加入一个非大写单词作为单词切割使用
        char c = loopLine.charAt(loopLine.length()-1);
        if(c >= 65 && c <= 90) loopLine = loopLine.concat("a");

        //将字符串分割成单词，注意出现的空字符串需要跳过
        start = 0;
        for (int i = 0; i < loopLine.length(); i++) {
            if(loopLine.charAt(i) < 65 || loopLine.charAt(i) > 90){
                String tmp = loopLine.substring(start, i);
                if(!"".equals(tmp))
                    prints.add(loopLine.substring(start, i));
                start = i+1;
            }
        }

        //逐个单词进行打印输出，我们输出的方式是每行输出每个单词每个字母的对应行
        for (int k = 0; k < prints.size(); k++) {
            String str = prints.get(k);
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < str.length(); j++) {
                    System.out.print(words[7*(str.charAt(j)-'A')+i]+" ");
                }
                System.out.println();
            }
            //值得注意的是，最后一个单词的末尾不能加入空行，因为题目有要求。
            if(k+1 != prints.size()) System.out.println();
        }
    }

    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String loopLine;
        List<String> prints = new ArrayList<>();
        int start;
        loopLine = br.readLine();
        char c = loopLine.charAt(loopLine.length()-1);
        if(c >= 65 && c <= 90) loopLine = loopLine.concat("a");
        start = 0;
        for (int i = 0; i < loopLine.length(); i++) {
            if(loopLine.charAt(i) < 65 || loopLine.charAt(i) > 90){
                String tmp = loopLine.substring(start, i);
                if(!"".equals(tmp))
                    prints.add(loopLine.substring(start, i));
                start = i+1;
            }
        }
        for (int k = 0; k < prints.size(); k++) {
            String str = prints.get(k);
            System.out.println(str);
        }
    }*/
}

//axOBVBVSBHU26:9HOKLTMMCXR62a%<AQPPFEW_p{3<SST##-}8qMDHJc[tJx$JDCOjlhYNCUZOT0m}/^vDCCFGVRGFGjr&lv}VIVVZL5}z