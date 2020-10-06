# BD SQLite
import sqlite3
# Creer une connexion
conn = sqlite3.connect("bigd.dbf")
# Creer le DDL pour la table.
# There is an error: It creates a column INTEGER
#creer le DDL pour la table
cde_ddl = """create table if not exists usagers(
id integer primary key autoincrement,
nom TEXT, 
age integer)
"""

# Creer une curseur
curseur = conn.cursor()
# Creer la table
curseur.execute(cde_ddl)

# INSERT d'enregistrement
cde = "insert into usagers(nom,age)values(?,?)"
nom = input("Votre nom: ")
age = input("Votre age: ")
curseur.execute(cde,[nom, age])
conn.commit()

# Effacer un enregistrement
#cde = "delete from usagers where nom='Andres'"
#curseur.execute(cde)
#conn.commit()

# Select
requete = "select id, nom,  age from usagers where age = ?"
age_recherche = int(input("age recherche: "))
curseur.execute(requete,[age_recherche,])

print("="*50)
# parcours
for rec in curseur:
    print("ID: {}, nom: {}, age: {} ".format(rec[0], rec[1], rec[2]))

# fermeture connection
conn.close()