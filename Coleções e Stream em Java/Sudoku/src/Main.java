import model.CelulaNumero;
import model.StatusJogoEnum;
import model.Tabuleiro;
import util.TabuleiroTemplate;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static int LIMITE_TABULEIRO = 9;
    public static Tabuleiro tabuleiro;
    public static StatusJogoEnum status = StatusJogoEnum.NAO_INICIADO;
    public static Scanner scanner = new Scanner(System.in);
    public static int linha, col, op = -1;
    public static Integer num;


    /// input args[] -> (x,y;z,b)
    /// Exemplo: 7:3;7,false
    ///
    /// (x,y) -> posição - linha x coluna
    ///
    /// z ->  numero à ser adicionado
    ///
    /// b -> boolean indicando se é um numero fixo ou não. Se não for será atribuido como numero esperado.

    public static void main(String[] args) {
        var mapaTabuleiro = Stream.of(args).collect(toMap(
                k -> k.split(";")[0],
                v -> v.split(";")[1]
        ));

        System.out.println("========= Sudoku =========");
        do{
            if(status == StatusJogoEnum.NAO_INICIADO){
                do{
                    System.out.println("0 - Iniciar jogo");
                    status = StatusJogoEnum.INCOMPLETO;
                    op = scanner.nextInt();
                } while(op != 0);
            } else if(status == StatusJogoEnum.INCOMPLETO){
                System.out.println("1 - Inserir Numero");
                System.out.println("2 - Remover Numero");
                System.out.println("3 - Verificar Jogo");
                System.out.println("4 - Verificar Status do Jogo");
                System.out.println("5 - Limpar");
                System.out.println("6 - Finalizar");
                System.out.println("7 - sair");

                op = scanner.nextInt();
            }

            switch (op){
                case 0 -> criarJogo(mapaTabuleiro);
                case 1 -> {
                    inputDados();
                    tabuleiro.inserirNumero(linha,col,num);
                }
                case 2 -> {
                    inputDados();
                    tabuleiro.removerNumero(linha,col);
                }
                case 3 -> mostrarJogo(tabuleiro);
                case 4 -> verificarStatusSudoku();
                case 5-> tabuleiro.resetTabuleiro();
                case 6 -> {
                    if(tabuleiro.isComplete()) {
                        System.out.println("Parabens, jogo esta completo");
                        System.exit(0);
                    } else System.out.println("Jogo incompleto!");
                }
                case 7 -> {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
                default -> System.out.println("Opcao Invalida");
            }

        } while(status != StatusJogoEnum.COMPLETO);
    }

    public static void inputDados(){
        while(true){
            System.out.println("Informe a coluna correspondente: ");
            col = scanner.nextInt();
            if(col < 0 || col > LIMITE_TABULEIRO) {
                System.out.println("Informe uma linha valida");
                continue;
            }

            System.out.println("Informe a linha correspondente: ");
            linha = scanner.nextInt();
            if(linha < 0 || linha > LIMITE_TABULEIRO) {
                System.out.println("Informe uma linha valida");
                continue;
            }

            //verificando se a solicitacao e para Inserir Numero
            if(op == 1){
                System.out.println("Informe qual o numero (1 - 9): ");
                num = scanner.nextInt();

                if (((num <= 0 || num > 9))) {
                    System.out.println("Informe um numero valido!");
                } else return;
            }
            //Verificando se a solicitacao e para Remover Numero
            else return;
        }
    }

    public static void verificarStatusSudoku(){
        if(tabuleiro.temErro()){
            System.out.println("O jogo contem erros! Verifique os campos");
        } else {
            System.out.println("O jogo nao contem erros!");
        }
    }

    public static void mostrarJogo(Tabuleiro tab){
        var listaValores = new ArrayList<>();
        for (int i = 0; i < LIMITE_TABULEIRO; i++) {
            for (int j = 0; j < LIMITE_TABULEIRO; j++) {
                var tempNum = tab.getCelulas().get(j).get(i).getNumero();
                listaValores.add(" " + ((tempNum == null) ? " " : tempNum));
            }
        }

        var result = TabuleiroTemplate.TEMPLATE_TABULERIO.formatted(listaValores.toArray());
        System.out.println(result);
    }

    public static void criarJogo(Map<String,String> posicoesTabuleiro){
        List<List<CelulaNumero>> posicoes = new ArrayList<>();

        for (int i = 0; i < LIMITE_TABULEIRO; i++) {
            posicoes.add(new ArrayList<>());
            for (int j = 0; j < LIMITE_TABULEIRO; j++) {
                //pega a chave k do Map
                var posicao = posicoesTabuleiro.get("%s,%s".formatted(i,j));
                //pega o numero em v do Map
                var numeroEsperado = Integer.parseInt(posicao.split(",")[0]);
                //pega o boolean em v do Map
                var status = Boolean.parseBoolean(posicao.split(",")[1]);
                //cria a celula
                var celulaAtual = new CelulaNumero(numeroEsperado,status);
                posicoes.get(i).add(celulaAtual);
            }
        }
        tabuleiro = new Tabuleiro(posicoes);
    }

}