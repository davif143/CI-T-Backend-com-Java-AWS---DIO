package CatalogoDeLivros;

public class Livro {
    private final String nome;
    private final String autor;
    private final int anoDePublicacao;

    public Livro(String nome, String autor, int anoDePublicacao) {
        this.nome = nome;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    @Override
    public String toString() {
        return "Titulo: %s| Autor: %s| Ano: %s".formatted(nome, autor, anoDePublicacao);
    }
}
