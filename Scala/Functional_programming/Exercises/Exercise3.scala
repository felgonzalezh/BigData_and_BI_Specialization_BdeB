object Exercise3 extends App {
  // Soit la collection suivante:
  var list_1 = List("Introduction à la Programmation",
    "Pratique de la Programmation",
    "Structure de données",
    "Principe de la Programmation",
    "Algorithmie",
    "Langages de Programmation")

  //1. Obtenir la collection qui ne contient que les éléments
  // qui contiennent " "  (espace dans le titre)
  var value = list_1.filter(x => x.contains(" "))
  println("List qui ne contient que les éléments qui contiennent une space")
  println(value)
  println("="*50)
  //2. Obtenir la collection qui ne contient que les éléments sans " "  (espace dans le titre)
  value = list_1.filterNot(x => x.contains(" "))
  println("List qui ne contient que les éléments sans espace")
  println(value)

}
