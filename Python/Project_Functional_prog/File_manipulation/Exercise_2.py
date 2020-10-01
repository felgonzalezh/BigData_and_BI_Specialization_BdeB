# Développer une fonction traiter_casse() qui
# prend deux fichiers et copie le contenu
# du premier fichier dans le deuxième mais
# en prenant soin d'enlever les lignes qui
# commence par une minuscule.
file_in = "casse.txt"
file_out = "sol_exercise2.txt"

def traiter_casse(file1, file2):
    with open(file1) as fin:
        with open(file2, "w") as fout:
            for line in fin.readlines():
                first_letter = ""
                if(line[0] == "\t"):
                    first_letter = line[1]
                else:
                    first_letter = line[0]
                if(first_letter.isupper()):
                    fout.write(line)

traiter_casse(file_in,file_out)