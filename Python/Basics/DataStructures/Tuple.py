my_tuple = (1, 2, 5, 7, 10, 45, 77, "Toto")
print(my_tuple)
# my_tuple[2]=100 => Error

my_tuple_2 = 1, 2, 5, 7, 10, 45, 77, "Toto", 77 # parenthesis are optional, but it's recommended to keep them
print("Tuple Accepts repeated elements: ", my_tuple_2)
print("Type: ", type(my_tuple_2))