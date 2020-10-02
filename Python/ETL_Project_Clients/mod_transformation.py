# Transformation class
class Transformation:
    def __init__(self,data_list):
        self.data_list = data_list

    def genre(self):
        for elem in self.data_list.registre:
            if elem.genre == "Female":
                elem.genre = "F"
            elif elem.genre == "Male":
                elem.genre = "M"
            else:
                elem.genre = ""