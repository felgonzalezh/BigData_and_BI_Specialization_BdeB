#     1. Développer la classe qui modélise les voitures dans le modèle de l'exercice 1.
import json

class Voiture:
    def __init__(self, marque, modele, transmission, couleur, porte=4, accesoires = {}):
        self.marque = marque
        self.modele = modele
        self.transmission = transmission
        self.couleur = couleur
        self.porte = porte
        self.accesoires = accesoires

if __name__ == '__main__':
    #     2. Créer une instance de cette classe

    ma_voiture = Voiture(marque="Nissan", modele="Versa", transmission="Automatique",
                         couleur="verte", accesoires={"toit_ouvrant":True})

    #     3. On passe maintenant à la sauvegarde du contenu de l'objet instancié. Utiliser vars() pour afficher le contenu de l'objet
    print(vars(ma_voiture))
    #     4. Sauvegarder maintenant le contenu de l'objet dans le fichier objvoiture.json
    with open("sortie_3.json","w") as fout:
        json.dump(vars(ma_voiture),fout, indent=3)



