import scala.io.Source

object Exercise4 extends App {

  // 1. Développer le code nécessaire pour lire le fichier,
  // afficher le temps pris à le lire et le nombre de mot dans le fichier
  def lireFichier(): Array[String] = {
    val fname = "english_words.txt"
    val F = Source.fromFile(fname)
    var tab = new Array[String](0)
    for (ligne <- F.getLines()) {
      tab = tab :+ ligne
    }
    tab  //ceci est un return déguisé
  }

  println("Nombre de mot dans le fichier: "+ lireFichier().length)

  //2. Afficher tous les mots qui contiennent la chaine "issis"
  // faire une collection et le afficher
  var issis_words = new Array[String](0)
  for (i <- lireFichier()){
    if (i.contains("issis")){
      issis_words = issis_words:+ i
    }
  }
  for (i <- issis_words){
    println(i)
  }


}
