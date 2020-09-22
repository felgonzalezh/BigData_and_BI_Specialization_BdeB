object Exercise5 extends App {
  // Soit la collection suivante:
  var list_1 = List("Introduction à la Programmation",
    "Pratique de la Programmation",
    "Structure de données",
    "Principe de la Programmation",
    "Algorithmie",
    "Langages de Programmation")

  //1. Obtenir la collection transformée qui contient la longueur
  // de chacun des éléments  de la collection d'origine
  var sortie1 = list_1.map(x => x.length)
  println(sortie1)
  println("="*50)

  //2. Obtenir la collection transformée qui contient les éléments
  // en majuscule de chaque élément de la collection d'origine
  var sortie2 = list_1.map(x => x.toUpperCase)
  print(sortie2)
  println("="*50)

  //3. Obtenir la collection transformée qui a chaque élément préfixé
  // par le mot "Livre:" au début de chaque élément de la collection d'origine
  var sortie3 = list_1.map(x => "Livre:"+x)
  println(sortie3)

}
