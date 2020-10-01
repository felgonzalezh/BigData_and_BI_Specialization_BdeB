from mod_extraction import Extraction
from mod_load import writing_data


class Transformation(object):
    pass


def main():
    # Read JSON file with whole data files:
    # for each file:
    
    # Extraction:
    Extraction()
    # for each file, mod_extraction will return a list of objects Client
    
    # Transformation
    Transformation()

    # Load
    writing_data()



if __name__ == '__main__':
    main()
    
