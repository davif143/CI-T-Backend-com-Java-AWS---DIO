public class Vendedor extends Funcionarios{

    private int quantidadeVendas;
    
    public Vendedor(){
      this.isAdmin(false);
    }
    
    public void realizarVendas(){
      System.out.println("Venda realizada com sucesso!");
      var venda = this.getQuantidadeVendas() + 1;
      this.setQuantidadeVendas(venda);
    }
    
    @Override
    public void consultarVendas(Vendedor vendedor){
      System.out.printf("Vendas realizadas: %s\n", vendedor.getQuantidadeVendas());
    }
    
    public void setQuantidadeVendas(int quantidadeVendas) {
      this.quantidadeVendas = quantidadeVendas;
    }
    
    public int getQuantidadeVendas(){
      return this.quantidadeVendas;
    }

}