import pymysql.cursors

def obtenir_connexion():
    connexion = pymysql.connect(host="localhost",
                           user="root",
                           passwd="HDUSER",
                           db="northwindmysql",
                           cursorclass=pymysql.cursors.DictCursor)
    return connexion

def fermer_connexion(connexion):
    connexion.close()

def creer_table_chargement():
    conn = obtenir_connexion()
    cde_ddl = """create table if not exists articles(
        id int(4) primary key auto_increment,
        description varchar(50),
        quantite integer,
        rabais double
        )
        """
    curseur = conn.cursor()
    curseur.execute(cde_ddl)
    fermer_connexion(conn)

def inserer_tab_article(listing):
    # inserer un enregistrement
    conn = obtenir_connexion()
    curseur = conn.cursor()
    for art in listing.registre:
        cde = """insert into articles(description,quantite,rabais)values(%s, %s, %s)
        """
        # inserer un enregistrement
        curseur.execute(cde, [art.description, art.quantite, art.prix])

    conn.commit()
    fermer_connexion(conn)

#def recuperer_tab_articles(curseur):
#    requete = """select * from articles
#    """
#    curseur.execute(requete)
#    print("=" * 50)
#    for rec in curseur:
#        print("Article:{}, quantite:{}, rabais:{}".format(rec["article"], rec["quantite"], rec["rabais"]))




