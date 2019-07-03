name := "spark-app"

val projectVersion = "0.1"

scalaVersion := "2.11.12"

val spark = "org.apache.spark" %% "spark-core" % "2.4.0" % "provided"
val sparkSql = "org.apache.spark" %% "spark-sql" % "2.4.0" % "provided"
val sparkSqlKafka  = "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.4.0"
val sparkSqlKafkaStreaming = "org.apache.spark" %% "spark-streaming-kafka-0-10"  % "2.4.0"


lazy val spark_app = (project in file("."))
  .settings(
    name := "spark-app",
    version := projectVersion,
    organization := "com.cacoveanu.spark",
    libraryDependencies ++= Seq(
      sparkSql,
      sparkSqlKafka,
      sparkSqlKafkaStreaming
    )
  )