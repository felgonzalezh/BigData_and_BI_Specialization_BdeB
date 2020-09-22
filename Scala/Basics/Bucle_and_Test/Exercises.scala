import scala.io.StdIn.{readDouble, readLine}

object Exercises extends App {
  // Exercises of bucles and tests
  /*
  Exercice 1
  Développer Le code nécessaire pour demander
  à l’usager les trois premières lettres du jour.
  Pour SAM et DIM, afficher en sortie "FIN DE SEMAINE"
  et pour les autres jours, afficher "JOUR DE SEMAINE"
  */
  println("Please write the three first letters of a day (mon, tue, wed, ...)")
  var day = readLine

  var status = day.toLowerCase() match {
    case "sat" => println("Weekend");
    case "sun" => println("Weekend");
    case _ => println("Work day");
  }

  println("="*50)

  /*
  Exercice 2 (Boucle)
  Afficher les numéros de 1 à 100 avec chaque ligne en sortie contenant un groupe de cinq chiffres. Par Exemple:
  1, 2, 3, 4, 5,
  6, 7, 8, 9, 10
  */

  for(i <- 1 to 100){
    if(i % 5 != 0){
      print(i+", ")
    }
    else{
      println(i+", ")
    }
  }

  println("="*50)

  /*
  Exercice 5:  (Boucle et Test)
  Étant donné un montant double, écrivez une expression pour renvoyer
  "plus grand" si c'est plus que zéro, "même" si elle est égale à zéro
  et "moins" si elle est inférieure à zéro.
  */

  println("Write a Double")
  var num = readDouble

  if (num > 0){ println("plus grand") }
  else if (num == 0){ println("meme") }
  else{ println("moins") }




}
