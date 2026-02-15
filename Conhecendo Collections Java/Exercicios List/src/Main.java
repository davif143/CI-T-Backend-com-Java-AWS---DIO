import CatalogoDeLivros.Biblioteca;

public class Main {
    public static void main(String[] args) {

        var biblioteca = new Biblioteca();

        biblioteca.adicionarLivros("Livro 1", "Eu", 2020);
        biblioteca.adicionarLivros("Livro 1", "Eu", 2020);
        biblioteca.adicionarLivros("Livro 2", "Ela", 2022);
        biblioteca.adicionarLivros("Livro 5", "Ela", 2025);
        biblioteca.adicionarLivros("Livro 3", "Ele", 2012);

        System.out.println(biblioteca.pesquisarPorAutor("Ela"));
        System.out.println(biblioteca.pesquisarPorIntervalosAno(2012,2020));
        System.out.println(biblioteca.pesquisarPorTitulo("Livro 1"));


    }
}