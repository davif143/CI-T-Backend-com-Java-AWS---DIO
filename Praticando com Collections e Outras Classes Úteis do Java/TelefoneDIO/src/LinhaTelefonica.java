public enum LinhaTelefonica {

    TELEFONE_FIXO(10, 13),
    CELULAR(11, 14);

    private final int tamanhoMin;
    private final int tamanhoMax;

    LinhaTelefonica(int tamanho, int tamFormatado){
        this.tamanhoMin = tamanho;
        this.tamanhoMax = tamFormatado;
    }

    public int getTamanhoMin() {
        return tamanhoMin;
    }

    public int getTamanhoMax() {
        return tamanhoMax;
    }


}

