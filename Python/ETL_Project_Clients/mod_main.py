# main to execute the ETL process

from mod_classes import Registre_Client
from mod_files import Extraction
from mod_files import Load_into_file
from mod_db import Manipulation_bd
from mod_transformation import Transformation


def main():

    file_in = "data_config.json"
    etl = Extraction(file_in)

    # Loop over formats of files
    for file_format, data_set in etl.etl_data["data_sources"].items():
        # Loop over files. We pass the key to get the file, or the table of the database
        for file_key, file in data_set.items():
            print("="*50)
            print("Extraction: {} files".format(file_format))
            # ----------
            # Extraction
            # ----------
            listing = Registre_Client()
            flag = False
            if file_format == "csv":
                print("-" * 50)
                etl.reading_csv(file_key,listing)
                print("-" * 50)
                flag = True
            elif file_format == "json":
                print("-" * 50)
                etl.reading_json(file_key, listing)
                print("-" * 50)
                flag = True
            elif file_format == "sql":
                print("-" * 100)
                print(file)
                Manipulation_bd(listing).reading_sql(file)
                print("-" * 100)
                flag = True
            else:
                print("-" * 50)
                print("Unknown format")
                print("-" * 50)
                flag = False
            # --------------
            # Transformation
            # --------------
            if flag:
                print("Transformation")
                transform = Transformation(listing)
                transform.genre()
                transform.filling_gender()
            # -----------------
            # Loading into file
            # -----------------
                print("-" * 50)
                print("Load {} data into output file".format(file_format))
                Loading_file = Load_into_file("data_out.csv",listing)
                Loading_file.writing_data_into_file()
            # ---------------
            # Loading into db
            # ---------------
                print("Load {} data into data base".format(file_format))
                Loading_db = Manipulation_bd(listing)
                Loading_db.create_table_loading()
                Loading_db.load_elements_table()

if __name__ == '__main__':
    main()