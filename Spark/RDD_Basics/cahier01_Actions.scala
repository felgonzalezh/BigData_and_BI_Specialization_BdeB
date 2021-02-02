// Databricks notebook source
// MAGIC %md
// MAGIC # Cahier01: Actions.

// COMMAND ----------

val textRDD = sc.textFile("FileStore/tables/2600_0.txt")

// COMMAND ----------

// MAGIC %md
// MAGIC #### Counting number of lines

// COMMAND ----------

// it counts number of lines
textRDD.count()

// COMMAND ----------

// MAGIC %md 
// MAGIC #### First Element

// COMMAND ----------

textRDD.first()

// COMMAND ----------

// MAGIC %md
// MAGIC #### Taking first ten elements
// MAGIC 
// MAGIC It shows the first ten lines. As a result we got an array

// COMMAND ----------

textRDD.take(10)

// COMMAND ----------

// MAGIC %md
// MAGIC #### File content
// MAGIC 
// MAGIC Colect function shows the file content

// COMMAND ----------

textRDD.collect()

// COMMAND ----------


