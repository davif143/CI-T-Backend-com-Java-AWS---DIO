public class ContaBancaria {

    private double saldo;
    private double limiteChequeEspecial;
    private boolean chequeEspecial;
    private final Pessoa pessoa;

    public ContaBancaria(double saldo, Pessoa pessoa) {
        calcularChequeEspecial(saldo);
        chequeEspecial = false;
        this.saldo = saldo;
        this.pessoa = pessoa;
    }

    private void calcularChequeEspecial(double deposito){
        limiteChequeEspecial = (deposito <= 500.0) ? 50.0 : deposito * 0.5;
    }

    public void consultarChequeEspecial(){
        System.out.println("===== CHEQUE ESPECIAL =====");
        System.out.printf("R$%s\n", limiteChequeEspecial);
        System.out.println("===========================");
    }

    public void utilizandoChequeEspecial(){
        if((saldo + limiteChequeEspecial) <= limiteChequeEspecial) chequeEspecial = true;
        System.out.printf("Sua conta %s utilizando o cheque especial!\n",(chequeEspecial) ? "está" : "não está");
    }

    public void sacarDinheiro(double saque){
        if(saque > saldo) {
            System.out.println("Saldo insuficiente!");
        } else if(saque <= 0){
            System.out.println("Valor inválido, informe outro valor");
        } else {
            saldo -= saque;
            System.out.println("Saque realizado com sucesso!");
        }
    }

    public void consultarSaldo(){
        System.out.println("======= SALDO =======");
        System.out.println("R$" + (saldo));
        System.out.println("=====================");
    }

    public void pagarBoleto(double valorBoleto){
        if(valorBoleto > (saldo + limiteChequeEspecial)){
            System.out.println("Saldo insuficiente");
        } else if (valorBoleto <= 0){
            System.out.println("Boleto inválido");
        } else {
            saldo -= valorBoleto;
            if(saldo <= limiteChequeEspecial){
                var valorUtilizado = (saldo * (-1));
                var juros =  valorUtilizado * 0.2;
                //saldo -= limiteChequeEspecial;
                saldo -= juros;
                chequeEspecial = true;
                System.out.println("Você esta utilizando o cheque especial");
                System.out.println("Valor utilizado: R$" + valorUtilizado);
                System.out.println("Juros aplicado: R$" + juros);
                System.out.println("Total: R$" + (juros + valorUtilizado));
                System.out.println("Saldo atual: R$" + saldo);
                consultarChequeEspecial();
            }
            System.out.println("Pagamento realizado com sucesso!");
        }
    }

    public void deposito(double valorDeposito){
        if(valorDeposito <= 0) {
            System.out.println("Valor inválido");
            return;
        }

        if(saldo <= 0) {
            chequeEspecial = false;
        }
        saldo += valorDeposito;
        System.out.println("Saldo atual: R$" + saldo);
    }

    public double getSaldo() {
        return saldo;
    }

}
