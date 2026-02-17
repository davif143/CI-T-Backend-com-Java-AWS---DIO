package model;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Tabuleiro {
    /// List<List<>> = Colunas
    ///
    ///  List<model.CelulaNumero> = Linhas
    private List<List<CelulaNumero>> celulas;

    public Tabuleiro(List<List<CelulaNumero>> celulas) {
        this.celulas = celulas;
    }

    public List<List<CelulaNumero>> getCelulas() {
        return celulas;
    }

    public void inserirNumero(int linha, int coluna, Integer numero){
        var tempCelula = celulas.get(coluna).get(linha);
        if(!tempCelula.isStatus()){
            if(tempCelula.getNumero() != null){
                System.out.printf("Posicao [%s,%s] ja possui um digito\n", coluna,linha);
            }else tempCelula.setNumero(numero);
        }else {
            System.out.printf("Posicao [%s,%s] possui um valor fixo, nao pode ser preenchida!\n", coluna,linha);
        }
    }

    private boolean verifyCleaner(){
        Scanner scanner = new Scanner(System.in);
        int op;
        while(true){
            System.out.println("Tem certeza que quer limpar os campos?\nTodos os digitos serao perdidos!");
            System.out.println("(1) Sim | (2) Nao");
            op = scanner.nextInt();
            if(op < 1 || op > 2) {
                System.out.println("Informe uma opcao valida!");
            } else break;
        }
        return op == 1;
    }

    public void removerNumero(int linha, int coluna) {
        var tempCelula = celulas.get(coluna).get(linha);
        if (!tempCelula.isStatus()){
            if(tempCelula.getNumero() == null){
                System.out.println("Campo vazio");
            } else {
                tempCelula.limparCelula();
                System.out.println("Removido com sucesso!");
            }
        } else System.out.println("Nao pode ser removido");
    }

    public StatusJogoEnum getStatus() {
        /* Para cada linha e coluna do tabuleiro, verificar se há alguma posição tenha um
         numero fixo e seja diferente de nulo. Se não for encontrado nenhum, o jogo ainda não foi iniciado*/
        if (celulas.stream().flatMap(Collection::stream).noneMatch(c -> !c.isStatus() && nonNull(c.getNumero()))) {
            return StatusJogoEnum.NAO_INICIADO;
        }
        //Para cada linha e coluna do tabuleiro, verificar se em alguma posição o valor seja 'nulo'. Se houver, então o jogo
        //esta incompleto, se não já esta completo
        return (celulas.stream().flatMap(Collection::stream).anyMatch(c -> isNull(c.getNumero()))) ? StatusJogoEnum.INCOMPLETO : StatusJogoEnum.COMPLETO;
    }

    public boolean temErro() {
        //Verificar se o jogo ja foi Iniciado
        if(getStatus() == StatusJogoEnum.NAO_INICIADO) return false;

        //Se o jogo já foi Iniciado, verificar se há alguma posição em que o numero contido nela seja diferente de nulo
        //e esse numero é diferente do numero esperado/resposta. Se sim, o tabuleiro contém algum erro. Se não, não contém erros
        return celulas.stream().flatMap(Collection::stream).anyMatch(c -> nonNull(c.getNumero()) && !c.getNumero().equals(c.getNumeroEsperado()));
    }

    public boolean isComplete(){
        return !temErro() && getStatus().equals(StatusJogoEnum.COMPLETO);
    }

    public void resetTabuleiro(){
        if(verifyCleaner()) {
            celulas.forEach(c -> c.forEach(CelulaNumero::limparCelula));
            System.out.println("Sudoku resetado com sucesso!");
        }
    }

}
