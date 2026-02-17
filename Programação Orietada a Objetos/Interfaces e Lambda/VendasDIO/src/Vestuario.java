public record Vestuario (int quantidade, double valor) implements Produtos {

    @Override
    public double calcularImposto() {
        return (valor * quantidade) * 0.025;
    }

    @Override
    public double calcularValorTotal() {
        var imposto = calcularImposto();
        return (valor * quantidade) + imposto;
    }
}
