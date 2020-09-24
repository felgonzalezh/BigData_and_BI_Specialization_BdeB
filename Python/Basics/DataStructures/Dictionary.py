my_dict = {"nom":"FlouFlou", "prenom":"Alan", "age":25} #
print(my_dict)

print("indexation: ", my_dict["prenom"])

# Mutability
my_dict["nom"]="ClaireClaire"
print("mutable: ", my_dict)
# adding elements
my_dict["address"] = "HLT 1E4"
print("Adding element: ", my_dict)

print("="*50)

#methods
for k,v in my_dict.items():
    print("key-value: ", k,v)
print("-"*50)
# returning values
for v in my_dict.values():
    print("values: ",v)
print("-"*50)
# returning values
for k in my_dict.keys():
    print("keys:", k)