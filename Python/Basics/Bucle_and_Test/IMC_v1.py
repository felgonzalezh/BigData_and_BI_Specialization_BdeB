print("This program caculates your IMC")
weight = float(input("Type your weight in kg: "))
height = float(input("Type your height in m: "))

# imc_value = weight/(height**2)
def calcul_imc(w,h):
    imc = w/(h**2)
    print("your imc is: {0:3.2f}".format(imc))
    if imc <= 18.5:
        print("Accru")
    elif imc < 25:
        print("Moindre")
    elif imc < 30:
        print("Accru +")
    elif imc < 35:
        print("Eleve")
    elif imc < 40:
        print("Tres Eleve")
    else:
        print("Extremement eleve")

calcul_imc(weight,height)
