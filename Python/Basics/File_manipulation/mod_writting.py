#Writing

#fout = open("./animal.txt","w")
#fout.write("Le renard saute la barriere\n")
#fout.write("Le mouton n'a aucune chance\n")
#fout.close()

# Reading
with open("heures.txt") as fin:
    for line  in fin.readlines():
        print("-" * 30)
        #print(line)
        #for mot in line.split():
        #    print(mot)
        mot = line.split()
        print(mot[0], " ", mot[1])
