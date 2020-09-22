import scala.io.StdIn.readInt

// Exercise_TEST
// Demander à l’usager une valeur. Si la valeur égale 10, afficher «correct»
// et assigner la valeur à val «statut». Sinon, afficher «incorrect» et assigner
// la valeur -1 à val «statut».

object Test extends App{

  println("Ecrivez un entier des 0 à 20")
  val num = readInt
  println(s"Vous avez saisi: $num")

  val statut = num match { // statut variable is going to take the output values of the test
    case 10 => println("Correct"); num
    case _ => println("Incorrect"); -1
  }
  print(s"Votre statut est: $statut")

  // SAME SOLUTION
  /*
  val statut = 0
  num match { // statut variable is going to take the output values of the test
    case 10 => println("Correct"); statut = num;
    case _ => println("Incorrect"); statut = -1;
  }
  print(s"Votre statut est: $statut")
  */

}
