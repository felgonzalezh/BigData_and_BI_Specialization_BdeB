# main to execute the ETL process

from mod_classes import Registre_Client
from mod_extraction import Extraction
from mod_load import Load
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
            if file_format == "csv":
                print("-" * 100)
                etl.reading_csv(file,listing)
                print("-" * 100)
            elif file_format == "json":
                print("-" * 100)
                etl.reading_json(file, listing)
                print("-" * 100)
            #if file_format == "sql":
            #    print("-" * 100)
            #    etl.reading_sql(file, listing)
            #    print("-" * 100)
            else:
                print("-" * 100)
                print("Unknown format")
                print("-" * 100)
            # Transformation

            Transformation(listing).genre()
            #listing.print_client()

            # Loading
            Loading = Load("data_out.csv",listing)
            Loading.writing_data()



if __name__ == '__main__':
    main()