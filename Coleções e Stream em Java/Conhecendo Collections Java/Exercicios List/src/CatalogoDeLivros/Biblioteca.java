package CatalogoDeLivros;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    List<Livro> catalogo = new ArrayList<>();

    public void adicionarLivros(String titulo, String autor, int ano){
        var livro = findBy(titulo, autor);

        if(livro != null){
            System.out.println("Livro já foi adicionado a lista");
            return;
        }
        catalogo.add(new Livro(titulo, autor, ano));
    }

    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> listTemp = new ArrayList<>();
        for(Livro i : catalogo){
            if(i.getAutor().equalsIgnoreCase(autor)){
                listTemp.add(i);
            }
        }
        return listTemp;
    }

    public List<Livro> pesquisarPorIntervalosAno(int anoInicial, int anoFinal){
        List<Livro> listTemp = new ArrayList<>();
        for(Livro i : catalogo){
            if(i.getAnoDePublicacao() >= anoInicial &&
                    i.getAnoDePublicacao() <= anoFinal){
                listTemp.add(i);
            }
        }
        return listTemp;
    }

    public Livro pesquisarPorTitulo(String titulo){
        for(Livro i : catalogo){
            if(i.getNome().equalsIgnoreCase(titulo)){
                return i;
            }
        }
        return null;
    }

    private Livro findBy(String nome, String autor){
        for(Livro i : catalogo){
            if(i.getNome().equalsIgnoreCase(nome) &&
                    i.getAutor().equalsIgnoreCase(autor)){
                return i;
            }
        }
        return null;
    }

}
