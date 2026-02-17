package ListaDeAlunos;

import java.util.Comparator;

public class CompararPorNota implements Comparator<Aluno> {
    @Override
    public int compare(Aluno a1, Aluno a2) {
        return Double.compare(a2.getNota(),a1.getNota());
    }
}
