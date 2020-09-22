object Lists extends App {
  val registre = List("a","b","c")
  // indexation
  println(registre(1))
  // slicing ...
  println(registre.slice(1,4)) // it works since there is no third element. It wont work on Python
  // Parcours d'une list
  for (elem <- registre){
    println(elem)
  }
  // Methods de List
  var res = registre.reverse
  println(res)

  val nom = List("Flouflou","Flouclaire","Claireclaire")
  res = nom.sorted
  println(res)
}
