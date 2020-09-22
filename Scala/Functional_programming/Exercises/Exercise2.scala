object Exercise2 extends App {
  // Soit la collection suivante:
  var list_1 = List("Introduction à la Programmation",
                    "Pratique de la Programmation",
                    "Structure de données",
                    "Principe de la Programmation",
                    "Algorithmie",
                    "Langages de Programmation")

  //1. Combien d'éléments contiennent le mot "Programmation"
  var counter = 0
  for(i <- list_1){
    if(i.toUpperCase.contains("PROGRAMMATION")) {
      counter += 1
    }
  }
  println(s"Nombre d'éléments contiennent le mot Programmation: $counter")
  var counter_fonc = list_1.count(x => x.toUpperCase.contains("PROGRAMMATION"))
  println(s"(Fonctionnelle) Nombre d'éléments contiennent le mot Programmation: $counter_fonc")
  println("="*50)

  //2. Combien d'éléments ne contiennent pas le mot "Programmation"
  counter_fonc = list_1.count(x => !x.toUpperCase.contains("PROGRAMMATION"))
  println(s"(Fonctionnelle) Nombre d'éléments ne contiennent pas le mot Programmation: $counter_fonc")
  println("="*50)

  //3. Déterminer s'il  y'a au moins un élément qui ne contient pas le mot "Programmation"
  var flag = false
  for(i <- list_1 if !flag){
    if(!i.toUpperCase.contains("PROGRAMMATION")) flag = true;
  }
  if(flag) println("il  y'a au moins un élément qui ne contient pas le mot Programmation")
  else println("il n'y en a pas")
  println("="*50)

  //4. Déterminer si la lettre o (maj ou min) est présente dans tous les éléments de la collection
  counter = 0
  counter = list_1.count(x => x.toUpperCase.contains("O"))
  if(counter == list_1.length) println("la lettre o est présente dans tous les éléments de la collection")
  println("="*50)

  //5. Déterminer s'il y'a au moins un élément qui contient le mot "Programmation"
  counter = 0
  flag =false
  for (i <- list_1 if !flag){
   if(i.toUpperCase.contains("PROGRAMMATION")) flag = true
  }
  if(flag) println("il y'a au moins un élément qui contient le mot Programmation")
}
