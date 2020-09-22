import ExerciseClassObject.objE

object Exercises extends App {
/*
  Exercice 1
  Développer une classe Etudiant qui permet d'obtenir des instances avec les attributs nom(String)
  et noteFinale (Double). Les valeurs devront être immuables.
    Procéder à la création de l'objet objE (flouflou et 98 comme valeurs des attributs)
  Afficher l'état de l'objet
  */
class Student_e1(val name:String, val finalnote:Double){
  override def toString: String = "Student Name: "+ name + ", Note: "+ finalnote
}

  var objE = new Student_e1("Paula",99)
  println(objE)

  println("="*50)
 /*
  Exercice 2
  Reprendre le modèle de l'exercice 1 et ajouter un attribut supplémentaire
  id qui ne sera pas fixé par le constructeur primaire.
  Modifier la déclaration de l'attribut afin qu'il soit private
*/
 class Student_e2(val name:String, val finalnote:Double, private val id:Int = 1){
   override def toString: String = "Student id " + id + " Name: "+ name + ", Note: "+ finalnote
 }

  var objE_2 = new Student_e2("Nohra",91)
  println(objE_2)

  println("="*50)
   /*
  Exercice 3
  Modifier la classe pour que l'on soit capable d'afficher l'état de l'objet
*/
   class Student_e3(val name:String, val finalnote:Double, private val id:Int = 1){
     override def toString: String = "Student id " + id + " Name: "+ name + ", Note: "+ finalnote
     println(s"Student id: $id, name: $name, note: $finalnote")
   }

  var objE_3 = new Student_e3("FlouFlou",98)

  println("="*50)

  /*
  Exercice 4
  Un objet de type Etudiant a besoin de faire ses devoirs. Pour cela,
  on va lui ajouter une méthode faireDevoir( ) qui prend une chaine de
  caractères comme paramètre et affiche le message correspondant.

*/
  class Student_e4(val name:String, val finalnote:Double, private val id:Int = 1){
    override def toString: String = "Student id " + id + " Name: "+ name + ", Note: "+ finalnote
    println(s"Student id: $id, name: $name, note: $finalnote")

    def faire_devoir(message:String):Unit = {
      println(message)
    }
  }

  var objE_4 = new Student_e4("Ricardo",50)
  objE_4.faire_devoir("Il doit faire le devoir")
}
