package com.ibeifeng.sparkproject.spark.session

import com.ibeifeng.sparkproject.conf.ConfigurationManagerScala
import com.ibeifeng.sparkproject.constant.GetConstantsScala
import com.ibeifeng.sparkproject.test.MockDataScala
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}


object UserVisitSessionAnalyzeSparkScala extends GetConstantsScala {

  def main(args: Array[String]): Unit = {

    // spark上下文对象构建
    val conf: SparkConf = new SparkConf()
      .setMaster(SPARK_LOCAL)
      .setAppName(SPARK_APP_NAME_SESSION)
    val sc: SparkContext = new SparkContext(conf)


    //1.-----------------------------------------------------------------------//
    /**
     * 获取SQLContext
     * 如果是在本地测试环境的话，那么就生成SQLContext对象
     * 如果是在生产环境运行的话，那么就生成HiveContext对象
     *
     * @param sc SparkContext
     * @return SQLContext
     */
    val configurationManager = new ConfigurationManagerScala

    def getSQLContext(sc: SparkContext): SQLContext = {
      // val local: Boolean = ConfigurationManager.getBoolean(SPARK_LOCAL)
      // true
      val local: Boolean = configurationManager.getBoolean(SPARK_LOCAL)

      if (local == true) {
        return new SQLContext(sc)
      }
      else {
        return new HiveContext(sc)
      }
    }

    // 获得sql上下文
    val sqlContext: SQLContext = getSQLContext(sc)

    //2.-----------------------------------------------------------------------//


    /**
     * 生成模拟数据（只有本地模式，才会去生成模拟数据）
     *
     * @param sc
     * @param sqlContext
     */

    def mockData( // sc: JavaSparkContext
                  sc: SparkContext, sqlContext: SQLContext): Unit = {

      // val local: Boolean = ConfigurationManager.getBoolean(SPARK_LOCAL)
      val local: Boolean = configurationManager.getBoolean(SPARK_LOCAL)
      if (local) MockDataScala.mock(sc, sqlContext)
      else " "
    }
    // 生成测试数据
    mockData(sc,sqlContext)
    //3.-----------------------------------------------------------------------//

    //关闭
    sc.stop()

  }
}
