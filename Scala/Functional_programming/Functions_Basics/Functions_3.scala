object Functions_3 extends App{
  val list1 = List(50, 8, 45)
  // method traitement
  def transf: Int => Int = (x:Int) => x*3

  // fonction Higher order
  val resultat = list1.map(x=> transf(x))
  //sortie
  println("List1 ", resultat)

}
