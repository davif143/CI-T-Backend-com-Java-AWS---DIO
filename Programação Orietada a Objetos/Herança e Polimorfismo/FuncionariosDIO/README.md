
# Funcionarios - Controle de Usuários

Este projeto faz parte de um exercício proposto no curso de Backend com Java & AWS da DIO.  
Seu objetivo é praticar conceitos de classes e encapsulamento e boas práticas de programação.

## 🏫 Desafio
Crie uma hierarquia de classes que definam os tipos de usuários de um sistema. 

## 🎯 Requisitos
- **Classe Gerente** que terá os atributos: 
    - Nome;
    - Email;
    - Senha;
    - Atributo que informa se ele é administrador, esse último deve ser sempre verdadeiro;

- **Classe Vendedor** que terá os seguintes atributos: 
    - Nome;
    - Email;
    - Senha;
    - Quantidade de vendas;
    - Atributo que informa se ele é administrador, esse útimo deve ser sempre falso;

- **Classe Atendente** que terá os seguintes atributos: 
    - Nome;
    - Email;
    - Senha;
    - Valor em caixa;
    - Atributo que informa se ele é administrador, esse ultimo deve ser sempre falso;

## ⚙️ Métodos
- A **Classe Gerente** deve ter os métodos:
    - Gerar relatório financeiro;
    - Consultar vendas;
    - Realizar login;
    - Realizar logff;
    - Alterar dados;
    - Alterar senha;
- A **Classe Vendedor** deve ter os métodos:
    - Realizar venda ( incrementar o número de vendas quando acionado);
    - Consultar vendas;
    - Realizar login;
    - Realizar logoff;
    - Alterar dados;
    - Alterar senha;
- A **Classe Atendente** deve ter os métodos:
    - Receber pagamentos (onde o método recebe um valor que deve ser incrementado no valor em caixa);
    - Fechar o caixa;
    - Realizar Login;
    - Realizar logoff;
    - Alterar dados;
    - Alterar senha;
    