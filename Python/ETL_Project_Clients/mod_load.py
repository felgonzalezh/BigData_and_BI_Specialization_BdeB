# writing data after transformation
import csv


class Load:
    def __init__(self, file_out, data_list):
        self.data_list = data_list
        self.file_out = file_out

    def writing_data(self):
        with open(self.file_out, "a", newline="\n") as fout:
            ecriteur = csv.writer(fout, delimiter=",", quoting=csv.QUOTE_NONNUMERIC)
            for elem in self.data_list.registre:
                # Serialisation
                id = elem.id
                nom = elem.nom
                prenom = elem.prenom
                curriel = elem.curriel
                genre = elem.genre
                ville = elem.ville
                ecriteur.writerow((id, nom, prenom, curriel, genre, ville))