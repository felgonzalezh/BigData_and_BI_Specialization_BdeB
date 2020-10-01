# Classes du projet:
class Article:
    def __init__(self, description, quantite, prix):
        self.description = description
        self.prix = prix
        self.quantite = quantite
    def __str__(self):
        return "Description: {}, Quantite: {}, Prix: {}".format(self.description,
                                                                self.quantite,
                                                                self.prix,)

class Registre_Article:
    def __init__(self):
        self.registre = []

    def ajouter_article(self, art):
        self.registre.append(art)
        #return self.registre

    def afficher_article(self):
        for elem in self.registre:
            print(elem)

    def retirer_article(self,art):
        self.registre.append(art)



