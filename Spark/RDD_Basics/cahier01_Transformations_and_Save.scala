// Databricks notebook source
// MAGIC %md 
// MAGIC # Cahier01: Transformations and actions

// COMMAND ----------

// MAGIC %md
// MAGIC Find the 10 words with the highest frecuence

// COMMAND ----------

val textRDD = sc.textFile("FileStore/tables/2600_0.txt")

// COMMAND ----------

// MAGIC %md
// MAGIC #### Filtering lines by words

// COMMAND ----------

val motRDD = textRDD.flatMap(ligne => ligne.split(" "))

// COMMAND ----------

// MAGIC %md 
// MAGIC #### Getting frequence

// COMMAND ----------

val motWcRDD = motRDD.map(mot => (mot,1))
val sortieMotRDD = motWcRDD.reduceByKey( (a,b) => a+b )

// COMMAND ----------

// MAGIC %md
// MAGIC #### Getting the 10 words with highest frequence
// MAGIC 
// MAGIC Here, we are going to use an anonymous

// COMMAND ----------

sortieMotRDD.take(10)

// COMMAND ----------

// MAGIC %md
// MAGIC ### Action

// COMMAND ----------

// MAGIC %md
// MAGIC #### Save to File

// COMMAND ----------

// sortieMotRDD.saveAsTextFile("file:///home/cloudera/spark_manip_scala/wc")

// COMMAND ----------


