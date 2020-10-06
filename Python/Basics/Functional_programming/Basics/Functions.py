#variable global
biais = 10
def calcul_exponant(oper1, oper2=2):
    """
    Calcul d'exposant par un function
    :param oper1:
    :param oper2:
    :return: la valuer de oper1 a la puissance oper2
    """
    global biais # make variable global
    biais = 5 # local variable
    return oper1**oper2+biais

def main():
    resultat = calcul_exponant(2,4)
    print(resultat)

    resultat = calcul_exponant(oper2=2,oper1=4)
    print(resultat)

    resultat = calcul_exponant(10)
    print(resultat)

    print(biais)

# function call
if __name__ == '__main__':
    main()