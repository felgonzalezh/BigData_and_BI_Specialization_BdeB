#Extraction module.
# It takes a file and returns a list of Client objects
import csv
import json
from mod_classes import Client

class Extraction:
    def __init__(self, data_config):
        self.etl_data = json.load(open(data_config))
        self.etl_data_sources = self.etl_data["data_sources"]
        self.csv_path = self.etl_data["data_sources"]["csv"]
        self.json_path = self.etl_data["data_sources"]["json"]
        self.sql_path = self.etl_data["data_sources"]["sql"]

    def reading_csv(self, csv_file, data_list):
        with open(self.csv_path[csv_file]) as fin_csv:
            print("{} file has been opened".format(self.csv_path[csv_file]))
            lecteur = csv.reader(fin_csv, delimiter=',', quoting=csv.QUOTE_NONE)
            for i, attribute in enumerate(lecteur):
                if i > 0:
                    id = attribute[0]
                    prenom = attribute[1]
                    nom = attribute[2]
                    email = attribute[3]
                    genre = attribute[4]
                    ville = attribute[5]
                    client = Client(id , prenom, nom, email, genre, ville)
                    data_list.add_client(client)

    def reading_json(self, json_file, data_list):
        fin_json = json.load(open(self.json_path[json_file]))
        print("{} file has been opened".format(self.json_path[json_file]))
        for line in fin_json:

            id = line["id"]
            prenom = line["first_name"]
            nom = line["last_name"]
            email = line["email"]
            ville = line["ville"]
            try:
                genre = line["gender"]
            except KeyError:
                genre = ""

            client = Client(id, prenom, nom, email, genre, ville)
            data_list.add_client(client)
