import csv

# Ruta del archivo CSV
ruta = 'C:\Users\Alexis\Documents\FES ARAGON\Tercer_Semestre\Estructura de Datos\Tarea_1/datos_redes.csv'

# Diccionarios para almacenar los datos
datos_twitter = {}
datos_facebook = {}
datos_youtube = {}
datos_twitter_crecimiento = {}
datos_facebook_crecimiento = {}
datos_facebook_me_gusta = {}
datos_youtube_me_gusta = {}

# Abrir el archivo CSV y leer los datos
with open(ruta, mode="r", encoding="utf-8") as f:
    reader = csv.reader(f)
    encabezados = next(reader)  # Leer la primera línea (encabezados)
    
    for fila in reader:
        red_social = fila[0]
        concepto = fila[1]
        
        # Procesar los datos de Twitter
        if red_social == "TWITTER":
            if concepto == "SEGUIDORES (FOLLOWERS)":
                for i, mes in enumerate(encabezados[3:], start=3):
                    valor = fila[i].replace('"', '').replace(',', '')  # Limpiar comillas y comas
                    try:
                        datos_twitter[mes] = int(valor)  # Convertir a entero
                    except ValueError:
                        datos_twitter[mes] = 0  # Asignar 0 si no se puede convertir
            
            elif concepto == "CRECIMIENTO DE FOLLOWERS":
                for i, mes in enumerate(encabezados[3:], start=3):
                    valor = fila[i].replace('"', '').replace(',', '')  # Limpiar comillas y comas
                    try:
                        datos_twitter_crecimiento[mes] = int(valor)  # Convertir a entero
                    except ValueError:
                        datos_twitter_crecimiento[mes] = 0  # Asignar 0 si no se puede convertir

        # Procesar los datos de Facebook
        if red_social == "FACEBOOK":
            if concepto == "CRECIMIENTO (seguidores)":
                for i, mes in enumerate(encabezados[3:], start=3):
                    valor = fila[i].replace('"', '').replace(',', '')  # Limpiar comillas y comas
                    try:
                        datos_facebook_crecimiento[mes] = int(valor)  # Convertir a entero
                    except ValueError:
                        datos_facebook_crecimiento[mes] = 0  # Asignar 0 si no se puede convertir
            
            elif concepto == "ME GUSTA EN PUBLICACIONES":
                for i, mes in enumerate(encabezados[3:], start=3):
                    valor = fila[i].replace('"', '').replace(',', '')  # Limpiar comillas y comas
                    try:
                        datos_facebook_me_gusta[mes] = int(valor)  # Convertir a entero
                    except ValueError:
                        datos_facebook_me_gusta[mes] = 0  # Asignar 0 si no se puede convertir

        # Procesar los datos de YouTube
        if red_social == "YOUTUBE":
            if concepto == "VISUALIZACIONES":
                for i, mes in enumerate(encabezados[3:], start=3):
                    valor = fila[i].replace('"', '').replace(',', '')  # Limpiar comillas y comas
                    try:
                        datos_youtube[mes] = int(valor)  # Convertir a entero
                    except ValueError:
                        datos_youtube[mes] = 0  # Asignar 0 si no se puede convertir
            
            elif concepto == "ME GUSTA":
                for i, mes in enumerate(encabezados[3:], start=3):
                    valor = fila[i].replace('"', '').replace(',', '')  # Limpiar comillas y comas
                    try:
                        datos_youtube_me_gusta[mes] = int(valor)  # Convertir a entero
                    except ValueError:
                        datos_youtube_me_gusta[mes] = 0  # Asignar 0 si no se puede convertir

# 1. Diferencia de seguidores en Twitter entre enero y junio
seguidores_enero = datos_twitter.get("ENERO", 0)
seguidores_junio = datos_twitter.get("JUNIO", 0)
diferencia_seguidores = seguidores_junio - seguidores_enero

# Mostrar la diferencia en pantalla
print(f"Diferencia de seguidores en Twitter entre enero y junio: {diferencia_seguidores}")

# 2. Diferencia de visualizaciones de YouTube entre dos meses seleccionados por teclado
mes_inicio = input("Ingrese el mes de inicio (ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO): ").upper()
mes_fin = input("Ingrese el mes de fin (ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO): ").upper()

if mes_inicio in datos_youtube and mes_fin in datos_youtube:
    visualizaciones_inicio = datos_youtube[mes_inicio]
    visualizaciones_fin = datos_youtube[mes_fin]
    diferencia_visualizaciones = visualizaciones_fin - visualizaciones_inicio
    print(f"Diferencia de visualizaciones en YouTube entre {mes_inicio} y {mes_fin}: {diferencia_visualizaciones}")
else:
    print("Meses ingresados no son válidos.")

# 3. Promedio de crecimiento de Twitter y Facebook entre enero y junio
def calcular_promedio(datos):
    total = 0
    meses = ["ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO"]
    for mes in meses:
        total += datos.get(mes, 0)
    return total / len(meses)

promedio_crecimiento_twitter = calcular_promedio(datos_twitter_crecimiento)
promedio_crecimiento_facebook = calcular_promedio(datos_facebook_crecimiento)

print(f"Promedio de crecimiento de Twitter entre enero y junio: {promedio_crecimiento_twitter}")
print(f"Promedio de crecimiento de Facebook entre enero y junio: {promedio_crecimiento_facebook}")

# 4. Promedio de “Me gusta” de YouTube, Twitter y Facebook entre enero y junio
def calcular_promedio_me_gusta(datos):
    total = 0
    meses = ["ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO"]
    for mes in meses:
        total += datos.get(mes, 0)
    return total / len(meses)

promedio_me_gusta_youtube = calcular_promedio_me_gusta(datos_youtube_me_gusta)

promedio_me_gusta_facebook = calcular_promedio_me_gusta(datos_facebook_me_gusta)

print(f"Promedio de 'Me gusta' en YouTube entre enero y junio: {promedio_me_gusta_youtube}")

print(f"Promedio de 'Me gusta' en Facebook entre enero y junio: {promedio_me_gusta_facebook}")