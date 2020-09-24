import requests

url = "http://www.degenio.com/html5/contacts.json" # json file
reponse = requests.get(url).json() # get the json from url
data = reponse["contacts"] # 
print(type(data))

for element in data:
    for k,v in element.items():
        print(k,v)
    print("-"*100)

#for k in data.keys():
#    print(k)
