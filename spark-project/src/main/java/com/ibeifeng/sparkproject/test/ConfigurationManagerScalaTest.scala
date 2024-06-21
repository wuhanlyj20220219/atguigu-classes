package com.ibeifeng.sparkproject.test

import com.ibeifeng.sparkproject.conf.ConfigurationManagerScala

object ConfigurationManagerScalaTest {
  def main(args: Array[String]): Unit = {
    val manager = new ConfigurationManagerScala
    val manager2 = new ConfigurationManagerScala
    println(manager.getProperty("testkey1"))
    println(manager2.getProperty("testkey2"))
  }
}
/*没有注释底下的代码时候
* 错误: main 方法不是类 com.ibeifeng.sparkproject.test.
* ConfigurationManagerTest 中的static, 请将 main 方法定义为:
   public static void main(String[] args)
* */


class ConfigurationManagerScalaTest {
  def main(args: Array[String]): Unit = {


  }
}
