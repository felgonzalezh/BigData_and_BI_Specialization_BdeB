// Databricks notebook source
// MAGIC %md
// MAGIC #Serie_1 

// COMMAND ----------

// MAGIC %md
// MAGIC name|age|sex|address | city| province | code postal

// COMMAND ----------

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
// SQLContext entry point pour les donnees structures
val sqlContext = SparkSession
   .builder()
   .enableHiveSupport()
   .getOrCreate()    // conversion RDD vers DataFrame.
    import sqlContext.implicits._

// COMMAND ----------

case class Client(name:String, age:Integer, sex:String, address:String, city:String, province:String, cp:String)

// COMMAND ----------

// chargement du data au niveau du DataFrame. 
val Clients_text = sc.textFile("FileStore/tables/clients.csv")
    Clients_text.first()

// COMMAND ----------

val clients = Clients_text.map(_.split('|')).map(p => Client(p(0),p(1).toInt,p(2),p(3), p(4),p(5),p(6)))

// COMMAND ----------

val df_clients = clients.toDF()

// COMMAND ----------

df_clients.printSchema()

// COMMAND ----------

print(df_clients.show())

// COMMAND ----------

// MAGIC %md
// MAGIC Afficher les clients dont l’âge est inférieur à 32 ans et sont male.

// COMMAND ----------

val hommes_jeunes = df_clients.filter("age < 32")
hommes_jeunes.show()


// COMMAND ----------

// Nombre de bids par auction?
df_clients.createOrReplaceTempView("clientstable")
val results = sqlContext.sql("SELECT * FROM clientstable WHERE age < 32")
// Afficher le dataframe dans un format tabulaire
results.show()

// COMMAND ----------


