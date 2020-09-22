object Exercise1 extends App{

  //1. Soit la liste suivante:  List(15, 39, 22, 98, 37, 19, 5)
  //  1. Développer le code qui effectue la somme des éléments de la liste. On n'utilisera pas d'approche fonctionnelle dans cette partie.
  var list1 = List(15, 39, 22, 98, 37, 19, 5)
  var sum = 0
  for(elem <- list1){
    sum += elem
  }
  println(s"Summe est: $sum")
  println("="*50)
  //  2. Développer une approche fonctionnelle qui permet d'obtenir le même résultat
  var summe1 = 0
  list1.foreach(elem => summe1 += elem)
  println(s"Summe fonctionelle 1 est: $summe1")
  println("="*50)

  var summe2 = 0
  list1.foreach(summe2 += _)
  println(s"Summe fonctionelle 2 est: $summe2")
  println("="*50)


}
