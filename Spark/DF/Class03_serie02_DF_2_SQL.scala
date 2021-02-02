// Databricks notebook source
// MAGIC %md
// MAGIC # DataFrame - 2 SQL

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

// MAGIC %md
// MAGIC * 1 Chargez le fichier achats.csv dans un RDD

// COMMAND ----------

val achatsText = sc.textFile("FileStore/tables/achats.txt")
    achatsText.first()

// COMMAND ----------

// MAGIC %md
// MAGIC *  2 Créer un DataFrame à partir du RDD en suivant les étapes suivantes:
// MAGIC         a. Convertir chaque entrée du RDD en un tuple contenant les valeurs de chaque champ au format correct.
// MAGIC         b. Utiliser une classe avec les attributs suivants: timestamp: string, location: string, category: string, price: float, card: string.
// MAGIC         c. Convertir le RDD en DataFrame.

// COMMAND ----------

case class Achats(timestamp: String, location: String, category: String, price: Float, card: String)

// COMMAND ----------

val achats = achatsText.map(_.split(',')).map(p => Achats(p(0),p(1),p(2),p(3).toFloat,p(4)))

// COMMAND ----------

val df_achats = achats.toDF()
// direct:
// var df_spark = spark.read.csv("FileStore/tables/achats.txt")

// COMMAND ----------

// MAGIC %md
// MAGIC 
// MAGIC * 3 Enregistrez le DataFrame en tant que table appelée achats.

// COMMAND ----------

val achatstable = df_achats.collect

// COMMAND ----------

// MAGIC %md 
// MAGIC * 4 Formulez les requêtes pour répondre aux questions ci-dessous -

// COMMAND ----------

// MAGIC %md 
// MAGIC a) Quel est le prix moyen des produits achetés via Mastercard?

// COMMAND ----------

var price_cards = df_achats.groupBy("card").avg("price")
var price_mastercard = price_cards.filter("card == 'MasterCard'")
price_mastercard.show

// COMMAND ----------

df_achats.createOrReplaceTempView("achats")
var result_a = sqlContext.sql("SELECT AVG(price) FROM achats WHERE card='MasterCard';").collect.foreach(println)

// COMMAND ----------

// MAGIC %md
// MAGIC b) Quelle date a enregistré les ventes totales les plus élevées?

// COMMAND ----------

//var results_b = sqlContext.sql("SELECT SUBSTRING(timestamp, 1, 10), SUM(price) AS total FROM achats GROUP BY SUBSTRING(timestamp, 1, 10) ORDER BY total DESC LIMIT 1;").collect.foreach(println)
var results_b = sqlContext.sql("SELECT to_date(timestamp), SUM(price) AS total FROM achats GROUP BY to_date(timestamp) ORDER BY total DESC LIMIT 1;").collect.foreach(println)

// COMMAND ----------

// MAGIC %md 
// MAGIC c) Quelle est la valeur minimale d'un produit dans la catégorie Ordinateurs?

// COMMAND ----------

var results_c = sqlContext.sql("SELECT MIN(price) FROM achats WHERE category='Computers';").collect.foreach(println)


// COMMAND ----------

// MAGIC %md
// MAGIC d) Combien de catégories de produits distinctes existe-t-il?

// COMMAND ----------

var results_d = sqlContext.sql("SELECT COUNT(DISTINCT category) FROM achats;")
results_d.collect.foreach(println)
//var results_d_2 = sqlContext.sql("SELECT DISTINCT category FROM achats;").collect.foreach(println)

// COMMAND ----------

// MAGIC %md
// MAGIC e) Quel magasin a enregistré les ventes totales les plus faibles?

// COMMAND ----------

var results_e = sqlContext.sql("SELECT location, SUM(price) AS total_magasin FROM achats GROUP BY location ORDER BY total_magasin ASC LIMIT 1").collect.foreach(println)

// COMMAND ----------


