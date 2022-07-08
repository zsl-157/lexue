package com.gateway.gateway.common;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author :zsl
 * @date :2022/7/8 0008
 **/
@Configuration
public class WhiteList {
    public static List<String> WHITE_LIST = new ArrayList<>();

    static {
        WHITE_LIST.add("/api/v1");

    }

    public static void addWhiteList(String path){
        WHITE_LIST.add(path);
    }
    public static List<String> getWhiteList(){
        return WHITE_LIST;
    }

    public static void main(String[] args) {
        WhiteList.addWhiteList("/v2");
        for (int i=0;i<WHITE_LIST.size();i++){
            System.out.println(WHITE_LIST.get(i));
        }
    }


}
