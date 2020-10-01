#Extraction module.
# It takes a file and returns a list of Client objects
import json
from mod_classes import Client

class Extraction:
    def __init__(self, data_config):
        self.etl_data = json.load(open(data_config))
        self.etl_data_sources = self.etl_data["data_sources"]
        self.csv_path = self.etl_data["data_sources"]["csv"]

    def reading_csv(self, csv_file, data_list):
        with open(self.csv_path[csv_file]) as fin_csv:
            print("{} file has been opened".format(self.csv_path[csv_file]))
            for line in fin_csv.readlines():
                attribute = line.split(",")
                client = Client(attribute[0],attribute[2],attribute[1],attribute[3],attribute[4],
                   attribute[5])
                data_list.add_client(client)

