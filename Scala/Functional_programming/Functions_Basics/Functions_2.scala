import scala.io.StdIn.readInt

object Functions_2 extends App {
// creation de fontion anonymes avec parametre
  var fonc1 =  (a:String, b:String) => a + b
  //creation avec wildcare
  var fonc2 = (_:String) + (_:String)
  // Appel de la fonction
  var resultat = fonc1("Bienvenue: ","Monde")
  println(resultat)
  var resultat2 = fonc2("Au revoir: ","Monde")
  println(resultat2)

  // creation de fonction sans parametre
  var fonc3 = () => "Bienvenue monde Neo"
  var resultat3 = fonc3()
  println(resultat3)

  // Fonction Higher order
  println(traitement(calcul,32))
  // HO: traitement
  // literal: calcul
  // la signature du calcul. Recu un Double et la sortie est Double
  def traitement(funi:Double => Double, y:Double) = {
    funi(y)
  }
// fonction de bas niveau
  def calcul(inp: Double) :Double ={
    inp * 5
  }
  // modifie de telle facon que traitement nous dise si le resultat de funi est pair ou impair
  // la valuer sera cessie au depart

  // Fonction Higher order
  println("Saisir un valeur")
  val valeur = readInt
  println(traitement2(calcul,valeur,pairfonc))
  def traitement2(funi: Double => Double, y: Double, fonc: Double => String) = {
    funi(y)
    fonc(y)
  }
  def pairfonc(x:Double) : String = {
    if (x % 2 == 0)
      "C'est pair"
    else
      "Ce n'est pas pair"
  }
  def impairfonc(x:Double) : String = {
    if (x % 2 != 0)
      "C'est impair"
    else
      "Ce n'est pas impair"
  }
  def sup(x:Double) : String = {
    if (x > 5)
      "Sup a 5"
    else
      "Inferieur a 5"
  }
  // Simplification

}
