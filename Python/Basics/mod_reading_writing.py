name = input("Your lastname: ")
print(name)
salary = float(input("Your salary: "))
salary += 500
print(salary)
print("="*50)

print("Your lastname: {}, your salary: {}".format(name,salary))
print("Your lastname: {0:25s}, your salary: {1:7.2f}".format(name,salary))
print("Your salary: {1:7.2f}, your lastname: {0:20s}".format(name,salary))
# {0:25s} = 0 variable position, 25 number of characters of the string s,
# {1:7.2f} = 1 varible position, 7.2 is the format of te float f
