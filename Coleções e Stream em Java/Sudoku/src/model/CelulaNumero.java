package model;

public class CelulaNumero {

    private Integer numero;
    private final int numeroEsperado;
    private final boolean status;

    public CelulaNumero(final int numeroEsperado, final boolean status) {
        this.numeroEsperado = numeroEsperado;
        this.status = status;
        if(status) numero = numeroEsperado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getNumeroEsperado() {
        return numeroEsperado;
    }

    public boolean isStatus() {
        return status;
    }

    public void limparCelula(){
        if(!status) setNumero(null);
    }
}
