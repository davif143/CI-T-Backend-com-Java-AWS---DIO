public record SMS(String mensagem, String contato) implements SenderMessage {

    @Override
    public void enviarMensagem() {
        System.out.printf("Para: %s \nMensagem: %s\n", contato, mensagem);
        System.out.println("Mensagem enviada por SMS");
    }

}
