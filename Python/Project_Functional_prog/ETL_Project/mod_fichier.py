# Support pour la manipulation de fichier
import csv

from mod_classes import Article, Registre_Article


def lire_data(fichier, listo):
    with open(fichier) as fin:
        for line in fin.readlines():
            token = line.split()
            art_description = token[0]
            art_quantite = int(token[1])
            art_prix = float(token[2])
            listo.ajouter_article(Article(art_description,art_quantite,art_prix))

def ecrire_data(fichier,listo):
    with open(fichier, "w", newline="\n") as fout:
        ecriteur = csv.writer(fout, delimiter=",", quoting=csv.QUOTE_NONNUMERIC)
        for elem in listo.registre:
            # Serialisation
            art_description = elem.description
            art_quantite = elem.quantite
            art_prix = elem.prix
            ecriteur.writerow((art_description,art_quantite,art_prix))

