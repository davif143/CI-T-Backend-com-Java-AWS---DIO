import java.util.Scanner;

public class Main {
    static Carro veiculo = new Carro();
    static Scanner scanner = new Scanner(System.in);
    static int option;

    /*
    Função principal do programa, será utilizada como o painel do nosso veículo.
    Inicialmente o veículo é inicializado como desligado |status = false|, parado |velocidade = 0|
    e em ponto morto |marcha = 0|.

    Para ter acesso ao paínel é preciso ligar o veículo, após isso será disponibilizado todas as funções
    do veículo como:

    |Acelerar e Desacelerar| |Verificar Velocidade| |Trocar Marcha| |Mudar a direção| |Desligar o Veículo|
    * */

    public static void main(String[] args) {


        System.out.println("Entrando no veiculo...");

        do{
            if(!veiculo.getStatus()) {
                System.out.println("1 - Ligar veículo");
                System.out.println("0 - Sair do veiculo");
                option = scanner.nextInt();
                if ((option == 1)) {
                    ligarVeiculo();
                } else {
                    System.out.println("Opcao invalida");
                }
            } else {
                System.out.println("1 - Acelerar");
                System.out.println("2 - Diminuir Velocidade");
                System.out.println("3 - Mudar de Direcao");
                System.out.println("4 - Verificar Velocidade");
                System.out.println("5 - Trocar Marcha");
                System.out.println("6 - Desligar Veiculo");

                option = scanner.nextInt();

                switch (option){
                    case 1 -> acelerarVeiculo();
                    case 2 -> desacelerarVeiculo();
                    case 3 -> {
                        System.out.println("Informe qual direcao irá virar");
                        System.out.println("Esquerda | Direita");
                        scanner.nextLine();
                        var algo = scanner.nextLine();
                        virarVeiculo(algo);
                    }
                    case 4 -> verificarVelocidade();
                    case 5 -> {
                        System.out.printf("\nMarcha atual: %s\n", veiculo.getMarcha());
                        System.out.println("Informe para qual marcha vai mudar:");
                        var optionMarcha = scanner.nextInt();

                        mudarMarcha(optionMarcha);
                    }
                    case 6 -> desligarVeiculo();
                    default -> System.out.println("Opcao invalida");
                }
            }
        } while(option != 0);

        System.out.println("Saindo do veiculo...");
        System.exit(0);
    }

    /*
    Função utilizada para ligar o veículo. Mudamos o status do veículos para |true| e retornamos
    para o menu principal do veículo.
    * */

    public static void ligarVeiculo(){
        System.out.println("Ligando veiculo...");
        veiculo.setStatus(true);
    }

    /*
    Função utilizada para desligar o veículo.
    Nesta função é confirmado se o veículo ainda está parado (velocidade = 0) e em
    ponto morto (marcha = 0). Caso esteja torna o status do veiculo |false| e quebra o looping
    do while, informando que o usuario "saiu" do veículo.
    * */

    public static void desligarVeiculo(){
        if (veiculo.getVelocidade() != 0) {
            System.out.println("Nao eh possivel desligar o veiculo em movimento");
        } else {
            if(veiculo.getVelocidade() == 0 && veiculo.getMarcha() == 0){
                System.out.println("Desligando veiculo...");
                veiculo.setStatus(false);
            } else {
                System.out.println("E preciso que o veiculo esteja em ponto morto (marcha 0) para ser desligado!");
            }
        }
    }

    /*
    Função utilizada para acelerar o veículo.
    Irá verificar inicialmente se o valor da veículo já atingiu o limite máximo que o veiculo pode
    chegar (120 km/h). Após é através de uma função complementar, é verificado se a partir da marcha
     e velocidade atual é possível realizar a aceleração do veículo.
    * */

