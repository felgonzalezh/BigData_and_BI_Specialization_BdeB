# Classes needed
class Client:
    def __init__(self, id, prenom, nom, curriel, genre, ville):
        self.id = id
        self.prenom = prenom
        self.nom = nom
        self.curriel = curriel
        self.genre = genre
        self.ville = ville

    def __str__(self):
        return "id: {}, nom: {}, prenom: {}, curriel: {}, genre: {}, ville: {}".format(self.id,
                                                    self.nom, self.prenom, self.curriel,
                                                    self.genre, self.ville)


class Registre_Client:
    def __init__(self):
        self.registre = []

    def add_client(self, client):
        self.registre.append(client) # Improve: Must be added if it does not exist!

    def print_client(self):
        for elem in self.registre:
            print(elem)

    def remove_client(self,client):
        self.registre.remove(client)