import java.util.*;

public class Main {
    public static void main(String[] args) {
      var gerente = new Gerencia();
      var vendedor = new Vendedor();
      var atendente = new Atendente();
      
      /*Dados abaixo serão utilizados como se fosse um banco de dados para poder operar no menu*/
      gerente.setNome("Carlos");
      vendedor.setNome("Maria");
      atendente.setNome("Joao");

      gerente.setEmail("Carlos@email.com");
      vendedor.setEmail("Maria@email.com");
      atendente.setEmail("Joao@email.com");
      
      gerente.setSenha("11111111");
      vendedor.setSenha("222222222");
      atendente.setSenha("333333333");
      /*-----------------------------------------*/
      System.out.println("====== Gerente =========");
      
          System.out.println("----- Teste Login/Logout com dados incorretos -----");
          gerente.realizarLogin("qualquer", "112312312");
          gerente.realizarLogout();
          System.out.println("---------------------------------------------------");
          
          System.out.println("----- Teste Login/Logout com dados corretos-----");
          gerente.realizarLogin("Carlos@email.com", "11111111");
          gerente.realizarLogout();
          System.out.println("---------------------------------------------------");
          
          System.out.println("----- Teste Alterar Dados com dados incorretos-----");
          gerente.alterarDados("Carlos", "Carlos@email.com");
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Alterar Dados com dados corretos-----");
          gerente.alterarDados("Vagner", "Vagner@email.com");
          System.out.println("---------------------------------------------------");
          
          System.out.println("----- Teste Alterar Senha com dado igual -----");
          gerente.alterarSenha("11111111");
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Alterar Senha com dado diferente -----");
          gerente.alterarSenha("222222222");
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Consultar Vendas de um Vendedor -----");
          gerente.consultarVendas(vendedor);
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Consulta de Dados do Usuario -----");
          gerente.consultarDados();
          System.out.println("---------------------------------------------------");  
          System.out.println("----- Teste Gerar Relatorio -----");
          gerente.gerarRelatorioFinanceiro();
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste: Verificar se e Administrator -----");
          System.out.printf("Admin: %s\n", (gerente.getAdmin()) ? "Sim" : "Nao");
          System.out.println("---------------------------------------------------");
          
      System.out.println("====== Vendedor =========");
      
          System.out.println("----- Teste Login/Logout com dados incorretos -----");
          vendedor.realizarLogin("qualquer", "112312312");
          vendedor.realizarLogout();
          System.out.println("---------------------------------------------------");
          
          System.out.println("----- Teste Login/Logout com dados corretos-----");
          vendedor.realizarLogin("Maria@email.com", "222222222");
          vendedor.realizarLogout();
          System.out.println("---------------------------------------------------");
          
          System.out.println("----- Teste Alterar Dados com dados incorretos-----");
          vendedor.alterarDados("Maria", "Maria@email.com");
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Alterar Dados com dados corretos-----");
          vendedor.alterarDados("Edurada", "CarloNovos@email.com");
          System.out.println("---------------------------------------------------");
          
          System.out.println("----- Teste Alterar Senha com dado igual -----");
          vendedor.alterarSenha("222222222");
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Alterar Senha com dado diferente -----");
          vendedor.alterarSenha("11111111");
          System.out.println("---------------------------------------------------");
          
          System.out.println("----- Teste Realizar Vendas -----");
          vendedor.realizarVendas();
          vendedor.realizarVendas();
          System.out.println("---------------------------------------------------");
    
          System.out.println("----- Teste Consultar Vendas -----");
          vendedor.consultarVendas(vendedor);
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Consulta de Dados do Usuario -----");
          vendedor.consultarDados();
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste: Verificar se e Administrator -----");
          System.out.printf("Admin: %s\n", (vendedor.getAdmin()) ? "Sim" : "Nao");
          System.out.println("---------------------------------------------------");

      System.out.println("====== Atendente =========");
          
          System.out.println("----- Teste Login/Logout com dados incorretos -----");
          atendente.realizarLogin("qualquer", "112312312");
          atendente.realizarLogout();
          System.out.println("---------------------------------------------------");
          
          System.out.println("----- Teste Login/Logout com dados corretos-----");
          atendente.realizarLogin("Joao@email.com", "333333333");
          atendente.realizarLogout();
          System.out.println("---------------------------------------------------");
          
          System.out.println("----- Teste Alterar Dados com dados incorretos-----");
          atendente.alterarDados("Joao", "Joao@email.com");
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Alterar Dados com dados corretos-----");
          atendente.alterarDados("Eduradao", "Joaquim@email.com");
          System.out.println("---------------------------------------------------");
          
          System.out.println("----- Teste Alterar Senha com dado igual -----");
          atendente.alterarSenha("333333333");
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Alterar Senha com dado diferente -----");
          atendente.alterarSenha("222222222");
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Consultar Vendas -----");
          atendente.consultarVendas(vendedor);
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Consulta de Dados do Usuario -----");
          atendente.consultarDados();
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Receber Pagamento invalido -----");
          atendente.receberPagamentos(0.0);
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Fechar Caixa zerado -----");
          atendente.fecharCaixa();
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Receber Pagamento correto -----");
          atendente.receberPagamentos(2310.0);
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste Fechar Caixa correto -----");
          atendente.fecharCaixa();
          System.out.println("---------------------------------------------------");
          System.out.println("----- Teste: Verificar se e Administrator -----");
          System.out.printf("Admin: %s\n", (atendente.getAdmin()) ? "Sim" : "Nao");
          System.out.println("---------------------------------------------------");
  }
}