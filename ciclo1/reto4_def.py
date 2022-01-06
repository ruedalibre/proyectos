n, k = input().split()

k = int(k)

valores = input().split()
valores_int = []

for i in valores:
    valores_int.append(int(i))

originales = []
copias = 0
for i in valores:
    for i in originales:
        copias += 1
    else: 
        originales.append(i)

copias_m = 0
originales = []
for i in range(len(valores)): 
    inicio = i - k
    fin = i
    aux = valores[inicio:fin]
    
    if valores[i] in aux:
        copias_m += 1
    if inicio < 0:
        if valores[i] in originales:
            copias_m += 1
        else: 
            originales.append(valores[i])       

print(copias, copias_m)

# CORRECCION: Es porque estás usando la lista llamada 'valores' 
# en vez de la que cambiaste a enteros, que se llama 'valores_int'. 
# Si usas valores, estás comparando con strings, debes usar valores_int