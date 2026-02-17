
# Linha Telefônica  - Formatação

Este projeto faz parte de um exercício proposto no curso de Backend com Java & AWS da DIO.  
Seu objetivo é praticar conceitos de classes e encapsulamento e boas práticas de programação.

## 🏫 Desafio
Escreva um código que receba entradas sem formatação e as retorne formatadas, os tipos de entradas que o código deve retornar são as seguintes:

- **Telefone fixo** 
  - 8 dígitos sem DDD xxxx-xxxx;
  - 10 Dígitos com DDD (xx)xxxx-xxxx;
- **Celular** 
  - 9 dígitos sem DDD xxxxx-xxxx;
  - 11 dígitos (xx)xxxxx-xxxx;

## 🎯 Requisitos
O código deve ser capaz de detectar as seguintes situações:

- Se receber **somente números**:
  - Detectar se corresponde com algum dos **formatos aceitos** e **retornar formatado**;
- Se receber uma **entrada com quantidade de números diferentes dos padrões** descritos acima:
  - Informar que não se trata de um **número válido**;
- Se receber um **número formatado**:
  - Retorna-lo do **mesmo jeito** e **informar de qual tipo de dispositivo se trata**;
- Se receber com **mascara/formatação incorreta**: 
  - **Corrigir e retornar**;
- Se receber **qualquer entrada** que tenha **números** e **outros caracteres**:
  - Verificar se tem **números suficiente** para compor um dos tipos aceitos;
    - Se sim, **Retornar do que se trata**;
    - Se não, **Retornar que foi uma entrada inválida**.

    