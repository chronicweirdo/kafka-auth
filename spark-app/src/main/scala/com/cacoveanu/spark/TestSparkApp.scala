package com.cacoveanu.spark

import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

object TestSparkApp {

  /**
    * This program must be run with the following VM options:
    * -Djava.security.auth.login.config=C:\\kafka_2.11-2.2.0\\bin\\windows\\kafka_client_jaas.conf
    */
  def main(args: Array[String]): Unit = {
    //System.setProperty("java.security.auth.login.config", "C:\\kafka_2.11-2.2.0\\bin\\windows\\kafka_client_jaas.conf")

    val conf = new SparkConf()
      //.setExecutorEnv("java.security.auth.login.config", "C:\\kafka_2.11-2.2.0\\bin\\windows\\kafka_client_jaas.conf")
      //.set("spark.executor.extraJavaOptions", "-Djava.security.auth.login.config=C:\\kafka_2.11-2.2.0\\bin\\windows\\kafka_client_jaas.conf")
      //.set("java.security.auth.login.config", "C:\\kafka_2.11-2.2.0\\bin\\windows\\kafka_client_jaas.conf")
    implicit val spark: SparkSession = SparkSession.builder().master("local[1]")
      .config(conf)
      //.config("spark.sql.streaming.schemaInference", true)
      //.config("java.security.auth.login.config", "C:\\kafka_2.11-2.2.0\\bin\\windows\\kafka_client_jaas.conf")
      //.config("spark.driver.extraJavaOptions", "-Djava.security.auth.login.config=C:\\kafka_2.11-2.2.0\\bin\\windows\\kafka_client_jaas.conf")
      //.config("spark.executor.extraJavaOptions", "-Djava.security.auth.login.config=C:\\kafka_2.11-2.2.0\\bin\\windows\\kafka_client_jaas.conf")
      .getOrCreate()
    import spark.implicits._

    spark.sparkContext.setLogLevel("WARN")
    spark.conf.set("spark.sql.session.timeZone", "UTC")

    val data: DataFrame = spark.readStream
      .format("org.apache.spark.sql.kafka010.KafkaSourceProvider")
      .option("kafka.bootstrap.servers", "localhost:12345")
      .option("maxOffsetsPerTrigger", 1)
      .option("subscribe", "test")
      .option("startingOffsets", "earliest")
      .option("failOnDataLoss", "false")
      .option("kafka.max.partition.fetch.bytes", "" + 1024 * 1024 * 1024)
      //.option("key.deserializer", classOf[StringDeserializer]),
      //.option("value.deserializer", classOf[StringDeserializer]),
      .option("kafka.security.protocol", "SASL_PLAINTEXT")
      //.option("security.protocol", "PLAINTEXTSASL")
      .option("kafka.sasl.mechanism", "PLAIN")
      .load()

    data.writeStream.format("console").start().awaitTermination()
  }
}
