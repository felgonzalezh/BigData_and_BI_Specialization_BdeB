// Ecrire une expression pour afficher les nombres de 1 à 100, sauf que
// pour les multiples de 3, imprimez «type», et pour les multiples de 5, imprimez «safe».
// Pour les multiples de 3 et de 5, afficher "typesafe".

object Bucle extends App {

   for(i <- 1 to 100){
     if ( i % 15 == 0) println(s"$i typesafe")
     else if ( i % 3 == 0) println(s"$i type")
     else if ( i % 5 == 0) println(s"$i safe")
     else println(i)
  }

}

