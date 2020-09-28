class Patient:
    def __init__(self, nom, age, poids, taille):
        self.nom = nom
        self.age = age
        self.poids = poids
        self.taille = taille

    def __str__(self):
        return "nom: {}, age: {}, poids: {}, taille: {}".format(self.nom, self.age,
                                                                self.poids, self.taille)
