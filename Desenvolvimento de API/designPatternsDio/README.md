# 🚀 Spring Boot API: Gestão de Clientes com Integração ViaCEP

API REST desenvolvida para o gerenciamento de clientes, utilizando o ecossistema Spring para automatizar o preenchimento de endereços através da integração com a API externa do **ViaCEP**.

## 🎓 Contexto do Projeto
Este projeto é uma contribuição prática focada na aplicação de **Design Patterns** (Padrões de Projeto) em Java com Spring, desenvolvida como parte do currículo de um bootcamp da **DIO (Digital Innovation One)**.

O objetivo principal é demonstrar como padrões como **Singleton**, **Strategy** e **Facade** podem ser implementados de forma nativa e elegante utilizando as anotações do Spring Framework.

---

## ✨ Minhas Contribuições
Além da estrutura base proposta no curso, implementei funcionalidades adicionais para tornar a API mais robusta e dinâmica:

1.  **Busca Customizada por UF:** Implementação de um novo endpoint e consulta no repositório para filtrar clientes por estado (Unidade Federativa).
    * *Destaque técnico:* Uso de **JPQL** com `UPPER` e `IgnoreCase` para garantir que a busca funcione independentemente de como o usuário digite a UF (ex: "sp" ou "SP").
2.  **Atualização Dinâmica de Endereço:** Criação de um método específico no Service e Controller para trocar o endereço de um cliente já cadastrado informando apenas o novo CEP.
    * *Destaque técnico:* Refatoração da lógica de persistência para garantir que, ao atualizar o endereço, o sistema verifique se o novo CEP já existe na base antes de consultar a API externa.
---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência de dados)
* **Spring Cloud OpenFeign** (Client HTTP declarativo para consumo de API)
* **H2 Database** (Banco de dados em memória)
* **Jakarta Persistence** (Hibernate)

## 📋 Funcionalidades

A aplicação oferece um CRUD completo de clientes com preenchimento dinâmico de dados geográficos:

1.  **Cadastro Inteligente:** Ao enviar um cliente com apenas o CEP, a aplicação consome o ViaCEP e preenche automaticamente os campos de logradouro, bairro, cidade e UF.
2.  **Busca por UF:** Endpoint customizado para filtrar todos os clientes residentes em um estado específico (ex: SP, RJ, MG).
3.  **Atualização de Endereço:** Endpoint dedicado para atualizar o endereço de um cliente existente apenas fornecendo um novo número de CEP.

---

## 🛣️ Endpoints da API

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/clientes` | Lista todos os clientes. |
| `GET` | `/clientes/{id}` | Busca um cliente específico por ID. |
| `GET` | `/clientes/uf/{uf}` | Filtra clientes pela Unidade Federativa (Ex: `/clientes/uf/SP`). |
| `POST` | `/clientes` | Cadastra um novo cliente (Requer Nome e CEP). |
| `POST` | `/clientes/{id}?cep=00000000` | Atualiza o endereço do cliente baseado no novo CEP informado. |
| `PUT` | `/clientes/{id}` | Atualiza os dados gerais do cliente. |
| `DELETE` | `/clientes/{id}` | Remove um cliente do sistema. |

---

## 🏗️ Estrutura do Projeto

* **`controller`**: Camada de exposição dos recursos REST.
* **`service`**: Contém a interface e a lógica de negócio (`ServiceImpl`), gerenciando a interação entre banco de dados e API externa.
* **`repository`**: Interfaces que estendem `CrudRepository` para operações de banco de dados, incluindo consultas customizadas com JPQL.
* **`model`**: Entidades `Cliente` e `Endereco` mapeadas com JPA.
* **`ViaCepService`**: Interface Feign que consome o serviço `https://viacep.com.br/ws`.

## 📄 Exemplo de Payload (POST /clientes)

```json
{
  "nome": "João Silva",
  "endereco": {
    "cep": "01001000"
  }
}