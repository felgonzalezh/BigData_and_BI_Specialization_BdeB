# writing data after transformation
import csv

import pymysql as pymysql


class Load_into_file:
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



class Load_into_bd:
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

    def create_table_loading(self):
        conn = self.get_connection()
        cde_ddl = """create table if not exists Clients(
            client_key int(5) primary key auto_increment,
            id int(5) not null,
            prenom varchar(60),
            nom varchar(60),
            curriel varchar(255),
            genre char(1),
            check (gender = 'F' or gender = 'M'),
            ville varchar(20)
            )
            """
        curseur = conn.cursor()
        curseur.execute(cde_ddl)
        self.close_connection(conn)

    def insert_elements_table(self):
        # inserer un enregistrement
        conn = self.get_connection()
        curseur = conn.cursor()

        for client in self.data_list.registre:
            cde = """insert into Clients(id,prenom,nom,curriel,genre,ville)values(%s, %s, %s, %s, %s, %s)
            """
            # inserer un enregistrement
            curseur.execute(cde, [client.id, client.prenom, client.nom, client.curriel, client.genre, client.ville])

        conn.commit()
        self.close_connection(conn)
