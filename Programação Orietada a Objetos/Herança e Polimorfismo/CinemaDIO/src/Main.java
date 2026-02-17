import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    var filme = new MeiaEntrada();
    var filme2 = new IngressoFamilia();
    var scanner = new Scanner(System.in);
    int option, optionIngresso, quantiaIngressos, optionIdioma;
    double valorIngresso = 30.0;
    String nomeFilme = "", idioma;

        System.out.println("======== CINEMA ========");
        System.out.println("1 - A culpa é das estrelas");
        System.out.println("2 - Velozes e Furiosos 7");
        System.out.println("3 - Frozen");
        System.out.println("4 - Jurassic Park");
        System.out.println("========================");
        option = scanner.nextInt();

        switch (option){
            case 1 -> nomeFilme = "A culpa é das estrelas";
            case 2 -> nomeFilme = "Velozes e Furiosos 7";
            case 3 -> nomeFilme = "Frozen";
            case 4-> nomeFilme = "Jurassic Park";
            default -> {
                System.out.println("Opcao invalida");
                return;
            }
        }

        System.out.println("Qual o idioma do filme:");
        System.out.println("(1) Dublado | (2) Legendado");
        optionIdioma = scanner.nextInt();

        if(optionIdioma == 1) {
            idioma = "dublado";
        } else if (optionIdioma == 2){
            idioma = "legendado";
        } else {
            System.out.println("Invalido");
            return;
        }

        System.out.println("Qual tipo do ingresso:");
        System.out.println("(1) Meia Entrada | (2) Ingresso Familia");
        optionIngresso = scanner.nextInt();

        if(optionIngresso > 2 || optionIngresso == 0){
            System.out.println("Opcao Invalida");
            return;
        }

        System.out.println("Quantos ingressos?");
        quantiaIngressos = scanner.nextInt();

        if(quantiaIngressos == 0){
            System.out.println("E necessario informar a quantidade de ingressos");
            return;
        }


        System.out.printf("Valor do Ingresso - R$%.2f\n", valorIngresso);

        System.out.println("======== RESUMO ========");
        if(optionIngresso == 1){
            filme.setNomeFilme(nomeFilme);
            filme.setQuantidadeIngressos(quantiaIngressos);
            filme.setValor(valorIngresso);
            filme.setIdioma(idioma);
            System.out.printf("%sx - Meia Entrada | %s (%s) | R$%.2f\n", filme.getQuantidadeIngressos(), filme.getNomeFilme(), filme.getIdioma(),filme.totalIngresso());
            System.out.printf("Desconto: R$%.2f\n", filme.desconto());
        } else if (optionIngresso == 2) {
            filme2.setNomeFilme(nomeFilme);
            filme2.setQuantidadeIngressos(quantiaIngressos);
            filme2.setValor(valorIngresso);
            filme2.setIdioma(idioma);
            System.out.printf("%sx - Ingresso Familia | %s (%s) | R$%.2f\n", filme2.getQuantidadeIngressos(), filme2.getQuantidadeIngressos(), filme2.getIdioma(), filme2.totalIngresso());
            System.out.printf("Desconto: R$%.2f\n", filme2.desconto());
        } else {
            System.out.println("Opcao Invalida");
            return;
        }
        System.out.println("========================");
    }
}