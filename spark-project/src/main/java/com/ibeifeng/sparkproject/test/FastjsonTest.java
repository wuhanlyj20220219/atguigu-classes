package com.ibeifeng.sparkproject.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibeifeng.sparkproject.conf.ConfigurationManager;
import com.ibeifeng.sparkproject.constant.Constants;

/**
 * fastjson测试类
 *
 * @author Administrator
 */
public class FastjsonTest {

    public static void main(String[] args) {
       // String json = "[{'学生':'张三', '班级':'一班', '年级':'大一', '科目':'高数', '成绩':90}, {'学生':'李四', '班级':'二班', '年级':'大一', '科目':'高数', '成绩':80}]";
        String json="[ {'startAge':'10', 'endAge':'50', 'startDate':'2024-06-11', 'endDate':'2024-06-11'} ]";
        JSONArray jsonArray = JSONArray.parseArray(json);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        System.out.println(jsonObject.getString("startAge"));
       /* Boolean aBoolean = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
        System.out.println(aBoolean);*/
    /*    Properties prop = new Properties();

        InputStream in = ConfigurationManager.class
                .getClassLoader().getResourceAsStream("my.properties");*/



    }

}
