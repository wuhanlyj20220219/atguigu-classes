package com.ibeifeng.sparkproject.util

import com.alibaba.fastjson.{JSONArray, JSONObject}


/**
 * 参数工具类
 *
 * @author Administrator
 *
 */
class ParamUtilsScala {
  /**
   * 从命令行参数中提取任务id
   *
   * @param args 命令行参数
   * @return 任务id
   */


  /**
   * 从JSON对象中提取参数
   *
   * @param jsonObject JSON对象
   * @return 参数
   */
  def getParam(jsonObject: JSONObject, field: String): String = {
    val jsonArray: JSONArray = jsonObject.getJSONArray(field)
    if (jsonArray != null && jsonArray.size > 0)
      return jsonArray.getString(0)
    //return null
    null
  }
}
