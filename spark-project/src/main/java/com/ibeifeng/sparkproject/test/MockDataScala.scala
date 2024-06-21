package com.ibeifeng.sparkproject.test

import com.ibeifeng.sparkproject.util.{DateUtilsScala, StringUtilsScala}
import org.apache.spark._
import org.apache.spark.sql.{Row, RowFactory, SQLContext}

import java.util.UUID
import scala.collection.mutable.ListBuffer
import scala.util.Random

object MockDataScala {
  def main(args: Array[String]): Unit = {
    /*val searchKeywords: Array[String] = Array[String]("火锅", "蛋糕", "重庆辣子鸡", "重庆小面", "呷哺呷哺", "新辣道鱼火锅",
      "国贸大厦", "太古商场", "日本料理", "温泉")
    searchKeywords.foreach(keyword => println(keyword))
     searchKeywords.foreach(println(_))
     val date: String = DateUtils.getTodayDate
     println(date.toString)
    */
    /*  val random = new Random(10)
      val randomNumbers = (1 to 100).map { _ =>
        println(random.nextInt())
      }*/
    /*val random = new Random()
    for (i <- 1 to 100) {
      val userid: Long = random.nextInt(100)
      println(userid)
    }*/

    val conf: SparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("MockData")
    val sc: SparkContext = new SparkContext(conf)
    val sqlContext: SQLContext = new SQLContext(sc)


    mock(sc, sqlContext)
  }

  def mock(sc: SparkContext, sqlContext: SQLContext) {
    val rows: ListBuffer[Row] = new ListBuffer[Row]
    val searchKeywords: Array[String] = Array[String]("火锅", "蛋糕", "重庆辣子鸡",
      "重庆小面", "呷哺呷哺", "新辣道鱼火锅",
      "国贸大厦", "太古商场", "日本料理", "温泉")

    val date: String = DateUtilsScala.getTodayDate
    val actions: Array[String] = Array[String]("search", "click", "order", "pay")
    val random = new Random()
    for (i <- 1 to 100) {
      var userid: Long = random.nextInt(100)
      for (i <- 1 to 10) {

        var sessionid: String = UUID.randomUUID.toString.replace("-", "")
        var baseActionTime: String = date + " " + random.nextInt(23)
        //val clickCategoryId: Long = null
        val clickCategoryId: Long = 1
        for (k <- 1 to random.nextInt(100)) {
          var pageid: Long = random.nextInt(10)

          var actionTime: String = baseActionTime + ":" +
            StringUtilsScala.fulfuill(String.valueOf(random.nextInt(59))) +
            ":" + StringUtilsScala.fulfuill(String.valueOf(random.nextInt(59)))
          var searchKeyword: String = null
          var clickProductId: Long = 1
          var orderCategoryIds: String = null
          var orderProductIds: String = null
          var payCategoryIds: String = null
          var payProductIds: String = null
          var action: String = actions(random.nextInt(4))
          if ("search".equals(action)) {
            //searchKeyword = searchKeywords(random.nextInt(10))
            var searchKeyword = searchKeywords(random.nextInt(10))
          }
          else if ("click".equals(action)) {
            if (clickCategoryId == null) {
              //clickCategoryId = Long.valueOf(String.valueOf(random.nextInt(100)));
              var clickCategoryId = String.valueOf(random.nextInt(100)).toLong
            }
            //clickProductId = Long.valueOf(String.valueOf(random.nextInt(100)));
            var clickProductId = String.valueOf(random.nextInt(100)).toLong
          }
          else if ("order".equals(action)) {
            var orderCategoryIds = String.valueOf(random.nextInt(100))
            var orderProductIds = String.valueOf(random.nextInt(100))
          }
          else if ("pay".equals(action)) {
            var payCategoryIds = String.valueOf(random.nextInt(100))
            var payProductIds = String.valueOf(random.nextInt(100))
          }
          var row: Row = RowFactory.create(date, userid, sessionid,
            pageid, actionTime, searchKeyword,
            clickCategoryId, clickProductId,
            orderCategoryIds, orderProductIds,
            payCategoryIds, payProductIds,
            //Long.valueOf(String.valueOf(random.nextInt(10)))
            String.valueOf(random.nextInt(10)).toLong
          )
          //rows.add(row);
          // rows.append(row)
          println(rows.addOne(row))
        }
      }
    }
  }
}
