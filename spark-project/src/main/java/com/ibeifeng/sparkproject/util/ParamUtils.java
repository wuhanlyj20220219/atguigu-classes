package com.ibeifeng.sparkproject.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ibeifeng.sparkproject.constant.Constants;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

/*
 * 参数工具类
 * @author Administrator
 *
 */
public class ParamUtils {
    public static void main(String[] args) {


    }

    /*
     * 从命令行参数中提取任务id
     * @param args 命令行参数
     * @return 任务id
     */
    public static Long getTaskIdFromArgs(String[] args) {
        try {
            if (args != null && args.length > 0) {
                //taskid
                return Long.valueOf(args[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 从JSON对象中提取参数
     * @param jsonObject JSON对象
     * @return 参数
     */
    public static String getParam(JSONObject jsonObject, String field) {
        JSONArray jsonArray = jsonObject.getJSONArray(field);
        if (jsonArray != null && jsonArray.size() > 0) {
            return jsonArray.getString(0);
        }
        return null;
    }

}
