#List
my_list = [1, 2, 5, 7, 10, 45, 77]

print(my_list[4])
print(my_list[2:4])

# mutability
my_list[4] = "Toto"
print("4th element of the list: ", my_list[4])
# adding an element
my_list.append("Lolo")
print("Adding element Lolo to the list: ", my_list)
# insert an element
my_list.insert(2,True)
print("Inserting element True at 2nd index: ", my_list)
# doubles
my_list.append(65)
print("Inserting a repeated element (65): ", my_list)