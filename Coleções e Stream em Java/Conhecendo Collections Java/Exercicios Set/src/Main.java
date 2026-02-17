import ListaDeAlunos.GerenciadorAlunos;
import ListaDeTarefas.ListaDeTarefas;

public class Main {
    public static void main(String[] args) {

        var gerenciarAlunos = new GerenciadorAlunos();

        gerenciarAlunos.adicionarAluno("Miguel", 1224342L, 9);
        gerenciarAlunos.adicionarAluno("Davi", 12312L, 3);
        gerenciarAlunos.adicionarAluno("Julia", 12123L, 9);
        gerenciarAlunos.adicionarAluno("Davi", 12123L, 5);
        gerenciarAlunos.adicionarAluno("Nicolas", 1242342L, 7);

        gerenciarAlunos.exibirAlunos();

        gerenciarAlunos.removerAluno(12123);
        gerenciarAlunos.exibirAlunos();

        System.out.println(gerenciarAlunos.exibirAlunosPorNome());
        System.out.println(gerenciarAlunos.exibirAlunosPorNota());
    }
}