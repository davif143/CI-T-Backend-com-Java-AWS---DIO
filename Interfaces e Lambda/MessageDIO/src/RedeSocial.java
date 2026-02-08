public record RedeSocial(String mensagem, String contato) implements SenderMessage {
    @Override
    public void enviarMensagem() {
        System.out.printf("Para: %s \nMensagem: %s\n", contato, mensagem);
        System.out.println("Mensagem enviada pela Rede Social");
    }
}
