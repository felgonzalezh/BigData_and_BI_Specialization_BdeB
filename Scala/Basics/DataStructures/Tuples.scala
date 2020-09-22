object Tuples extends App {
  var tuplo = (45,25.0,"toto")
  println(tuplo)
  // indexation
  println(tuplo._1)
  // affectation multiple
  var (x,y,z,python,java) = (1,2,3,false, "bon")
  println(x,y,z,python,java)
}
