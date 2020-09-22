object ExerciseClassObject extends App {
  // classe etudiante
  class Etudiant(val nom:String, var noteFinale:Double){
    override def toString: String = "Nom: "+ nom + ", Note: "+noteFinale

    def connecterZoom(message:String): Unit ={
      println(message + " : Etudiant se connect sur Zoom")
      noteFinale += 15.0
    }

    def ecouter(message:String): Unit ={
      println(message + " : Etudiant Ecout")
      noteFinale += 5.0
    }

    def faireDevoir(message:String)= {
      println(message + ": Etudiant fait son devoir")
      noteFinale += 10.0
    }
  }

  class Professeur(val nom:String, var indiceSatisfaction:Double){
    override def toString: String = "Professeur: "+ nom + ", Indice de Satisfaction: "+indiceSatisfaction

    def connecterZoom(message:String): Unit ={
      println(message + " : Professeur se connect sur Zoom")
    }
    def enseigner(message:String) = {
      println(message + " : Professeur enseigne")
      indiceSatisfaction += 20
    }
    def donnerDevoir(message:String) = {
      println(message + " : Professeur donne Devoir")
      indiceSatisfaction += 30
    }
  }
  // creation objet etudiant
  val objE = new Etudiant("FlouFlou", 0.0)

  // Creation objet Professeur
  val objP = new Professeur("ClaireClaire", 0.0)

  // Afficher l'etat initial d'objet
  println(objE)
  println(objP)

  // Demander execution de method
  objP.connecterZoom("Host")
  objE.connecterZoom("Participant")
  objP.enseigner("Class1")
  objE.ecouter("Classe1")
  objP.donnerDevoir("1")
  objE.faireDevoir("Le temps de ")

  // Afficher l'etat final d'objet
  println(objE)
  println(objP)

}