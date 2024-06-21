package com.ibeifeng.sparkproject.util

import java.math.BigDecimal

class NumberUtilsScala {


  /**
   * 格式化小数
   *
   * @param str   字符串
   * @param scale 四舍五入的位数
   * @return 格式化小数
   */
  def formatDouble(num: Double, scale: Int): Double = {
    val bd = new BigDecimal(num)
    //return  bd.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue
    bd.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue
  }
}
