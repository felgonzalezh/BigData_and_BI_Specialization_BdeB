import csv

with open("heures.txt") as fin:
    with open("sol_exercise3.txt","w", newline="\n") as fout:
        ecriteur = csv.writer(fout, delimiter=";", quoting= csv.QUOTE_NONNUMERIC)
        #qouting distincs the variable type
        for line  in fin.readlines():
            mot = line.split()
            total = 0
            for i in mot[2:]:
                total += float(i)
            avg = total / len(mot[2:])

            print("{1:10s} Code {0:3s} a travaille {2:3.2f} heures "
                  "avec une moyenne de {3:3.2f} / jour \n".format(mot[0], mot[1],total, avg))

            ecriteur.writerow((mot[0],mot[1],total,avg))
            #sortie: total and avg does not need to be converted to string