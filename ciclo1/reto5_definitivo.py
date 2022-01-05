from typing import Protocol

def agregar():
    if items[0] in productos:
        return(False)
    else: 
        key = items[0]
        items.pop(0)
        productos[key] = items


def actualizar():
    if items[0] not in productos:
        return(False) 
    else: 
        key = items[0]
        items.pop(0)
        productos[key] = items


def borrar():
    if items[0] not in productos:
        return(False) 
    else:
        key = items[0]
        productos.pop(key) 


def precio_mayor():
    vmayor = 0
    for x in productos.values():
        if x[1] > vmayor:
            vmayor = x[1]
            nmayor = x[0]
    return nmayor


def precio_menor(productos):
    vmenor = float('inf')
    for x in productos.values():
        if x[1] < vmenor:
            vmenor = x[1]
            nmenor = x[0] 
    return nmenor
    

def promedio():
    suma = 0
    for x in productos.values():
       suma += x[1]
    prom = suma/len(productos)
    return round(prom, 1)


def inventario(productos):
    suma = 0
    for x in productos.values():
        suma += x[1]*x[2]
    return float(round(suma, 1))


productos = {
    1:['Tangelos',9000,67], 
    2:['Limones',2500,35], 
    3:['Peras',2700,65], 
    4:['Arandanos',9300,34],
    5:['Tomates',8100,42], 
    6:['Fresas',9100,90], 
    7:['Helado',4500,41], 
    8:['Galletas',700,18], 
    9:['Chocolates',4500,80], 
    10:['Jamon',11000,55]
    }

accion = input()

items = input().split()

items[0] = int(items[0])

items[2] = float(items[2])
items[3] = float(items[3])

if accion == 'AGREGAR':
    flag = agregar() 
elif accion == 'ACTUALIZAR':
    flag = actualizar()
elif accion == 'BORRAR':
    flag = borrar()

if flag == False:
    print("ERROR")
else:
    print(precio_mayor(), precio_menor(productos), promedio(), inventario(productos))
    