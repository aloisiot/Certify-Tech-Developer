number = int(input("Digite um numero: "))
num = number
divisor = 1
result = 0
while divisor < num:
    divisor  += 1
    if num % divisor == 0:
        result = 0
        break
    else:
        num/=divisor
        result = 1

if result == 1 or number ==2 :
    print("É primo")
else:
    print("Não é primo")