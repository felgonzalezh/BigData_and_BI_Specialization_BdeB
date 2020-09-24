print("This program caculates your BMI")
print("="*50)

#List of classification weights
imc_limits = [18.8, 25.0, 30.0, 35.0, 40.0]
# List of risks
risque = ["Accru","Moindre","Accru +","Eleve","Tres Eleve", "Extremement eleve"]
#List of classification imcs
imc_clasification = ["Poids insuffisant","Poids normal","Exces de poids", "Obesite classe 1",
                     "Obesite classe 2","Obesite classe 3"]

def valid_values(variable):
    """
    Check valid values: float greater than 0
    :param variable: String that refers the variable
    you want to check if the user returns a value greater than 0
    :return: the valid value returned by the user (float and greater than 0)
    """
    x = 0
    while x <= 0:
        try:
            x = float(input("Type your {} in kg (greater than 0): ".format(str(variable))))
        except ValueError:
            print("Type a valid {} (float)".format(str(variable)))
    return x

weight = valid_values("weight")
height = valid_values("height")

def calcul_imc(w,h):
    """
    calculation of BMI
    :param w: weight
    :param h: height
    :return: BMI value, its risk amd its calification
    """
    print("-"*50)
    imc = w/(h**2)
    print("your imc is: {0:3.2f}".format(imc))
    if imc <= imc_limits[0]:
        index = 0
    elif imc < imc_limits[1]:
        index = 1
    elif imc < imc_limits[2]:
        index = 2
    elif imc < imc_limits[3]:
        index = 3
    elif imc < imc_limits[4]:
        index = 4
    else:
        index = 5
    print("Classification: {}, risque: {}".format(imc_clasification[index],risque[index]))

# BMI function call
calcul_imc(weight,height)
