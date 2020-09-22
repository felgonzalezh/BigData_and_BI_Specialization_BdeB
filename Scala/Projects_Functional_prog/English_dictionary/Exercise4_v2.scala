import scala.collection.mutable.ListBuffer
import scala.io.Source

object Exercise4_v2 extends App{
  // 1. Développer le code nécessaire pour lire le fichier,
  // afficher le temps pris à le lire et le nombre de mot dans le fichier
  def lireFichier(fname:String): Array[String] = {
    val F = Source.fromFile(fname)
    var tab = new Array[String](0)
    for (ligne <- F.getLines()) {
      tab = tab :+ ligne
    }
    tab  //ceci est un return déguisé
  }

  var fichier = lireFichier("english_words.txt")
  println("Nombre de mot dans le fichier: "+ fichier.length)
  println("="*50)
  //2. Afficher tous les mots qui contiennent la chaine "issis"
  var count = fichier.count(x => x.toUpperCase().contains("ISSIS"))
  println(count)
  //3. Recupérer tous les mots qui contiennent la chaine "issis"
  var sortie = ListBuffer[String]()
  //var issis_words = new Array[String](0)
  for (i <- fichier){
    if (i.contains("issis")){
      sortie += i
    }
  }
  var list_sortie = sortie.toList
  println("mots qui contiennent la chaine issis")
  for (x <- list_sortie) println(x)
  print("="*50)

  //issis_words.appended(fichier.map(issis(x => issis(x))))
  //println(issis_words)
  //3. Afficher tous les mots dont la longueur est supérieure ou égale à 18
  var sup17 = new Array[String](0)
  for (i <- fichier){
    if (i.length >= 18){
      sup17 = sup17:+ i
    }
  }
  println("mots dont la longueur est supérieure ou égale à 18")
  for (x <- sup17){
    println(x)
  }
  println("="*50)
  //4. Afficher tous les mots qui ne contiennent pas de voyelles.
  var pas_voyelles = new Array[String](0)
  for (i <- fichier) {
    if (!(i.contains("a") || i.contains("e") || i.contains("i") || i.contains("o") || i.contains("u")))
      pas_voyelles = pas_voyelles :+ i
  }

  println("mots qui ne contiennent pas de voyelles")
  for (x <- pas_voyelles){
    println(x)
  }
  println("="*50)
  //def longeuer: String => Int = (x:String) => x.length

  //def test(func:Int => String, X)

  //def test:Int => "String" = (x:Int) => if (x >= 18) "True" else "False"
  //lireFichier().map(x => if(longeuer(x) >= 18) True else False)



}
