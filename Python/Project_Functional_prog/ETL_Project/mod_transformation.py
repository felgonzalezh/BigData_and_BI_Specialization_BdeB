# module de fonctions de transformation
def modifier_description(listo):
    for elem in listo.registre:
        elem.description = elem.description.upper()

def donner_rabais(listo, qte_min, rabais):
    for elem in listo.registre:
        if elem.quantite < qte_min:
            elem.prix = round(elem.prix*(1 - rabais*0.01), 2)



