package ListaDeTarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {

    private final List<Tarefa> listaTarefas;

    public ListaTarefas() {
        this.listaTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String tarefa){
        listaTarefas.add(new Tarefa(tarefa));
    }

    public void removerTarefa(String tarefa){
        List<Tarefa> listTemp = new ArrayList<>();
        if(!listaTarefas.isEmpty()){
           for(Tarefa t : listaTarefas){
               if(t.getDescricao().equalsIgnoreCase(tarefa))
                   listTemp.add(t);
           }
        }
        listaTarefas.removeAll(listTemp);
    }

    public int obterNumeroTotalTarefas(){
        return listaTarefas.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(listaTarefas);
    }


}
