object Exercise2 extends App{
  //On veut parcourir une collection afin de déterminer quelques propriétés telles que:
  // Est ce que la collection contient un élément avec une certaine propriété?
  // Est-ce que tous les éléments ont cette propriété?
  // Combien d'éléments ont cette propriété?
  var registre = List("Introduction à la Programmation",
    "Pratique de la Programmation",
    "Structure de données",
    "Principe de la Programmation",
    "Algorithmie",
    "Langages de Programmation")

  //Combien d'éléments contiennent le mot "Programmation"
  var counterProg = 0
  var counterNonProg = 0
  for(elem <- registre){
    if(elem.toUpperCase().contains("PROGRAMMATION")){
      counterProg += 1
    }else{
      counterNonProg += 1
    }
  }
  println("Il y a "+ counterProg + " elements qui contiennent le mot Programmation")

  // Combien d'éléments ne contiennent pas le mot "Programmation"
  println("Il y a "+ counterNonProg + " elements qui ne contiennent pas le mot Programmation")

  // Déterminer si la lettre o (maj ou min) est présente dans tous les éléments de la collection
  for (elem <- registre) {
    if (elem.contains("o") || elem.contains("O")) {
      println("L'element " + registre.indexOf(elem) + " cointien la lettre o")
    }
  }
}
