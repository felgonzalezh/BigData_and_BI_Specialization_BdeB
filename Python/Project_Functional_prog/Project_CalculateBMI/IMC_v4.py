from modele.mod_class import Patient

print("This program caculates your BMI")
print("=" * 50)

imc_limits = [18.8, 25.0, 30.0, 35.0, 40.0]  # List of classification weights
risque = ["Accru", "Moindre", "Accru +", "Eleve", "Tres Eleve", "Extremement eleve"]  # List of risks
imc_clasification = ["Poids insuffisant", "Poids normal", "Exces de poids",  # List of classification imcs
                     "Obesite classe 1", "Obesite classe 2", "Obesite classe 3"]

def input_values(msg, error_msg):
    flag = True
    while flag:
        try:
            x = float(input(msg))
            while x <= 0:
                x = float(input(error_msg))
            flag = False
        except ValueError:
            print(error_msg)
    print("-"*60)
    return x

def calcul_imc(patient):
    return patient.poids / (patient.taille ** 2)

def print_imc(imc):
    print("your imc is: {0:3.2f}".format(imc))

def print_classification(imc):
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
    print("Classification: {}, risque: {}".format(imc_clasification[index], risque[index]))

def main():

    patient_nom = input("Type your name: ")
    patient_age = input_values("Age: ", "Type a valid age value")
    patient_poids = input_values("Type your WEIGHT in kg: ",
                             "Please type a valid WEIGHT value (float greater than 0): ")
    patient_taille = input_values("Type your HEIGHT in m: ",
                             "Please type a valid HEIGHT value (float greater than 0): ")

    patient_1 = Patient(patient_nom,patient_age,patient_poids,patient_taille)
    print(patient_1)

    imc = calcul_imc(patient_1)
    print_imc(imc)
    print_classification(imc)

if __name__ == '__main__':
    main()
