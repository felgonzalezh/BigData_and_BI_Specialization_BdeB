# Databricks notebook source
# MAGIC %md
# MAGIC # Cahier01: Word count (using Python).

# COMMAND ----------

from operator import add
fichier = sc.textFile("FileStore/tables/2600_0.txt")
# sc.textFile reads a text file from HDFS, or any Hadoop-supported file system URI, and return it as an RDD of Strings.

# COMMAND ----------

# FlatMap returnd a new RDD by first applying a function (map(lambda x: (x,1))) to all elements of this RDD, and then flattening the results (reduceByKey(add)).
wc = fichier.flatMap(lambda x: x.split(" ")).map(lambda x: (x,1)).reduceByKey(add)

# COMMAND ----------

wc.saveAsTextFile("FileStore/tables/sortie_cahier01_python.txt")

# COMMAND ----------

dbutils.fs.head("FileStore/tables/sortie_cahier01_python.txt/part-00000")

# COMMAND ----------


