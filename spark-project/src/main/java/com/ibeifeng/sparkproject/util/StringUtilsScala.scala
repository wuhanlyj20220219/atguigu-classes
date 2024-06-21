package com.ibeifeng.sparkproject.util

import scala.util.control.Breaks.break


/**
 * 字符串工具类
 *
 * @author Administrator
 *
 */
object StringUtilsScala {
  /**
   * 判断字符串是否为空
   *
   * @param str 字符串
   * @return 是否为空
   */
  def isEmpty(str: String): Boolean = str == null || "" == str

  /**
   * 判断字符串是否不为空
   *
   * @param str 字符串
   * @return 是否不为空
   */
  def isNotEmpty(str: String): Boolean = str != null && !("" == str)

  def trimComma(str: String): String = {
    if (str.startsWith(",")) {
      str.substring(1)
    }
    if (str.endsWith(",")) {
      str.substring(0, str.length - 1)
    }
    str
  }

  /**
   * 补全两位数字
   *
   * @param str
   * @return
   */
  def fulfuill(str: String): String = if (str.length == 2) str
  else "0" + str

  /**
   * 从拼接的字符串中提取字段
   *
   * @param str       字符串
   * @param delimiter 分隔符
   * @param field     字段
   * @return 字段值
   */
  def getFieldFromConcatString(str: String, delimiter: String, field: String): String = {
    try {
      val fields: Array[String] = str.split(delimiter)
      for (concatField <- fields) { // searchKeywords=|clickCategoryIds=1,2,3
        if (concatField.split("=").length == 2) {
          val fieldName: String = concatField.split("=")(0)
          val fieldValue: String = concatField.split("=")(1)
          if (fieldName == field) return fieldValue
        }
      }
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
    null
  }

  /**
   * 从拼接的字符串中给字段设置值
   *
   * @param str           字符串
   * @param delimiter     分隔符
   * @param field         字段名
   * @param newFieldValue 新的field值
   * @return 字段值
   */
  def setFieldInConcatString(str: String, delimiter: String, field: String, newFieldValue: String): String = {
    val fields: Array[String] = str.split(delimiter)
    for (i <- 0 until fields.length) {
      val fieldName: String = fields(i).split("=")(0)
      if (fieldName == field) {
        val concatField: String = fieldName + "=" + newFieldValue
        fields(i) = concatField
        break //todo: break is not supported

      }
    }
    val buffer = new StringBuffer("")
    for (i <- 0 until fields.length) {
      buffer.append(fields(i))
      if (i < fields.length - 1) buffer.append("|")
    }
    buffer.toString
  }
}
