// Databricks notebook source
// MAGIC %md 
// MAGIC # Cahier01: Transformations.

// COMMAND ----------

val textRDD = sc.textFile("FileStore/tables/2600_0.txt")

// COMMAND ----------

// MAGIC %md
// MAGIC #### Filtering lines by content

// COMMAND ----------

val GutenbergRDD = textRDD.filter(ligne => ligne.contains("Gutenberg"))

// COMMAND ----------

// taking first five lines
GutenbergRDD.take(5)

// COMMAND ----------

// MAGIC %md 
// MAGIC #### Getting length of the lines containing the word "Gutenberg"

// COMMAND ----------

val gutenberg_lenghtRDD = GutenbergRDD.map(ligne => ligne.length)
gutenberg_lenghtRDD.take(10)

// COMMAND ----------

// MAGIC %md
// MAGIC #### Getting the number of letters in the file
// MAGIC 
// MAGIC Here, we are going to use an anonymous

// COMMAND ----------

GutenbergRDD.map(ligne => ligne.length).reduce((a,b) => a+b)

// COMMAND ----------


