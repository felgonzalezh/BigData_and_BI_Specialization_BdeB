# Transformation class
class Transformation:
    def __init__(self,data_list):
        self.data_list = data_list
        self.female_list = []
        self.male_list = []
        self.no_gender_list = []
        # Names with unfilled gender value:
        self.female_missing_gender = ["Mary", "Frances", "Doris", "Cynthia", "Marie",
                                      "Betty", "Janet", "Susan", "Anne", "Gloria",
                                      "Ruby"]
        self.male_missing_gender = ["Christopher", "Larry", "Jonathan", "Donald",
                           "Jack", "Joshua", "Jerry", "Joan", "Ronald","Willie"]

    def genre(self):
        # Funtion to transform gender values and to find unfilled gender values
        for elem in self.data_list.registre:
            if (elem.genre == "Female") | (elem.genre == "F"):
                elem.genre = "F"
                self.female_list.append(elem.prenom)
            elif (elem.genre == "Male") | (elem.genre == "M"):
                elem.genre = "M"
                self.male_list.append(elem.prenom)
            else:
                elem.genre = ""
                self.no_gender_list.append(elem.prenom)

    def filling_gender(self):
        # Function to fill unfilled gender values with those of an another person with the same name
        for elem in self.data_list.registre:
            if (elem.genre == "") & (elem.prenom in self.female_list) | (elem.prenom in self.female_missing_gender):
                elem.genre = "F"
            elif (elem.genre == "") & (elem.prenom in self.male_list) | (elem.prenom in self.male_missing_gender):
                elem.genre = "M"
            else:
                self.no_gender_list.append(elem.prenom)
