package com.atguigu.saprk.core.rdd.trans

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_Map {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)
    // TODO 算子 - map
    val listRdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5))

    val listRdd2: RDD[Int] = listRdd.map(_ * 2)
    //listRdd.map((num: Int) => {num * 2})
    listRdd2.foreach(println)
    sc.stop()
  }
}
