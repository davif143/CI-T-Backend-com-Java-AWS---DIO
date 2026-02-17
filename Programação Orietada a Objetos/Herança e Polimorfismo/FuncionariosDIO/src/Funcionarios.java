public abstract class Funcionarios {

    private String nome;
    private String email;
    private String senha;
    private boolean estaLogado;
    private boolean admin;
    
    public Funcionarios(){
      
    }
    
    public abstract void consultarVendas(Vendedor v);
    
    public void consultarDados(){
      System.out.printf("Nome: %s\n", this.getNome());
      System.out.printf("Email: %s\n", this.getEmail());
      System.out.printf("Senha: %s\n", this.getSenha());
      System.out.printf("Cargo: %s\n", this.getClass().getSimpleName());
    }
    
    public void realizarLogin(String email, String senha){
      if(email.equals(this.email) && senha.equals(this.senha)){
        System.out.println("Entrando na conta...");
        this.isEstaLogado(true);
      } else {
        System.out.println("Email ou senha invalidos!");
      }
    }
    
    public void realizarLogout(){
      if(this.getEstaLogado()){
        System.out.println("Saindo da conta...");
      } else {
        System.out.println("Operacao invalida");
      }
    }
    
    public void alterarDados(String nome, String email){
      if(!nome.equals(this.nome)){
        this.setNome(nome);
        System.out.println("Nome alterado com sucesso!");
      } else {
        System.out.println("Nome se mantem o mesmo");
      }
      
      if(!email.equals(this.email)){
        this.setEmail(email);
        System.out.println("Email alterado com sucesso!");
      } else {
        System.out.println("Email se mantem o mesmo");
      }
    }
    
    public void alterarSenha(String senha){
      if(senha.equals(this.senha)){
        System.out.println("Digite uma senha que nao seja a senha atual!");
      } else if(senha.length() < 8){
        System.out.println("A senha deve ter pelo menos 8 caracteres!");
      } else {
          System.out.println("Senha alterada com sucesso!");
          this.senha = senha;
      }
    }
    
    public void setNome(String nome) {
      this.nome = nome;
    }
    
    public String getNome(){
      return this.nome;
    }
    
    public void setEmail(String email) {
      this.email = email;
    }
    
    public String getEmail(){
      return this.email;
    }

    public void setSenha(String senha) {
      this.senha = senha;
    }
    
    public String getSenha(){
      return this.senha;
    }
    
    public void isAdmin(boolean admin){
      this.admin = admin;
    }
    
    public boolean getAdmin(){
      return this.admin;
    }
   
    public void isEstaLogado(boolean estaLogado){
      this.estaLogado = estaLogado;
    }
    
    public boolean getEstaLogado(){
      return this.estaLogado;
    }

}