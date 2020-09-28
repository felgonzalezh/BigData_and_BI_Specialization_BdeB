with open("heures.txt") as fin:
    with open("sol_exercise3.txt","w") as fout:
        for line  in fin.readlines():
            mot = line.split()
            total = 0
            for i in mot[2:]:
                total += float(i)
            avg = total / len(mot[2:])

            print("{1:10s} Code {0:3s} a travaille {2:3.2f} heures "
                  "avec une moyenne de {3:3.2f} / jour \n".format(mot[0], mot[1],total, avg))

            fout.write(mot[0]+"\t"+mot[1]+"\t"+str(total)+"\t"+str(avg)+"\n")