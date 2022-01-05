N = int(input())

ciudades = []

requisitos = [60, 94, 30, 20]

for i in range(N):
    ciudades.append(input().split())

con = 0

for N in range(len(ciudades)):
    if int(ciudades[N][0]) > requisitos[0] and int(ciudades[N][1]) > requisitos[1] \
        and int(ciudades[N][2]) > requisitos[2] and int(ciudades[N][3]) < requisitos[3]:
        print(ciudades[N][4])
        con+=1 
if con == 0: 
    print("NO DISPONIBLE")
