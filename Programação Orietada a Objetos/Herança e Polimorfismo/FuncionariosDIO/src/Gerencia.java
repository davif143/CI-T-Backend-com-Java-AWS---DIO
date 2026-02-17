public final class Gerencia extends Funcionarios{
  
    public Gerencia(){
      this.isAdmin(true);
    }
    
    @Override
    public void consultarVendas(Vendedor vendedor){
      System.out.printf("Vendedor: %s\n", vendedor.getNome());
      System.out.printf("Vendas Realizadas: %s\n", vendedor.getQuantidadeVendas());
    }
    
    public void gerarRelatorioFinanceiro(){
      System.out.println("Gerando relatorio...");
    }

}