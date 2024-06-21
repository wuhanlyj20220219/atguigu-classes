package com.atguigu.saprk.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_WordCount {
  def main(args: Array[String]): Unit = {

    // Application
    // Spark框架
    // TODO 建立和Spark框架的连接
    // JDBC : Connection
    val sparConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(sparConf)

    // TODO 执行业务操作

    // 1. 读取文件，获取一行一行的数据
    //      hello world
    //      hello scala
    //      zhang san
    //      zhang liu
    val lines: RDD[String] = sc.textFile("E:\\spark\\atguigu-classes\\spark-core" +
      "\\src\\main\\resources\\datas.txt")
    val line: RDD[String] = lines.flatMap(lines => lines.split("\\s+"))
    // 3. 将单词进行结构的转换,方便统计
    // word => (word, 1)
    val wordCounts: RDD[(String, Int)] = line.map(word => (word, 1))

    // wordCounts.foreach(println)
    val wcResult: RDD[(String, Int)] = wordCounts.reduceByKey((word1, wordx) => {
      word1 + wordx
    })


    wcResult.foreach(println)
    sc.stop()

  }

}
