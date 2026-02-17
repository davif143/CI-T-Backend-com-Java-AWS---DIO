import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int opCategoria, quantidade;
        double valor;
        Produtos produto;

        do{
            System.out.println("====== CONSULTAR IMPOSTO ======");
            System.out.println("Escolha a categoria: ");
            System.out.println("1 - Alimentação");
            System.out.println("2 - Saude");
            System.out.println("3 - Vestuario");
            System.out.println("4 - Cultura");
            System.out.println("0 - sair");
            System.out.println("==================");
            opCategoria = scanner.nextInt();

            if(opCategoria > 4 || opCategoria < 0){
                System.out.println("Opção invalida");
                return;
            }
            if(opCategoria == 0) break;

            System.out.println("Qual o valor do produto?");
            valor = scanner.nextDouble();

            System.out.println("Informe a quantidade:");
            quantidade = scanner.nextInt();

            produto = criarConsulta(opCategoria, quantidade, valor);

            if(produto == null) return;

            System.out.println("=========================");
            System.out.printf("Valor do produto: R$%.2f\n", valor);
            System.out.printf("Valor do imposto: R$%.2f\n", produto.calcularImposto());
            System.out.printf("Total com imposto: R$%.2f\n", produto.calcularValorTotal());
            System.out.println("=========================");

            if(!consultarNovamente()) break;

        } while(true);
        System.out.println("Saindo...");
        System.exit(0);
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

    private static Produtos criarConsulta(int op, int quantidade, double valor){
        switch (op){
            case 1 -> {
                return new Alimentacao(quantidade, valor);
            }
            case 2 -> {
                return new Saude(quantidade, valor);
            }
            case 3 -> {
                return new Vestuario(quantidade, valor);
            }
            case 4 -> {
                return new Cultura(quantidade, valor);
            }
            default -> {
                return null;
            }
        }
    }

}
