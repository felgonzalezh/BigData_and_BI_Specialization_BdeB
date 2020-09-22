import scala.io.StdIn.{readDouble, readLine}
// Basics on Scala
object Bienvenu extends App {
  // variable mutable
  var salaire = 453.52
  println(salaire)
  salaire = 1000
  println(salaire)

  // variable declarations
  var x,y = 10
  var python, java = false
  println(x,y,python,java)

  // funtion definition and use
  def min(a:Int, b:Int):Int = {
    if(a < b)
      a // return a... return is not neccesary
    else
      b // return is not neccesary
  }
  // apple dune fonction
  var resultat = min(4,15)
  println(s"the minimum is $resultat")

  val multi = "="*50 // consntant
  println(multi)

  val integ = "12345"
  val toto = integ.toInt
  println(s"map to int: $toto")
  // Writing (Scanner du JAVA ou readline ou readInt)
  println("SVP Votre nom")
  val nom = readLine()
  println("Hi "+nom)
  println("SVP votre salaire:")
  salaire = readDouble()
  salaire += 1000
  println("votre salaire augmente: " + salaire)

  // "void" function definition
  def employee(nom:String, s:Double):Unit = {
   return println("Nom " + nom+ " Salaire "+ salaire.toString)
  }

  // function call
  employee(nom,salaire)

}

