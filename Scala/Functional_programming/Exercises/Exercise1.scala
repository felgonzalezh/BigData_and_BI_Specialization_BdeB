object Exercise1 extends App{

// Soit la liste suivante:
  var list = List(15, 39, 22, 98, 37, 19, 5)

  //1. Développer le code qui effectue la somme des éléments de la liste.
  // On n'utilisera pas d'approche fonctionnelle dans cette partie.
  var sum = 0
  for(i <- list){
    sum += i
  }
  println(s"la somme des éléments de la liste est: $sum")
  println("-"*50)
  //2. Développer une approche fonctionnelle qui permet d'obtenir le même résultat.
  var sum_fon = list.sum
  println(s"la somme fonctionelle des éléments de la liste est: $sum_fon")

}
