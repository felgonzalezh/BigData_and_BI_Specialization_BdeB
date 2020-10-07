This ETL project takes as an input the data_config.json file.

This file contains dictionaries with the datasources to be used in the ETL process. Each format
can contain a list of files to be used.

IMPORTANT:
sql tables must be loaded into mysql northwind database before extecuting the project. They are loaded through
http://localhost/phpmyadmin/index.php running the sql code contained in the sql file.

The schema is:

A for loop goes trough all the information contained in the data_config.json file.
main function identifies the data format and calls the proper functions for data extraction according
the data format. Then, it calls transformation and loading functions.

As a result, we get a data_out.csv file and a Clients table in the northwind database




