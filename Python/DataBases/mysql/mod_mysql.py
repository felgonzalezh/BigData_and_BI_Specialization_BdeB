import pymysql.cursors

# creer une connexion
conn = pymysql.connect(host="localhost",
                       user="root",
                       passwd="HDUSER",
                       db="northwindmysql",
                       cursorclass=pymysql.cursors.DictCursor)

cde_ddl = """create table if not exists usagers(
id int(4) primary key auto_increment,
nom varchar(50),
age integer
)
"""

# Lancer la création
curseur = conn.cursor()
curseur.execute(cde_ddl)

#inserer un enregistrement
cde = """insert into usagers(nom,age)values(%s, %s)
"""
nom = input("Votre nom:")
age = int(input("Votre age:"))
curseur.execute(cde, [nom,age])
conn.commit()
#Effectuer un select
age_recherche = int(input("age recherché:"))
requete ="""select id, nom, age from usagers where age = %s
"""
curseur.execute(requete,[age_recherche,])
print("=" * 50)
for rec in curseur:
   print("ID:{}, nom:{}, age:{}".format(rec["id"], rec["nom"], rec["age"]))

#fermer BD
conn.close()

