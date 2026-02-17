public class Atendente extends Funcionarios{

    private double valorEmCaixa;

    public Atendente(){
      this.isAdmin(false);
    }
    
    @Override
    public void consultarVendas(Vendedor vendedor){
      System.out.println("Acesso negado!");
    }
    
    public void receberPagamentos(double valor){
      if(valor == 0){
        System.out.println("Informe um valor maior que 0");
        return;
      }
      
      var caixa = this.getValorEmCaixa();
      caixa += valor;
      this.setValorEmCaixa(caixa);
      
      System.out.printf("R$%.2f recebido com sucesso!\n", valor);
    }
    
    public void fecharCaixa(){
      if(this.getValorEmCaixa() == 0){
        System.out.println("Todo dinheiro do caixa ja foi retirado");
        return;
      }
      
        System.out.printf("Dinheiro em caixa: R$%.2f\n", this.getValorEmCaixa());
        System.out.println("Retirando dinheiro....");
        System.out.println("Dinheiro retirado!");
        System.out.println("Fechando caixa...");    
    }
    
    public void setValorEmCaixa(double valorEmCaixa) {
      this.valorEmCaixa = valorEmCaixa;
    }
    
    public double getValorEmCaixa(){
      return this.valorEmCaixa;
    }

}