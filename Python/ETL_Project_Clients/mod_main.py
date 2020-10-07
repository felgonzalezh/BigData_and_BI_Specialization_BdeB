# main to execute the ETL process

from mod_classes import Registre_Client
from mod_extraction import Extraction
from mod_load import Load_into_file, Load_into_bd
from mod_transformation import Transformation


def main():

    file_in = "data_config.json"
    etl = Extraction(file_in)

    # Loop over formats of files
    for file_format, data_set in etl.etl_data["data_sources"].items():
        # Loop over files. We pass the key to get the file
        for file in data_set:
            print("="*50)
            print("Extraction: {} files".format(file_format))
            # Extraction
            listing = Registre_Client()
            flag = False
            if file_format == "csv":
                print("-" * 50)
                etl.reading_csv(file,listing)
                print("-" * 50)
                flag = True
            elif file_format == "json":
                print("-" * 50)
                etl.reading_json(file, listing)
                print("-" * 50)
                flag = True
            #if file_format == "sql":
            #    print("-" * 100)
            #    etl.reading_sql(file, listing)
            #    print("-" * 100)
            #    flag = True
            else:
                print("-" * 50)
                print("Unknown format")
                print("-" * 50)
                flag = False

            # Transformation

            if flag:
                print("Transformation")
                Transformation(listing).genre()

            #listing.print_client()

            # Loading into file
                print("-" * 50)
                print("Load {} files data".format(file_format))
                Loading_file = Load_into_file("data_out.csv",listing)
                Loading_file.writing_data_into_file()

            # Loading into db
                Loading_db = Load_into_bd(listing)
                Loading_db.create_table_loading()
                Loading_db.insert_elements_table()

if __name__ == '__main__':
    main()