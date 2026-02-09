import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        FormasGeometricas forma;
        int option;

        do{
            System.out.println("============================");
            System.out.println("Escolha a forma geométrica: ");
            System.out.println("1 - Quadrado");
            System.out.println("2 - Retangulo");
            System.out.println("3 - Circulo");
            System.out.println("4 - Trapezio");
            System.out.println("5 - Losango");
            System.out.println("\n0 - sair");
            System.out.println("============================");
            option = scanner.nextInt();

            if(option > 5 || option < 0){
                System.out.println("Opção invalida");
                return;
            }
            if(option == 0) break;

            forma = criarForma(option);
            if(forma == null) break;

            System.out.printf("O valor da area do %s é: %.2f\n",
                    forma.getClass().getCanonicalName(), forma.calcularArea());

            if(!consultarNovamente()) break;

        }while(true);
        System.out.println("Saindo...");
        System.exit(0);
    }

    private static FormasGeometricas criarForma(int option){
        switch (option){
            case 1 -> {
                System.out.println("Qual o valor do lado?");
                var lado = scanner.nextDouble();
                return new Quadrado(lado);
            }
            case 2 -> {
                System.out.println("Qual o valor da base?");
                var base = scanner.nextDouble();
                System.out.println("Qual o valor da altura?");
                var altura = scanner.nextDouble();
                return new Retangulo(base, altura);
            }
            case 3 -> {
                System.out.println("Qual o valor do raio?");
                var raio = scanner.nextDouble();
                return new Circulo(raio);
            }case 4 -> {
                System.out.println("Qual o valor da base maior?");
                var baseMaior = scanner.nextDouble();
                System.out.println("Qual o valor da base menor?");
                var baseMenor = scanner.nextDouble();
                System.out.println("Qual o valor da altura?");
                var altura = scanner.nextDouble();
                return new Trapezio(baseMenor,baseMaior,altura);
            }case 5 -> {
                System.out.println("Qual o valor da diagonal maior?");
                var diagonalMaior = scanner.nextDouble();
                System.out.println("Qual o valor da diagonal menor?");
                var diagonalMenor = scanner.nextDouble();
                return new Losango(diagonalMaior,diagonalMenor);
            }
        }
            return null;
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