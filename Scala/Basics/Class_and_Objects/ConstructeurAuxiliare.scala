object ConstructeurAuxiliare extends App {

  class Livre(var titre: String, val num: Int, remarque: String) { // main constructor
    override def toString: String = titre + ", " + num + ", " + remarque // redefinir la signature standard
    def desc = titre + ", taille:"+num+", Remarque générale: " + remarque

    def this(titre: String) = { // Auxiliar constructor.
      this(titre, titre.size, "Porte sur '%s'".format(titre)) // It calls the main constructor,
      // including the required attributs.
    }
  }

  val livre = new Livre("Scala pour les intelligents")
  println(livre.desc)

  var livre2 = new Livre("Scala", 345, "Bien")
  println(livre2.desc)
}
