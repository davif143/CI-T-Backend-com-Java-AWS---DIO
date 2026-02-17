import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int option;
    static Operations operador;
    static double num1, num2;

    public static void main(String[] args) {
        do{
            System.out.println("======= CALCULADORA =======");
            System.out.println("1 - Somar");
            System.out.println("2 - Subtrair");
            System.out.println("3 - Multiplicar");
            System.out.println("4 - Dividir");
            System.out.println("5 - sair");
            System.out.println("===========================");
            option = scanner.nextInt();

            // Verifica se o usuário informou alguma opção invalida no menu, senão retorna para o inicio do
            // menu novamente.
            if(option > 5 || option < 0){
                System.out.println("Opção invalida");
                continue;
            }
            if(option == 5) break;

            scanner.nextLine();

            System.out.println("Informe os dois numeros para o calculo:");
            System.out.println("(Separe os numeros com virgula -> Ex: 23,2)");
            var stringNum = scanner.nextLine();

            // Verifica se o usuário digitou apenas um unico numero ou se esqueceu de incluir a virgula, senão,
            // retorna para o começo do menu
            if(!stringNum.contains(",")){
                System.out.println("Informe os numeros separados com a virgula!");
                continue;
            }

            // Utiliza da função para separar os numeros informados junto a virgula e coloca-los
            // em variaveis do tipo double para poder realizar o calculo
            extrairNumeros(stringNum);

            // Atribui a constante Enum correspondente ao valor de 'option' escolhido no menu.
            // OBS: a ordem do menu e do enum devem ser a mesma, senão as operações estarão
            // trocadas quando usuário escolher.

            operador = Operations.values()[option - 1];
            var result = operador.calcular(num1,num2);
            System.out.printf("%s %s %s = %.2f\n", num1, operador.getSimbolo(), num2, result);

            //Verifica se o usuário quer realizar mais algum outro calculo
            if(!consultarNovamente()) break;
        }while(true);


        System.out.println("Saindo....");
        System.exit(0);
    }

    /* Função dedicada para extrair os numeros informados e inserí-los e converte-los em variaveis independentes
     e do tipo double para ser possivel realizar os calculos.

        Funcionamento:
        Irá atribuir em 'indexNum' a posição em que a virgula se encontra na String.
        Depois percorremos a String até encontrarmos a virgula:
        • Enquanto não encontramos a virgula concatenamos em uma StringBuilder os caracteres do primeiro numero;
        • Quando encontramos a virgula começamos a concatenar em outra StringBuilder os caracteres do segundo numero;
        Por fim, ao terminar de percorrer a String iremos converter as duas StringBuilders em Double.
    */
    private static void extrairNumeros(String numeros){
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();
        var indexNum = numeros.indexOf(",");
        for(int i = 0; i < numeros.length(); i++){
            char c = numeros.charAt(i);
            if(i < indexNum){
                n1.append(c);
            } else if(i > indexNum){
                n2.append(c);
            }
        }
        num1 = Double.parseDouble(n1.toString());
        num2 = Double.parseDouble(n2.toString());
    }

    private static boolean consultarNovamente(){
        while(true){
            int option;
            System.out.println("Deseja fazer nova consulta? \n(1) Sim | (2) Não");
            option = scanner.nextInt();
            if(option != 1 && option != 2){
                System.out.println("Opção invalida");
            }else return option == 1;
        }
    }
}