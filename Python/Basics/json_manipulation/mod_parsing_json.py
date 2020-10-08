import json

with open("voiture.json") as fin:
    voiture = json.load(fin)

    for k,v in voiture.items():
        print(k,v)
#  Faire afficher le contenu du fichier json voiture.json et iterer à travers le dictionnaire
    for k,v in voiture["voiturette"].items():
        print("cle: ", k, " valeur: ", v)

# Lire le contenu du fichier JSON, changer la couleur vers Noire et sauvegarder le fichier
voiture["voiturette"]["couleur"] = "Noire"
# sauvgarde
with open("sortie.json", "w") as fout:
    json.dump(voiture, fout, indent=3)