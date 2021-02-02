// Databricks notebook source
// MAGIC %md
// MAGIC # DataFrame-SQL

// COMMAND ----------

// MAGIC %md
// MAGIC auctionid - unique identifier of an auction
// MAGIC • bid - the proxy bid placed by a bidder
// MAGIC • bidtime - the time (in days) that the bid was placed, from the start of the
// MAGIC auction
// MAGIC • bidder - eBay username of the bidder
// MAGIC • bidderrate - eBay feedback rating of the bidder
// MAGIC • openbid - the opening bid set by the seller
// MAGIC • price - the closing price that the item sold for (equivalent to the second
// MAGIC highest bid + an increment)

// COMMAND ----------

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._


// COMMAND ----------

// En premier, on obtient le SQLContext sur la base du SparkContext
val sqlContext = SparkSession
   .builder()
   .enableHiveSupport()
   .getOrCreate()    // conversion RDD vers DataFrame.
    import sqlContext.implicits._

// COMMAND ----------

// chargement du data au niveau du DataFrame
val ebayText = sc.textFile("FileStore/tables/ebay.csv")
    ebayText.first()

// COMMAND ----------

//define the schema using a case class
case class Auction(auctionid: String, bid: Float, bidtime: Float, bidder: String, 
    bidderrate: Integer, openbid: Float, price: Float, item: String, daystolive: Integer)

// COMMAND ----------

// creation RDD d'objets Auction
val ebay = ebayText.map(_.split(",")).map(p => Auction(p(0),p(1).toFloat,p(2).toFloat,p(3),
        p(4).toInt,p(5).toFloat,p(6).toFloat,p(7),p(8).toInt ))

// COMMAND ----------

// convertir ebay RDD en un DataFrame
val auction = ebay.toDF()

// COMMAND ----------

// Afficher 20 lignes de DataFrame
print(auction.show())


// COMMAND ----------

// Retourne le schema de ce DataFrame
auction.printSchema()


// COMMAND ----------

// Combine d'encans se sont produit
auction.select("auctionid").distinct.count

// COMMAND ----------

// Combien de bid par item?
auction.groupBy("auctionid", "item").count.show


// COMMAND ----------

//   min number de bids par item? Moyenne? max?
auction.groupBy("item", "auctionid").count.show


// COMMAND ----------

auction.groupBy("item", "auctionid").count.agg(min("count"), avg("count"),max("count")).show

// COMMAND ----------

// Encan avec prix final > 100
val highprice= auction.filter("price > 100")

// COMMAND ----------

highprice.show()

// COMMAND ----------

// Enregistrer le DataFrame comme table temp
auction.registerTempTable("auction")

// Nombre de bids par auction?
var results = sqlContext.sql(
"SELECT auctionid, item, count(bid) FROM auction GROUP BY auctionid, item"
)
// Afficher le dataframe dans un format tabulaire
results.show()
//autre

// COMMAND ----------

// autre
results = sqlContext.sql(
"SELECT auctionid, MAX(price) FROM auction GROUP BY item,auctionid"
)
results.show() 

// COMMAND ----------


