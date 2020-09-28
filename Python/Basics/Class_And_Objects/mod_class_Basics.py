class Etudiant: # Contructor d'objet de bass
    def __init__(self, nom, prenom, note_finale): # privated method
        self.nom = nom
        self.prenom = prenom
        self.note_finale = note_finale # Just until here, we get the memory address

    def __str__(self):
        return "Nom: {}, prenom: {}, note finale: {}".format(self.nom,
                                                             self.prenom,
                                                             self.note_finale)

    def connecter_zoom(self,msg):
        self.note_finale += 5
        print("Connection comme: "+msg)

    def ecouter(self):
        self.note_finale += 10
        print("Etudiant ecoute")

    def faire_devoir(self):
        self.note_finale += 20
        print("Etudiant fait le devoir")

class Profeseur:
    def __init__(self, nom, prenom, indice_satisfaction):
        self.nom = nom
        self.prenom = prenom
        self.indice_satisfaction = indice_satisfaction

    def __str__(self):
        return "Nom: {}, prenom: {}, indice: {}".format(self.nom,
                                                                    self.prenom,
                                                                    self.indice_satisfaction)

    def connecter_zoom(self,msg):
        print("Connection comme: "+msg)

    def enseigner(self):
        self.indice_satisfaction += 10
        print("Professeur enseigne")

    def donner_devoir(self):
        self.indice_satisfaction += 30
        print("Professeur donne devoir")

# Creation d'objet
prof_1 = Profeseur("ClaireClaire", "Betty",0.0) # instnacier l'objet
etud_1 = Etudiant("Flouflou", "Alain",0.0) # instnacier l'objet
print(prof_1)
print(etud_1)
print("="*50)
prof_1.connecter_zoom("Host")
etud_1.connecter_zoom("Etudiant")
print("Indice de satisfaction du professeur apres se connecter: ", prof_1.indice_satisfaction)
print("Note d'etudiante apres se connecter: ", etud_1.note_finale)
print("-"*50)

prof_1.enseigner()
etud_1.ecouter()
print("Indice de satisfaction du professeur apres d'enseigner: ", prof_1.indice_satisfaction)
print("Note d'etudiante apres d'ecouter: ", etud_1.note_finale)
print("-"*50)

prof_1.donner_devoir()
etud_1.faire_devoir()

print("Indice de satisfaction du professeur apres de donner le devoir: ", prof_1.indice_satisfaction)
print("Note d'etudiante de faire le devoir: ", etud_1.note_finale)

print("="*50)

print(prof_1)
print(etud_1)




