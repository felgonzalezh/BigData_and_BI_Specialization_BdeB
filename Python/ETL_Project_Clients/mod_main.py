# main to execute the ETL process

from mod_classes import Registre_Client
from mod_extraction import Extraction

def main():

    file_in = "data_config.json"
    etl = Extraction(file_in)

    # Loop over formats of files
    for file_format, data_set in etl.etl_data["data_sources"].items():
        # Loop over files. We pass the key to get the file
        for file in data_set:
            # Extraction
            listing = Registre_Client()
            etl = Extraction(file_in)
            if file_format == "csv":
                print("-" * 100)
                etl.reading_csv(file,listing)
                print("-" * 100)
            if file_format == "json":
                print("-" * 100)
                etl.reading_json(file, listing)
                print("-" * 100)
            else:
                print("Unknown format")
            listing.print_client()



if __name__ == '__main__':
    main()