// Databricks notebook source
// MAGIC %md 
// MAGIC # Serie d'exercises 

// COMMAND ----------

// MAGIC %md 
// MAGIC #### Exercise 1: 
// MAGIC     1. Créer une séquence de nombre entre 0 et 10 000 inclus. 
// MAGIC     2. Placer cette sequence de nombre dans un RDD appelé sparkRDD.
// MAGIC     3. En utilisant une fonction de filtrage et comptage, trouver le nombre de valeurs qui sont inférieures ou égales à 20.

// COMMAND ----------

val sparkRDD = sc.parallelize(0 to 10000) //creates RDD

// COMMAND ----------

val resultat = sparkRDD.filter(_ <= 20).count() // filter return une bollean

// COMMAND ----------

// MAGIC %md
// MAGIC #### Exercise 2
// MAGIC 
// MAGIC Reprendre l'exercice 1 mais cette fois-ci on fera en sorte de générer des nombres aléatoires. On utilisera une fonction map pour obtenir les valeurs aléatoires. Déterminer combien de valeurs sont inférieures à 0.51

// COMMAND ----------

import scala.util.Random

// COMMAND ----------

// mon solution
val aleatoireRDD = sparkRDD.map(x => Random.nextFloat()) // Random.nextFloat() returns a random value between 0 and 1
val resultat2 = aleatoireRDD.filter(_ < 0.51).count()
// since sparkRDD is a RDD, this piece of code generates pararellaly the random number 

// COMMAND ----------

// solution prof
val generateur = new Random(100) // seed = 100
val t = for (i <- 0 to 10000) yield generateur.nextDouble() // yield creates the random value for each iteration. nextFloat same as nextfloat
// here, we got a list of random numbers and then we create the RDD

// COMMAND ----------

// Obtenir le RDD
val t_sparkRDD = sc.parallelize(t) //create the RDD
val resultat2_prof = t_sparkRDD.filter(_ < 0.51).count()

// COMMAND ----------

// MAGIC %md 
// MAGIC 
// MAGIC #### Exercice 3
// MAGIC     1. Effectuer les transformations suivantes sur le  liste   [1,2,3,4]
// MAGIC         a. Transformer la liste en RDD
// MAGIC         b. Faire en sorte d'obtenir un RDD transformé de telle sorte que les éléments en sortie soient le carré des éléments en entrée
// MAGIC         c. Faire en sorte que les éléments en sortie de l'étape 2 soient que les éléments pairs.
// MAGIC         d. Effectuer une collecte des éléments pairs afin de pouvoir afficher ces nombres

// COMMAND ----------

// a
val list = List(1,2,3,4)
val listRDD = sc.parallelize(list)

// COMMAND ----------

// b
// transformation suivi d'une action
val resultat_3b = listRDD.map(x => x*x).collect()

// COMMAND ----------

val resultat_3b = listRDD.map(Math.pow(_,2)).collect()

// COMMAND ----------

// c
// utilisation d;une pileline
// RDD --> carre --> Pairs ---> action collect
val resultat_3c = listRDD.map(Math.pow(_,2)).filter(_ % 2 == 0).collect()

// COMMAND ----------

// MAGIC %md 
// MAGIC #### Exercise 4
// MAGIC On reprend la liste de l'exercice 3. On veut réaliser les actions suivantes:
// MAGIC 
// MAGIC     a. Comment pouvez-vous récupérez les 2 premiers enregistrements?
// MAGIC     b. Combien d'éléments y'a-t-il ? 
// MAGIC     c. Quelle est la somme de tous les éléments dans la liste?
// MAGIC     d. Effectuer la sauvegarde du RDD comme fichier texte. Vérifier au niveau de l'interface Hue. (pas possible)

// COMMAND ----------

val list = List(1,2,3,4)
val listRDD = sc.parallelize(list)

// COMMAND ----------

// a
val sortie = listRDD.take(2)

// COMMAND ----------

// b
val size_list = listRDD.count()

// COMMAND ----------

// c
val resultat_4c = listRDD.sum

// COMMAND ----------

val resultat_4c_2 = listRDD.reduce((a,b) => a + b)

// COMMAND ----------

// d
listRDD.saveAsTextFile("/FolderStore/tables/wc/sortie_serie_spark_intro1")

// COMMAND ----------

dbutils.fs.head("/FolderStore/tables/wc/sortie_serie_spark_intro1/part-00007")

// COMMAND ----------

// MAGIC %md
// MAGIC #### Exercice 5
// MAGIC     Soit la liste de tuples suivante [("orange", 1) , ("pomme", 3), ("poire", 1), ("banane", 4), ("orange", 4)]
// MAGIC     a. Obtenir le RDD correspondant
// MAGIC 
// MAGIC     b. Effectuer une réduction par clé (reduceByKey) en utilisant la fonction lambda suivante: lambda a,b: a+b
// MAGIC 
// MAGIC     c. Effectuer un groupage par key (groupByKey)

// COMMAND ----------

val listing = List( ("orange",1), ("pomme", 3), ("poire", 1), ("banane", 4), ("orange", 4))

// COMMAND ----------

// a
val listingRDD = sc.parallelize(listing)

// COMMAND ----------

// b
val resultst_5b = listingRDD.reduceByKey((a, b) => a+b).collect() // aggregation

// COMMAND ----------

// c
val resultst_5c = listingRDD.groupByKey().collect() //groupage

// COMMAND ----------


