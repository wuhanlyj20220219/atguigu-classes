package com.atguigu.saprk.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_WordCount {
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
    // 逐行处理文件
    // 2. 将一行数据进行拆分，形成一个一个的单词（分词）
    //    扁平化：将整体拆分成个体的操作
    //   "hello world" => hello, world, hello, world
    val line: RDD[String] = lines.flatMap((lines: String) => {
      lines.split(" ")
    })
    //line.foreach(println)
    // 3. 将数据根据单词进行分组，便于统计
    //   (scala,Seq(scala))
    //  (liu,Seq(liu))
    // (hello,Seq(hello, hello))
    // (zhang,Seq(zhang, zhang))
    // (san,Seq(san))
    // (world,Seq(world))
    val wordsGroup: RDD[(String, Iterable[String])] = line.groupBy(line => line)

    // wordsGroup.foreach(println)
    // 4. 对分组后的数据进行转换
    //    (hello, 3), (world, 2)
    val wordCount: RDD[(String, Int)] = wordsGroup.mapValues(wordsGroup => wordsGroup.size)


    // 5. 将转换结果采集到控制台打印出来
    val wcResult: Array[(String, Int)] = wordCount.collect()
    wcResult.foreach(println)
    // TODO 关闭连接
    sc.stop()

  }

}
