distancia, vel_max_per, tiempo = input().split()

distancia = float(distancia)
vel_max_per = float(vel_max_per)
tiempo = float(tiempo)

vel_media = distancia / tiempo

def evaluacion():
    if vel_media <= vel_max_per:
        print('OK')
    elif vel_media > vel_max_per and vel_media < vel_max_per*1.25:
        print('MULTA')
    elif vel_media >= vel_max_per*1.25:
        print('CURSO')

print(vel_media)