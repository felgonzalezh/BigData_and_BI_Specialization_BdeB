#Développer une fonction calcul_fichier_stats
# qui prend un fichier et retourne la ligne la plus longue dans le fichier.
def calcul_fichier_stats(file):
    with open(file) as fin:
        length = 0
        longest_line = ""
        for line in fin.readlines():
            if(len(line) > length):
                longest_line = line
                length = len(line)
    return longest_line

print("The longest line is: ")
print(calcul_fichier_stats("stats.txt"))

