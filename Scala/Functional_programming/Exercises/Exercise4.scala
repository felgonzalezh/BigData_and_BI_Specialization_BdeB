import scala.io.Source
import scala.compat.Platform.currentTime

object Exercise4 extends App {
  //On va prendre le fichier english_words qui se trouve sur le R.

  //1. Développer le code nécessaire pour lire le fichier,
  // afficher le temps pris à le lire et le nombre de mot dans le fichier
  def lireFichier(fname: String): Array[String] = {
    val File = Source.fromFile(fname)
    var tab = new Array[String](0)
    for (ligne <- File.getLines()){
      tab = tab :+ ligne
    }
    tab
  }

  var before = currentTime
  val fichier = lireFichier("/home/felipe/Desktop/BoisDeBologne/BD_3_Hadoop/scala_exercise/english_words.txt")
  var after = currentTime
  println(after - before + " est le temps pris à le lire")
  println("-"*50)
  var n_mots = fichier.length
  println(s"le nombre de mot dans le fichier: $n_mots")
  println("="*50)

  //2. Afficher tous les mots qui contiennent la chaine "issis"
  var list_2 = fichier.filter(x => x.contains("issis"))
  for( i <- list_2) println(i)
  println("="*50)

  //3. Afficher tous les mots dont la longueur est supérieur ou égale à 18
  var list_3 = fichier.filter(x => x.length >= 18)
  for (i <- list_3) println(i)
  println("="*50)

  //4. Afficher tous les mots qui ne contiennent pas de voyelles.
  var list_4 = fichier.filterNot(x => (x.contains("a") || x.contains("e") ||
                                       x.contains("i") || x.contains("o") ||
                                       x.contains("u") || x.contains("y")))

  for (i <- list_4) println(i)
  println("="*50)

}
