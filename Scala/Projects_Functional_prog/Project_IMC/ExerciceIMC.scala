import scala.None.nonEmpty
import scala.io.StdIn.readDouble

object ExerciceIMC extends App{
  println("Cete programme calcule votre IBM (Index de masse corporel)")
  // This program calculates your IMC according to your weight and your height.

  // Valuers sont pris de
  // http://www.hc-sc.gc.ca/fn-an/nutrition/weights-poids/guide-ld-adult/bmi_chart_java-graph_imc_java-fra.php,
  var IMC = Array(18.5,25,30,35,40)
  var Risque = Array("Accru","Moindre","Accru","Élevé","Très élevé","Extrêmement élevé")
  var Classification = Array("Poids insuffisant","Poids normal","Excès de poids",
    "Obésité, classe I","Obésité, classe II","Obésité, classe III")

  // Function Declarations
  def IMC_Calcule(poids:Double, taille:Double): Double = {
    poids / (taille*taille)
  }
  def afficherRisqueClassification(imc_class:Int):Unit = {
    println("Risque: " + Risque(imc_class) + ", Classification: " + Classification(imc_class))
  }
  def saisirValeur(msg:String):Double ={
    println(msg)
    readDouble()
  }

// Input values
  var poids = saisirValeur("Ecrivez votre poids (kg)")
  var taille = saisirValeur("Ecrivez votre taille (m)")

  var imc_value = IMC_Calcule(poids,taille)
  println("Votre IBM est ", imc_value)

  var imc_class = 0
  if (imc_value < IMC(0)) imc_class = 0
  else if (imc_value < IMC(1)) imc_class = 1
  else if (imc_value < IMC(2)) imc_class = 2
  else if (imc_value < IMC(3)) imc_class = 3
  else if (imc_value < IMC(4)) imc_class = 4
  else imc_class = 5

  afficherRisqueClassification(imc_class)

}


