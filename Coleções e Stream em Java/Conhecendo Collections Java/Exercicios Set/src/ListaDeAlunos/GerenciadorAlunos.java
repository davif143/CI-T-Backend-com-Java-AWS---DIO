package ListaDeAlunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos{

    Set<Aluno> alunos = new HashSet<>();

    public void adicionarAluno(String nome, long matricula, double media){
        alunos.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
        if(!alunos.isEmpty()){
            for(Aluno a : alunos){
                if(a.getMatricula() == matricula){
                    alunos.remove(a);
                    return;
                }
            }
        } else {
            System.out.println("Nenhum aluno encontrado!");
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        return new TreeSet<>(alunos);
    }

    public Set<Aluno> exibirAlunosPorNota(){
        var listaAlunosNota = new TreeSet<>(new CompararPorNota());
        listaAlunosNota.addAll(alunos);
        return listaAlunosNota;
    }

    public void exibirAlunos(){
        System.out.println("========= ALUNOS =========");
        for(Aluno a : alunos){
            System.out.println(a);
        }
        System.out.println("==========================");
    }
}

