import scala.io.StdIn.{readDouble, readLine}
import scala.util.{Failure, Success}

object ExamFinal_1 extends App {

  def saisirValeur(msg: String): Double = {
    println(msg)
    readDouble()
  }

  def saisirString(msg: String): String = {
    println(msg)
    readLine()
  }

  case class contribuable(Nom:String,Prenom:String,Revenutotal:Double,Retrait:Double)

  var nom = saisirString("Ecrivez votre Nom")
  var prenom = saisirString("Ecrivez votre Prenom")
  var revenuetotal = saisirValeur("Ecrivez votre Revenu total")
  var retrait_saisi = saisirString("Ecrivez votre Retrait a la source (Optionnel)")
  var retrait = 0.0
  try {
    retrait = retrait_saisi.toDouble
  } catch {
    case e: Exception => retrait = 0.0
  }

  //var contri1 = contribuable("FlouFlou","Alan",30000,12000) // Testing values
  var contri = contribuable(nom,prenom,revenuetotal,retrait)
  println("="*70)

  def impot(contri:contribuable):Double ={
    var RevenuReel = (contri.Revenutotal*0.85)-contri.Retrait
    var taux_impot = if(RevenuReel < 10000) 0.15
    else if(RevenuReel < 30000) 0.25
    else if(RevenuReel < 100000) 0.35
    else 0.55
    var impot = taux_impot * RevenuReel
    impot
  }

  def msg(impot_foc:contribuable => Double, contri:contribuable): Unit ={
    println(s"Mr ${contri.Nom}, ${contri.Prenom}")
    println("Merci d'avoir rempli votre declaration fiscale.")
    println("Voici les montants qui vous concernent")
    println(s"Montant declare: ${contri.Revenutotal}")
    println(s"Montant retrait a la source declare: ${contri.Retrait}")
    println(s"Montant a payer: ${impot_foc(contri)}")
  }
  msg(impot,contri)

}
