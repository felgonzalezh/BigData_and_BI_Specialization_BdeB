# module pour lancer le procesus ETL
from mod_classes import Article, Registre_Article
from mod_fichier import lire_data, ecrire_data
from mod_transformation import modifier_description, donner_rabais

def main():
    #Extraction
    listing = Registre_Article()
    lire_data("data.txt",listing)
    print("="*50)
    print("Contenu du fichier apres extraction")
    listing.afficher_article()
    print("=" * 50)
    # Transformation
    print("=" * 50)
    print("Transformation apres extraction")
    modifier_description(listing)
    # Demande la quantite minimun
    qte_min = int(input("Saisi SVP la quantite minimum pour avoir un rabais: "))
    # Demande la rabais
    rabais = float(input("Saisi SVP le rabais (%): "))
    donner_rabais(listing, qte_min, rabais)
    print("=" * 50)
    print("Contenu du memoire apres transformation")
    listing.afficher_article()
    print("=" * 50)
    #Chargement
    ecrire_data("data_out.csv",listing)
    print("Chargement termine")
    print("=" * 50)
if __name__ == '__main__':
    main()
