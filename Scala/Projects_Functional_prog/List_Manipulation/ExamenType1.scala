object ExamenType1 extends App {
//  Soit les cours suivants (description et nombre d’étudiants) :

  case class Cours(cours:String, nombre:Int)

  var list_1 = List(Cours("Cours de programmation Java", 40),
                  Cours("Programmation I",30),
                  Cours("Programmation II",15),
                  Cours("Développement Web",55),
                  Cours("Introduction à Javascript",22),
                  Cours("Programmation C#",75))

  //1. Combien d'éléments ne contiennent pas le mot "Programmation" ?
  var counter = list_1.count(x => !x.cours.toUpperCase.contains("PROGRAMMATION"))
  println(s"Nombre d'éléments ne contiennent pas le mot Programmation: $counter")
  println("="*50)

  //2. Indiquer comment on pourrait faire pour avoir en sortie une liste avec
  // tous les éléments en minuscule
  var sortie2 = list_1.map(x => x.cours.toLowerCase)
  println(sortie2)

}