    public static void acelerarVeiculo(){
        if (veiculo.getVelocidade() <= 120) {
            int velocidadeVeiculo = veiculo.getVelocidade();
            int marchaVeiculo = veiculo.getMarcha();

            if(marchaVeiculo == 0){
                System.out.println("Veiculo em ponto morto, mude a marcha!");
                return;
            }

            if(velocidadePorMarcha(velocidadeVeiculo,marchaVeiculo)) {
                System.out.println("Acelerando veiculo...");
                veiculo.setVelocidade(velocidadeVeiculo + 1);
                verificarVelocidade();
            } else {
                verificarVelocidade();
                System.out.println("Limite de velocidade da marcha atingido!");
                System.out.println("Mude a marcha!");
            }
        } else System.out.println("Velocidade maxima atingida!");
    }

    /*
    Função complementar para verificar se é possível acelerar o veículo a partir da velocidade
    permitida para cada marcha. Caso a sentença seja |true| será possível realizar a aceleração,
    caso contrário retornará |false| e será solicitado a troca da marcha.
    * */

    public static boolean velocidadePorMarcha(int velocidade, int marcha){
        switch(marcha){
            case 1 -> {
                return velocidade >= 0 && velocidade < 20;
            }
            case 2 -> {
                return velocidade >= 20 && velocidade < 40;
            }
            case 3 -> {
                return velocidade >= 40 && velocidade < 60;
            }
            case 4 -> {
                return velocidade >= 60 && velocidade < 80;
            }
            case 5 -> {
                return velocidade >= 80 && velocidade < 100;
            }
            case 6 -> {
                return velocidade >= 100  && velocidade < 120;
            }
            default -> {
                return false;
            }
        }
    }

    /*
    Função complementar para confirmar a mudança de subida de marcha a partir da velocidade
    máxima permitida para cada marcha.
    * */

    public static boolean confirmarMudancaMarchaAcelerar(int velocidade, int marcha){
        switch(marcha){
            case 0 -> {
                return velocidade == 0;
            }
            case 1 -> {
                return velocidade == 20;
            }
            case 2 -> {
                return velocidade == 40;
            }
            case 3 -> {
                return velocidade == 60;
            }
            case 4 -> {
                return velocidade == 80;
            }
            case 5 -> {
                return velocidade == 100;
            }
            case 6 -> {
                return velocidade == 120;
            }
            default -> {
                return false;
            }
        }
    }

    /*
    Função complementar para confirmar a mudança de descida de marcha a partir da velocidade
    mínima permitida para cada marcha.
    * */

    public static boolean confirmarMudancaMarchaDesacelerar(int velocidade, int marcha){
        switch(marcha){
            case 1 -> {
                return velocidade == 0;
            }
            case 2 -> {
                return velocidade == 20;
            }
            case 3 -> {
                return velocidade == 40;
            }
            case 4 -> {
                return velocidade == 60;
            }
            case 5 -> {
                return velocidade == 80;
            }
            case 6 -> {
                return velocidade == 100;
            }
            default -> {
                return false;
            }
        }
    }

    /*
    Função complementar utilizada para verificar se a velocidade atual corresponde a velocidade mínima
    da marcha atua. Caso seja a mínima a função retorna |true| e será solicitado que o usúario reduza a
    marcha. Caso contrário, será retornado |false| e será possível reduzir a velocidade.
    * */

    public static boolean velocidadePorMarchaDesacelerar(int velocidade, int marcha){
        switch(marcha){
            case 1 -> {
                return velocidade == 0;
            }
            case 2 -> {
                return velocidade == 20;
            }
            case 3 -> {
                return velocidade == 40;
            }
            case 4 -> {
                return velocidade == 60;
            }
            case 5 -> {
                return velocidade == 80;
            }
            case 6 -> {
                return velocidade == 100;
            }
            default -> {
                return false;
            }
        }
    }

    /*
    Função utilizada para desacelerar o veículo.
    Será verificado incialmente se o veículo esta parado, caso não esteja utilizamos de outra função
    complementar (|velocidadePorMarchaDesacelerar|) para verificar se é possivel reduzir a velocidade a partir da velocidade suportada
    pela marcha atual. Caso a velocidade atual seja a minima da marcha atual, será necessário reuzir
    a marcha para poder diminuir a velocidade.
    * */

