
# Sudoku

Este projeto faz parte de um exercício proposto no curso de Backend com Java & AWS da DIO.  
Seu objetivo é praticar conceitos de classes e encapsulamento e boas práticas de programação.

---
## 🏫 Desafio
Criar um jogo de Sudoku em Java, implementando **funcionalidades essenciais** para um **jogo interativo e funcional no terminal**. 

O objetivo é consolidar seus conhecimentos em **programação orientada a objetos, manipulação de estruturas de dados, uso de métodos e classes**, além de lidar com **entradas e saídas no terminal**.

---
## 🎮 Funcionalidades

O sistema apresenta um menu interativo com as seguintes opções:

1.  **Iniciar Novo Jogo:** Renderiza o tabuleiro com os números iniciais (fixos).
2.  **Colocar Novo Número:** Solicita coordenadas `(x, y)` e o valor. Não permite sobrescrever números fixos.
3.  **Remover Número:** Limpa uma posição preenchida pelo jogador (impede a remoção de números fixos).
4.  **Verificar Jogo:** Exibe a situação atual do tabuleiro de forma visual.
5.  **Status do Jogo:** Informa se o jogo está:
   * `Não Iniciado`
   * `Incompleto` (com ou sem erros de posições conflitantes)
   * `Completo` (validado sem erros)
6.  **Limpar:** Remove todos os números informados pelo usuário, mantendo apenas os fixos.
7.  **Finalizar:** Encerra o jogo apenas se o tabuleiro estiver preenchido corretamente.

---

## 🚀 Como Executar

O programa recebe o mapa do Sudoku através do array de argumentos (`args`) do método `main`. Escolha o método de execução abaixo:

### 1. Pelo Terminal (CMD, PowerShell ...)
Devido ao caractere `;` ser um separador de comandos em muitos terminais, você deve envolver cada argumento individualmente em aspas:

```bash
# Compile o código
javac Main.java

# Execute (Exemplo com os primeiros argumentos)
java Main "0,0;4,false" "1,0;7,false" "2,0;9,true"
```

### 2. Pelo IntelliJ IDEA
O IntelliJ facilita o processo pois ele já trata os espaços como separadores de argumentos automaticamente.

-   No menu superior, clique na seta ao lado do botão de Play e selecione **Edit Configurations....**

-   No campo **Program arguments**, cole a sequência de argumentos **sem aspas extras** (apenas os blocos separados por espaço):

```bash
0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true 5,0;6,true 6,0;2,true 7,0;3,false 8,0;1,false 0,1;1,false 1,1;3,true 2,1;5,false 3,1;4,false 4,1;7,true 5,1;2,false 6,1;8,false 7,1;9,true 8,1;6,true 0,2;2,false 1,2;6,true 2,2;8,false 3,2;9,false 4,2;1,true 5,2;3,false 6,2;7,false 7,2;4,false 8,2;5,true 0,3;5,true 1,3;1,false 2,3;3,true 3,3;7,false 4,3;6,false 5,3;4,false 6,3;9,false 7,3;8,true 8,3;2,false 0,4;8,false 1,4;9,true 2,4;7,false 3,4;1,true 4,4;2,true 5,4;5,true 6,4;3,false 7,4;6,true 8,4;4,false 0,5;6,false 1,5;4,true 2,5;2,false 3,5;3,false 4,5;9,false 5,5;8,false 6,5;1,true 7,5;5,false 8,5;7,true 0,6;7,true 1,6;5,false 2,6;4,false 3,6;2,false 4,6;3,true 5,6;9,false 6,6;6,false 7,6;1,true 8,6;8,false 0,7;9,true 1,7;8,true 2,7;1,false 3,7;6,false 4,7;4,true 5,7;7,false 6,7;5,false 7,7;2,true 8,7;3,false 0,8;3,false 1,8;2,false 2,8;6,true 3,8;8,true 4,8;5,true 5,8;1,false 6,8;4,true 7,8;7,false 8,8;9,false
```

-   Clique em **Apply** e dê o **Run**.

## 🛠️ Guia de Estrutura do Input (`args`)

Para que o jogo funcione corretamente, o mapa do Sudoku deve ser injetado via argumentos de inicialização no formato de uma **String única** contendo as coordenadas e propriedades de cada célula.

### Formato da Unidade
Cada célula do tabuleiro é definida pelo padrão:  
`x,y;valor,isFixed`

| Componente | Tipo | Descrição |
| :--- | :--- | :--- |
| **x** | `int` | Índice da **Coluna** (0 a 8). |
| **y** | `int` | Índice da **Linha** (0 a 8). |
| **valor** | `int` | O número a ser inserido na posição (1 a 9). |
| **isFixed** | `boolean` | `true` para número fixo (dica) / `false` para valor da solução. |

---

### Regras de Negócio do Preenchimento

O comportamento do jogo muda drasticamente dependendo do valor booleano (`true`/`false`) informado no argumento:

#### 1. Valor Fixo (`isFixed = true`)
* **Exemplo:** `2,0;9,true`
* **Comportamento:** O número `9` aparecerá no tabuleiro assim que o jogo for iniciado.
* **Restrição:** O jogador **não pode** remover este número nem tentar inserir outro valor nesta mesma coordenada. Serve como as "pistas" iniciais do Sudoku.

#### 2. Valor Resposta (`isFixed = false`)
* **Exemplo:** `0,0;4,false`
* **Comportamento:** A célula `(0,0)` iniciará **vazia**.
* **Objetivo:** O jogador deve descobrir que o número `4` pertence a essa posição. Enquanto o jogador inserir qualquer valor diferente de `4` (ou deixar vazio), o status do jogo indicará que ele **"contém erros"** ou está **"incompleto"**.

---

### Visualização de Coordenadas
Para facilitar a criação de novos mapas, utilize o guia de eixos abaixo para mapear o array bidimensional:

```text
    x (Colunas) ->  0  1  2   3  4  5   6  7  8
    y (Linhas)
    |   0          [ ][ ][ ] [ ][ ][ ] [ ][ ][ ]
    v   1          [ ][ ][ ] [ ][ ][ ] [ ][ ][ ]
        2          [ ][ ][ ] [ ][ ][ ] [ ][ ][ ]
        ...
```

### Exemplo de String Completa (Resumida)
Se você quisesse iniciar um jogo apenas com dois números, o argumento seria:
`"0,0;4,false 2,0;9,true"`

> **Nota:** Cada definição de célula deve ser separada por um **espaço simples** dentro da mesma String de argumentos.
> 
