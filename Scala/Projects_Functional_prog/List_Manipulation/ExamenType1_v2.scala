object ExamenType1_v2 extends App {
  var list_1 = List(List("Cours de programmation Java", 40),
                    List("Programmation I",30),
                    List("Programmation II",15),
                    List("Développement Web",55),
                    List("Introduction à Javascript",22),
                    List("Programmation C#",75))

  //1. Combien d'éléments ne contiennent pas le mot "Programmation" ?
  case class Cours(description:String, total:Int)

  val coll = List(Cours("Cours de programmation Java", 40),
    Cours("Programmation I",30),
    Cours("Programmation II",15),
    Cours("Développement Web",55),
    Cours("Introduction à Javascript",22),
    Cours("Programmation C#",75))

  //1. Combien d'éléments ne contiennent pas le mot "Programmation" ?
  var sortie_1 = coll.count(x=> !x.description.toUpperCase().contains("PROGRAMMATION"))
  println(sortie_1)
  println("-"*20)
  //2. Indiquer comment on pourrait faire pour avoir en sortie une
  var sortie_2 = coll.map(x=> x.description.toLowerCase())
  println(sortie_2)
  println("-"*20)

  // Ma solution
  println("MA SOLUTION")
  println("="*50)

  //1. Combien d'éléments ne contiennent pas le mot "Programmation" ?

  var list_2 = list_1.count(x=> !x(0).toString().toUpperCase().contains("PROGRAMMATION"))
  println(s"1. Nombre d'éléments ne contiennent pas le mot Programmation: $list_2")
  println("="*50)

  //2. Indiquer comment on pourrait faire pour avoir en sortie une
  // liste avec tous les éléments en minuscule
  var list_3 = list_1.map(x=> x(0).toString.toLowerCase())
  println("2. List qui a tous les éléments en minuscule: ")
  println(list_3)
  //println("PD. Le nombre d'etudiants ne peut pas etre changee en minuscule. C'est un entiere")

  // Si on besoin la list avec le nombre d'etudiants
  //var list_4 = list_1.map(x=> (x(0).toString.toLowerCase(),x(1)))
  //println(list_4)

  println("="*50)
  //3. Combien d'etudiants il y a dans l'ecole
  var list_5 = list_1.map(x => x(1).toString.toInt).sum
  println(s"Nombre d'etudiants dans l'ecole: $list_5")

}
