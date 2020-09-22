import scala.math.pow

object Functions_1 extends App{

  def CalculCarre(x:Int):Int = {
    x * x
  }
  def CalculePuissance(base:Double, exp:Double = 2):Double = {
    pow(base,exp)
  }
  // Apel
  var res = CalculCarre(12)
  println("squared: "+res)

  var puissance = CalculePuissance(12, 2)
  println(puissance)
  puissance = CalculePuissance(exp = 3, base = 5)
  println(puissance)
  puissance = CalculePuissance(6)
  println(puissance)
}
