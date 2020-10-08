import requests

url = "http://www.degenio.com/html5/contacts.json"
reponse = requests.get(url).json()
print(reponse)

data = reponse["contacts"]
for elem in data:
    for k, v in elem.items():
        print(k, " : ", v)
    print("="*50)
    #print("id: {}, name: {}, email: {}".format(i["id"],i["name"], i["email"]))


