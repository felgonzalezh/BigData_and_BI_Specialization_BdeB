import scala.util.control.Breaks.{break, breakable}

object Exercise2 extends App {
  // On veut parcourir une collection afin de déterminer quelques propriétés  telles que:
  // • Est ce que la collection contient un  élément avec une certaine propriété?
  // • Est ce que tous les elements ont cette propriété?
  // • Combien d'éléments ont cette propriété?
  // Sol: Higher-order methodes exists, forall, et count.
  // Ces méthodes demandent des fonction objet qui maps les éléments vers Boolean.
  // Soit la collection suivante:

   var list2 = List("Introduction à la Programmation",  "Pratique de la Programmation",
     "Structure de données", "Principe de la Programmation", "Algorithmie", "Langages de Programmation")

  var counterProg = 0
  for(elem <- list2){
    if(elem.toUpperCase().contains("PROGRAMMATION")){
      counterProg += 1
    }
  }
  println(s"Summe est: $counterProg")
  println("="*50)
  // Combien d'éléments contiennent le mot "Programmation"
  var sum = 0
  //list2.foreach(elem => if(elem.toUpperCase().contains("PROGRAMMATION")) sum += 1)
  list2.foreach(elem => if(elem.toUpperCase().contains("PROGRAMMATION")) sum += 1)
  println(s"Summe fonctionnelle est: $sum")
  println("="*50)

  var sum2 = list2.count(elem => elem.toUpperCase().contains("PROGRAMMATION"))
  var sum3 = list2.count(_.toUpperCase().contains("PROGRAMMATION")) // Best answer
  println(s"Summe2 fonctionnelle est: $sum3")

  // determiner si le longeuer de la string est pair ou impair
  def longeuer: String => String = (x:String) => if(x.length % 2 == 0) "pair" else "impair"
  val resultat1 = list2.map(x=> longeuer(x))
  println("Resultat ", resultat1)

  // Combien d'éléments contiennent le mot "Programmation"
  //def lettre: (String,String) => String = (x:String, y:String) => if(x.toUpperCase().contains(y)) "True" else "False"
  //var sol_1 = list2.(x => lettre(x,"PROGRAMMATION"))
  //println("1 ", sol_1)

  // 2. Combien d'éléments ne contiennent pas le mot "Programmation"
  println("="*50)
  var conteur = 0
  for (i <- list2){
    if(!i.toUpperCase.matches(".*PROGRAMMATION*."))
      conteur += 1
  }
  var sol_2 = list2.count(elem => !elem.toUpperCase().contains("PROGRAMMATION"))
  println(s"éléments ne contiennent pas le mot Programmation: $conteur")
  println(s"Fonctionnelle: éléments ne contiennent pas le mot Programmation: $sol_2")
  println("="*50)

  //3. Déterminer s'il  y'a au moins un élément qui ne contient pas le mot "Programmation"
  var conteur3 = 0
  breakable{
    for (i <- list2){
      if(!i.toUpperCase.matches(".*PROGRAMMATION*.")) {
        conteur3 += 1
        break()
      }
    }
  }
 var conteur3a = 0
  var flag = false
  for (i <- list2 if !flag){
    conteur3a += 1
    if(!i.toUpperCase.matches(".*PROGRAMMATION*.")) {
      println(s"Element san programmation: $conteur3a")
      flag = true
    }
  }

  println(s"il  y'a au moins $conteur3 élément qui ne contient pas le mot Programmation")
  println("="*50)
  //4. Déterminer si la lettre o (maj ou min) est présente dans tous les éléments de la collection
  var conteur4 = 0
  flag = false
  for (i <- list2 if !flag){
    conteur4 += 1
    if(!i.toUpperCase.matches(".*O*.")) {
      println(s"Au moins un éléments ne contient pas la lettre O. Element: $conteur4")
      flag = true
    }
  }


    println("="*50)
     //var sol_4 = list2.map(x => lettre(x,"o"))
   //println("Elements qui contiennet la lettre o",sol_4)
  //5. Déterminer s'il y'a au moins un élément qui contient le mot "Programmation"
  var conteur5 = 0
  breakable{
    for (i <- list2) {
      if (!i.toUpperCase.matches(".*PROGRAMMATION*.")) {
        conteur5 += 1
        break
      }
    }
  }
  var conteur5a = 0
  flag = false
  for (i <- list2 if !flag){
    conteur5a += 1
    if(i.toUpperCase.matches(".*PROGRAMMATION*.")) {
      println(s"Element avec programmation: $conteur5a")
      flag = true
    }
  }
  println(s"il  y'a au moins $conteur5 élément qui contient le mot Programmation")

}
