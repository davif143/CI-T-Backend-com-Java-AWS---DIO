import java.util.Scanner;

public class Main {

    static String message, contato;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        SenderMessage senderMessage = null;
        int option;

        do {
            System.out.println("Escolha onde mandar a mensagem:");
            System.out.println("1 - SMS");
            System.out.println("2 - Email");
            System.out.println("3 - WhatsApp");
            System.out.println("4 - Rede Social");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            scanner.nextLine();

            switch (option){
                case 1 -> senderMessage = createSMS();
                case 2 -> senderMessage = createEmail();
                case 3 -> senderMessage = createWhatsApp();
                case 4 -> senderMessage = createRedeSocial();
                case 0 -> {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Opção invalida");
                    continue;
                }
            }

            senderMessage.enviarMensagem();
        } while(true);

    }

    private static SenderMessage createSMS(){
        System.out.println("Informe o contato:");
        contato = scanner.nextLine();

        System.out.println("Digite a mensagem:");
        message = scanner.nextLine();
        return new SMS(message, contato);
    }

    private static SenderMessage createEmail(){
        System.out.println("Informe o email:");
        contato = scanner.nextLine();

        System.out.println("Digite a mensagem:");
        message = scanner.nextLine();
        return new Email(message, contato);
    }

    private static SenderMessage createWhatsApp(){
        System.out.println("Informe o telefone:");
        contato = scanner.nextLine();

        System.out.println("Digite a mensagem:");
        message = scanner.nextLine();
        return new WhatsApp(message, contato);
    }

    private static SenderMessage createRedeSocial(){
        System.out.println("Informe o perfil:");
        contato = scanner.nextLine();

        System.out.println("Digite a mensagem:");
        message = scanner.nextLine();
        return new RedeSocial(message, contato);
    }


}