package ListaDeTarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaDeTarefas {

    Set<Tarefa> listaTarefa;

    public ListaDeTarefas() {
        this.listaTarefa = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        listaTarefa.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        for(Tarefa t : listaTarefa){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                listaTarefa.remove(t);
                System.out.println("Tarefa removida com sucesso!");
                return;
            }
        }
        System.out.println("Tarefa nao encontrada!");
    }

    public void exibirTarefa(){
        System.out.println("========= TAREFAS =========");
        for(Tarefa t : listaTarefa){
            System.out.println(t);
        }
        System.out.println("========= (fim) =========");
    }

    public int contarTarefas(){
        return listaTarefa.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        var tarefasConcluidas = new HashSet<Tarefa>();

        for(Tarefa t : listaTarefa){
            if(t.isStatus()){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        var tarefasPendente = new HashSet<Tarefa>();

        for(Tarefa t : listaTarefa){
            if(!t.isStatus()){
                tarefasPendente.add(t);
            }
        }
        return tarefasPendente;
    }

    public void marcarTarefaConcluida(String descricao){
        var tarefa = findBy(descricao);
        if(tarefa != null){
            tarefa.setStatus(true);
            System.out.println("Tarefa marcada como concluida!");
        }
    }

    public void marcarTarefaPendente(String descricao){
        var tarefa = findBy(descricao);
        if(tarefa != null){
            tarefa.setStatus(false);
            System.out.println("Tarefa marcada como pendente!");
        }
    }

    public void limparListaTarefas(){
        listaTarefa.clear();
    }

    public Tarefa findBy(String descricao){
        if(!listaTarefa.isEmpty()){
            for(Tarefa i : listaTarefa){
                if(i.getDescricao().equalsIgnoreCase(descricao)){
                    return i;
                }
            }
        }
        return null;
    }

}
