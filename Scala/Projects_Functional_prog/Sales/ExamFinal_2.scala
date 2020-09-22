object ExamFinal_2 extends App {
  // On considère la collection de produits suivante:

  // Sachant que l’on peut modéliser les produits par une classe Produit
  // (code, description, prix), développer une approche Scala afin:

  // a. Procéder à l'instantiation des objets produit et ajouter dans la collection
  case class Produit(code:String, description:String, prix:Double)

  val list_produits = List(
    Produit("Bnb11", "Bonbon", 0.5),
    Produit("Pai22", "Pain", 1.75),
    Produit("Stl45", "Vis", 1.5),
    Produit("Tv78", "Television", 700.77),
    Produit("Tbl97", "Table", 200),
    Produit("Frc12", "Fourchette", 2.0 )
  )

  // b. Trouver tous les produits qui ont le prix compris entre 0$ et 234$.
  println("Produits qui ont le prix compris entre 0$ et 234$:")
  var sortieb = list_produits.filter(x => 0 <= x.prix && x.prix <= 234)
  sortieb.foreach(println)
  println("="*50)

  // c. Trouver tous les produits dont la description contient
  // la chaine "vis"  (majuscule ou minuscule)
  println("Produits dont la description contient la chaine vis:")
  var sortiec = list_produits.filter(x => x.description.toUpperCase.contains("VIS"))
  sortiec.foreach(println)

}
