public record Cultura (int quantidade, double valor) implements Produtos {

    @Override
    public double calcularImposto() {
        return (valor * quantidade) * 0.04;
    }

    @Override
    public double calcularValorTotal() {
        var imposto = calcularImposto();
        return (valor * quantidade) + imposto;
    }
}
