object Exercise1 extends App {
  //1. Développer le code qui effectue la somme des éléments de la liste.
  // On n'utilisera pas d'approche fonctionnelle dans cette partie
  var example = List(15, 39, 22, 98, 37, 19, 5)
  var somme = 0
  for (elem <- example){
    somme += elem
  }

  println("Sum with Loop over the elements: "+ somme)
  print("Sum with sum function: "+ example.sum)
}
