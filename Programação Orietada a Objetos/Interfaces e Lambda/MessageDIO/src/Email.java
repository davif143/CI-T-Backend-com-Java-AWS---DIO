public record Email(String mensagem, String email) implements  SenderMessage{
    @Override
    public void enviarMensagem() {
        System.out.printf("Para: %s \nMensagem: %s\n", email, mensagem);
        System.out.println("Mensagem enviada por E-mail");
    }
}
