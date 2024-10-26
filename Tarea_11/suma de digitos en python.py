def suma_digitos(n):

    if n == 0:
        return 0
    else:
        
        return n % 10 + suma_digitos(n // 10)

numero = 1654987231999999

resultado = suma_digitos(numero)
print(f"La suma de los dígitos de {numero} es: {resultado}")