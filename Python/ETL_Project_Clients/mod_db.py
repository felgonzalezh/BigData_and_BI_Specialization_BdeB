# module to handle sql data bases in mysql. Extracting a loading
import pymysql
from mod_classes import Client

class Manipulation_bd:
    def __init__(self, data_list):
        self.data_list = data_list

    def get_connection(self):
        connexion = pymysql.connect(host="localhost",
                               user="root",
                               passwd="HDUSER",
                               db="northwindmysql",
                               cursorclass=pymysql.cursors.DictCursor)
        return connexion

    def close_connection(self, connexion):
        connexion.close()

    def reading_sql(self, sql_file):
        # function to extract sql database
        conn = self.get_connection()
        cursor = conn.cursor()
        requete = "SELECT * FROM "+str(sql_file)
        cursor.execute(requete)
        for row in cursor:
            id = row["id"]
            prenom = row["first_name"]
            nom = row["last_name"]
            email = row["email"]
            genre = row["gender"]
            ville = row["ville"]
            client = Client(id, nom, prenom, email, genre, ville)
            self.data_list.add_client(client)
        self.close_connection(conn)
        print("{} table data has been extracted".format(sql_file))

    def create_table_loading(self):
        # Function to create table where data will be loaded after transformation
        conn = self.get_connection()
        cde_ddl = """create table if not exists Clients(
            client_key int(5) primary key auto_increment,
            id int(5) not null,
            nom varchar(60),
            prenom varchar(60),
            curriel varchar(255),
            genre char(1),
            check (gender = 'F' or gender = 'M'),
            ville varchar(20)
            )
            """
        curseur = conn.cursor()
        curseur.execute(cde_ddl)
        self.close_connection(conn)

    def load_elements_table(self):
        # Function to load into a mysql database
        conn = self.get_connection()
        curseur = conn.cursor()
        for client in self.data_list.registre:
            cde = """insert into Clients(id,nom,prenom,curriel,genre,ville)values(%s, %s, %s, %s, %s, %s)
            """
            id = client.id
            prenom = client.prenom
            nom = client.nom
            curriel = client.curriel
            genre = client.genre
            ville = client.ville
            curseur.execute(cde, [id, nom, prenom, curriel, genre, ville])

        conn.commit()
        self.close_connection(conn)

