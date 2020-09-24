import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader
import scala.collection.mutable.ListBuffer
import scala.io.Source

object ExamenType2_v2 extends App {
  //Soit le fichier des clients suivants:
  /*
  10, Jean Treman, Montreal, QC, H1H 8J9
  20, Jolie Josten, Joliette, QC, J7G 0K7
  30, Bib Jober, Repentigny, QC, J6T 7G6
  40, Anton Dasro, Mascouche, QC, J3F 6R4
  50, Jamier Winston, Montreal, QC, H1H 8J9
  */
  // Le fichier existe deja:
  // "/home/felipe/Desktop/BoisDeBologne/BD_3_Hadoop/scala_exercise/clients.txt"

  //1. Créer une classe pour représenter un Client. On devra très probablement utiliser une case class.
  def lireFichier(fname:String):Array[String] = {
    val File = Source.fromFile(fname)
    var tab = Array[String]()
    for(ligne <- File.getLines()){
      tab = tab :+ ligne
    }
    tab
  }

  val fichier = lireFichier("clients.txt")

  case class Client(id:Int, Nom:String, Ville:String, Province:String, CodePostal:String)

  def parseLine(line:String):Client = {
    var client_tmp = line.split(",")
    var id = client_tmp(0).toInt
    var nom = client_tmp(1)
    var ville = client_tmp(2)
    var prov = client_tmp(3)
    var pc = client_tmp(4)
    Client(id,nom,  ville, prov, pc)
  }

  //2. Afficher tous les Clients.
  val clients_list = fichier.map(parseLine(_))
  clients_list.map(println)
  println("="*50)

  //3. Procéder à un SELECT de la colonne –nom- seulement
  var noms = clients_list.map(_.Nom)
  noms.map(println)
  println("="*50)

  //4. Procéder à un SELECT des colonnes –nom- et -ville-
  var noms_villes = clients_list.map(x => x.Nom.concat(x.Ville))
  noms_villes.map(println)
  println("="*50)

    //5. Afficher le détail du client ayant un ID 30
  var client30 = clients_list.filter(_.id == 30)
  client30.map(println)



}
