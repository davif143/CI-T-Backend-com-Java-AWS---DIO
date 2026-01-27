public class MeiaEntrada extends Ingresso{

    @Override
    public double totalIngresso() {
        return (this.getValor() / 2) * this.getQuantidadeIngressos();
    }

    @Override
    public double desconto() {
        return (this.getValor() / 2) * this.getQuantidadeIngressos();
    }
}
