print("Welcome World")

name = "Alan FlouFlou"
print("type: ", type(name))
print("memory spot: ", id(name))
print("="*50)
name = 123 # variable name does not have reference to the same id address
print("type: ", type(name))
print("memory spot: ", id(name))
