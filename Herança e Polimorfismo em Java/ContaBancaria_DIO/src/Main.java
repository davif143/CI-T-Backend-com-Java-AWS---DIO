import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa1= new Pessoa();
        int op;

        System.out.println("Informe seu nome: ");
        String nome = scanner.nextLine();
        pessoa1.setName(nome);

        System.out.println("Informe o deposito inicial:");
        double depositoInicial = scanner.nextDouble();
        var contaPessoa1 = new ContaBancaria(depositoInicial,pessoa1);

        System.out.printf("Ola %s, seja bem-vindo(a)!\n", pessoa1.getName());

        do {
            System.out.println("===== CONTA BANCÁRIA =====");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Consultar Cheque Especial");
            System.out.println("3 - Depositar Dinheiro");
            System.out.println("4 - Sacar Dinheiro");
            System.out.println("5 - Pagar Boleto");
            System.out.println("6 - Verificar se esta utilizando Cheque Especial");
            System.out.println("0 - sair");
            op = scanner.nextInt();

            switch (op){
                case 1 -> contaPessoa1.consultarSaldo();
                case 2 -> contaPessoa1.consultarChequeEspecial();
                case 3 -> {
                    System.out.println("Informe qual o valor do deposito");
                    double deposito = scanner.nextDouble();
                    contaPessoa1.deposito(deposito);
                }
                case 4 -> {
                    System.out.println("Saldo disponível: R$" + contaPessoa1.getSaldo());
                    System.out.println("Informe qual o valor do saque");
                    double saque = scanner.nextDouble();
                    contaPessoa1.sacarDinheiro(saque);
                }
                case 5 -> {
                    System.out.println("Informe o valor do boleto");
                    double boleto = scanner.nextDouble();
                    contaPessoa1.pagarBoleto(boleto);
                }
                case 6 -> contaPessoa1.utilizandoChequeEspecial();
                case 0 -> {
                    System.out.println("Fechando a conta...");
                    System.exit(0);
                }
                default ->System.out.println("Opção inválida");
            }
        } while(op != 0);
    }

}