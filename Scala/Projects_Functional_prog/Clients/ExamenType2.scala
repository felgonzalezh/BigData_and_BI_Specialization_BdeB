import scala.collection.mutable.ListBuffer
import scala.io.Source

object ExamenType2 extends App {

  def lireFichierNew(fname:String): Array[String] = {
    val File = Source.fromFile(fname)
    var tab = new Array[String](0)
    for (ligne <- File.getLines()){
      tab = tab :+ ligne
    }
    tab
  }

  var fichier = lireFichierNew("clients.txt")

  //  1. Créer une classe pour représenter un Client. On devra
  //  très probablement utiliser une case class.
  case class client(id:Int, Nom:String, Ville:String, Province:String, CP:String)

  //  2. Afficher tous les Clients.
  fichier.foreach(println)

  // 3. Procéder à un SELECT de la colonne –nom- seulement
  def parseLigne(i: String):client = {
    val token = i.split(",")
    val id:Int = token(0).toInt
    val Nom:String = token(1)
    val Ville:String = token(2)
    val Province:String = token(3)
    val CP:String = token(4)
    client(id, Nom, Ville, Province, CP)
  }

 val list_client = new ListBuffer[client]()
  for (i <- fichier){
    list_client += parseLigne(i)
  }

  list_client.foreach(x=>println(x.Nom))
  println("="*50)
  //4. Procéder à un SELECT des colonnes –nom- et -ville-

  list_client.foreach(x=>println(x.Nom.concat(x.Ville)))
  println("="*50)

  //5. Afficher le détail du client ayant un ID 30
  println(list_client.filter(x => x.id == 30))
  list_client.foreach(x => if(x.id == 30 ) println(x))
}