    public static void desacelerarVeiculo(){
        if (veiculo.getVelocidade() > 0) {
            int velocidade2 = veiculo.getVelocidade();
            int marchaVeiculo = veiculo.getMarcha();

            if(velocidadePorMarchaDesacelerar(velocidade2,marchaVeiculo)){
                System.out.println("Velocidade muito baixa para a marcha atual, mude a marcha");
            } else {
                System.out.println("Desacelerando Veiculo...");
                veiculo.setVelocidade(velocidade2 - 1);
                verificarVelocidade();
            }

        } else System.out.println("Veículo nao esta em movimento!");
    }

    /*
    Função utilizada para realizar as trocas de marchas do veículo, sejam subindo ou descendo as marchas.
    O usúario irá informar a marcha desejada, e será verificado se a marcha esta na capacidade maxima
    do veículo (6 marchas). Caso esteja será verificado se ele está pulando as marchas (Ex: 1 marcha para 3), seja
    subindo ou descendo a marcha.

    Caso não estejam pulando marcha é verificado se ao subirmos ou descermos em uma a marcha atual no veículo,
    se ela será igual a marcha desejada pelo usúario.
    * */

    public static void mudarMarcha(int mudancaMarcha){
        int marcha = veiculo.getMarcha();
        int velocidadeVeiculo = veiculo.getVelocidade();


        if (mudancaMarcha <= 6) {
            if(mudancaMarcha > veiculo.getMarcha()+2){
                System.out.printf("Nao eh possivel trocar para %s, pois o veiculo esta na %s marcha\n",
                        mudancaMarcha, veiculo.getMarcha());
                return;
            }

            if (mudancaMarcha == (veiculo.getMarcha() + 1)){

                if(confirmarMudancaMarchaAcelerar(velocidadeVeiculo,marcha)){
                    veiculo.setMarcha(marcha + 1);
                    System.out.printf("Trocando para %s marcha...\n", veiculo.getMarcha());
                } else {
                    System.out.println("Nao eh possivel trocar a marcha ainda, acelere mais um pouco!");
                }
            } else if(mudancaMarcha == (veiculo.getMarcha() - 1)){

                if (confirmarMudancaMarchaDesacelerar(velocidadeVeiculo,marcha)){
                    veiculo.setMarcha(marcha - 1);
                    System.out.printf("Trocando para %s marcha...\n", veiculo.getMarcha());
                } else {
                    System.out.println("Nao eh possivel trocar a marcha ainda, reduza um pouco a velocidade!");
                }
            } else if(mudancaMarcha <= veiculo.getMarcha() - 2){
                    System.out.printf("Nao eh possivel trocar para %s, pois o veiculo esta na %s marcha\n",
                        mudancaMarcha, veiculo.getMarcha());
            }

        } else {
            System.out.println("O veiculo nao possui essa marcha!");
        }
    }
    /*Função que irá receber um sentido (esquerda ou direita) informado pelo usúario e irá verificar
      se é possivel virar para tal direção, levando em consideração o limite de velocidade maximo que é
      de 40km. Caso ultrapasse esse valor o usúario será informado para reduzir a velocidade para poder
      virar o veiculo

      É realizado também uma verificação para caso o usúario preencha com outra direção ou texto diferente
      do permitido.
      */
    public static void virarVeiculo(String sentido){
        if(!(sentido.equalsIgnoreCase("direita") || sentido.equalsIgnoreCase("esquerda"))){
            System.out.println("Direcao invalida");
            return;
        }
        if (veiculo.getVelocidade() <= 40) {
            if (veiculo.getVelocidade() >= 1){
                System.out.printf("Virando para %s....\n", sentido);
            } else {
                System.out.println("O veiculo esta parado!");
            }
        } else {
            System.out.printf("Nao eh possivel virar para %s, pois estamos a %s km. Reduza a velocidade!\n",
                    sentido, veiculo.getVelocidade());
        }
    }


    /*Função utilizada para informar a velocidade e marcha atual do veículo */
    public static void verificarVelocidade(){
        System.out.println("=============================");
        System.out.printf("Marcha atual: %s\n", veiculo.getMarcha());
        System.out.printf("Veiculo esta a %s km...\n", veiculo.getVelocidade());
        System.out.println("=============================");
    }

}