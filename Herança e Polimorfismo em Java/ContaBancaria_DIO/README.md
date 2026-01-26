
# Conta Bancária

Este projeto faz parte de um exercício proposto no curso de Backend com Java & AWS da DIO.  
Seu objetivo é praticar conceitos de classes e encapsulamento e boas práticas de programação.

## 🏫 Desafio
Escreva um código onde temos uma conta bancaria que possa realizar as seguintes operações:

-  Consultar saldo
-  Consultar cheque especial
-  Depositar dinheiro
-  Sacar dinheiro
-  Pagar um boleto
-  Verificar se a conta está usando cheque especial

## 🎯 Requisitos
- A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
- O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
- Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00;
- Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
- Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial;