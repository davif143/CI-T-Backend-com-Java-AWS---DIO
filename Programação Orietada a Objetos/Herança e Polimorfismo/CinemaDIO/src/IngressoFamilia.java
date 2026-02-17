public class IngressoFamilia extends Ingresso{

    @Override
    public double totalIngresso() {
        var valorIngresso = this.getQuantidadeIngressos() * this.getValor();
        var valorDesconto = valorIngresso * 0.05;
        return (this.getQuantidadeIngressos() >= 3) ? valorIngresso - valorDesconto : valorIngresso;

    }

    @Override
    public double desconto() {
        return (this.getQuantidadeIngressos() >= 3) ? (this.getValor() * this.getQuantidadeIngressos()) * 0.05 : 0.0;
    }
}
