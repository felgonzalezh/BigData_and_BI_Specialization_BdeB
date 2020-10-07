# It handles csv and jason files (extraction and loading)
import csv
import json

from mod_classes import Client

class Extraction:
    # It takes a file (csv or jason) and returns a list of Client objects
    def __init__(self, data_config):
        self.etl_data = json.load(open(data_config))
        self.etl_data_sources = self.etl_data["data_sources"]
        self.csv_path = self.etl_data["data_sources"]["csv"]
        self.json_path = self.etl_data["data_sources"]["json"]
        self.sql_path = self.etl_data["data_sources"]["sql"]

    def reading_csv(self, csv_file, data_list):
        with open(self.csv_path[csv_file]) as fin_csv:
            lecteur = csv.reader(fin_csv, delimiter=',', quoting=csv.QUOTE_NONE)
            for i, attribute in enumerate(lecteur):
                if i > 0: # avoids header
                    id = attribute[0]
                    prenom = attribute[1]
                    nom = attribute[2]
                    email = attribute[3]
                    genre = attribute[4]
                    ville = attribute[5]
                    client = Client(id , prenom, nom, email, genre, ville)
                    data_list.add_client(client)
            print("{} data has been extracted".format(self.csv_path[csv_file]))

    def reading_json(self, json_file, data_list):
        fin_json = json.load(open(self.json_path[json_file]))
        for line in fin_json:
            id = line["id"]
            prenom = line["first_name"]
            nom = line["last_name"]
            email = line["email"]
            ville = line["ville"]
            # to manage missing gender values. Should be generalized
            try:
                genre = line["gender"]
            except KeyError:
                genre = ""
            client = Client(id, prenom, nom, email, genre, ville)
            data_list.add_client(client)
        print("{} data has been extracted".format(self.json_path[json_file]))

class Load_into_file:
    # Loading into a csv file
    def __init__(self, file_out, data_list):
        self.data_list = data_list
        self.file_out = file_out

    def writing_data_into_file(self):
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
