import java.util.Scanner;

public class Main {

    static Pet pet = new Pet();
    static MaquinaDeBanho maquina = new MaquinaDeBanho();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        int option;

        do{
            System.out.println("======= PET SHOP ========");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer agua");
            System.out.println("3 - Abastecer shampoo");
            System.out.println("4 - Verificar nivel de agua");
            System.out.println("5 - Verificar nivel de shampoo");
            System.out.println("6 - Verificar se tem pet na maquina");
            System.out.println("7 - Colocar pet na maquina");
            System.out.println("8 - Retirar pet da maquina");
            System.out.println("9 - Limpar maquina");
            System.out.println("\n0 - sair");
            option = scanner.nextInt();

            switch(option){
                case 1 -> limparPet();
                case 2 -> abastecerAgua();
                case 3 -> abastecerShampoo();
                case 4 -> verificarNivelAgua();
                case 5 -> verificarNivelShampoo();
                case 6 -> verificarPetNaMaquina();
                case 7 -> colocarPetNaMaquina();
                case 8 -> retirarPet();
                case 9 -> limparMaquina();
                case 0 -> System.out.println("Desligando maquina...");
            }

        }while(option != 0);
        System.out.println("Fechando PetShop...");
        System.exit(0);
    }

    public static void limparPet(){
        System.out.println("===============================");
        if(!maquina.isTemPet()){
            System.out.println("O pet nao esta na maquina");
            return;
        }

        if(pet.isLimpo()){
            System.out.println("O pet ja esta limpo");
            return;
        }

        System.out.println("Limpando o pet...");
        System.out.println("===============================");
        pet.setLimpo(true);
        int consumirAgua = maquina.getAgua() - 10;
        int consumirShampoo = maquina.getShampoo() - 2;
        maquina.setAgua(consumirAgua);
        maquina.setShampoo(consumirShampoo);

    }

    public static void verificarNivelAgua(){
        System.out.println("======== NIVEL DE AGUA ========");
        System.out.printf("A maquina esta com %s litros\n", maquina.getAgua());
        System.out.println("===============================");
    }

    public static void verificarNivelShampoo(){
        System.out.println("======== NIVEL DE SHAMPOO ========");
        System.out.printf("A maquina esta com %s litros\n", maquina.getShampoo());
        System.out.println("===============================");
    }

    public static void verificarPetNaMaquina(){
        System.out.println("===============================");
        System.out.println("Verificando...");
        System.out.printf("%s pet na maquina\n", (maquina.isTemPet()) ? "Tem " : "Nao tem");
        System.out.println("===============================");
    }

    public static void abastecerAgua(){
        int agua = maquina.getAgua();
        System.out.println("===============================");
        if(agua <= 28) {
            System.out.println("Abastecendo agua....");
            maquina.setAgua(agua + 2);
        } else {
            System.out.println("Reservatorio cheio");
        }
        System.out.println("===============================");
    }

    public static void abastecerShampoo(){
        int shampoo = maquina.getShampoo();
        System.out.println("===============================");
        if(shampoo <= 8) {
            System.out.println("Abastecendo shampoo....");
            maquina.setAgua(shampoo + 2);
        } else {
            System.out.println("Reservatorio cheio");
        }
        System.out.println("===============================");
    }

    public static void colocarPetNaMaquina(){
        System.out.println("===============================");
        if(!maquina.isEstaLimpa()){
            System.out.println("A maquina nao esta limpa. Limpar a maquina antes");
            return;
        }

        if(!maquina.isTemPet()){
            System.out.println("Colocando pet na maquina...");
            maquina.setTemPet(true);
            pet.setLimpo(false);
        } else {
            System.out.println("Ja tem pet na maquina");
        }
        System.out.println("===============================");
    }

    public static void retirarPet(){
        System.out.println("===============================");
        if(!maquina.isTemPet()) {
            System.out.println("Nao tem pet na maquina");
            return;
        }

        if(pet.isLimpo()){
            System.out.println("O pet esta limpo");
        } else {
            System.out.println("O pet nao esta limpo");
            maquina.setEstaLimpa(false);
        }
        maquina.setTemPet(false);
        System.out.println("Retirando pet...");
        System.out.println("===============================");
    }

    public static void limparMaquina(){
        System.out.println("===============================");
        if(maquina.isEstaLimpa()){
            System.out.println("A maquina ja esta limpa");
            return;
        }

        if(maquina.isTemPet()) {
            System.out.println("Nao eh possivel realizar a limpeza");
            System.out.println("Motivo: Tem pet dentro da maquina");
            System.out.println("Solucao: Retirar o pet para poder realizar a limpeza");
            return;
        }

        System.out.println("Limpando maquina...");
        System.out.println("Recursos consumido: \n" +
                "Agua: 3 litro" +
                "Shampoo: 1 litro");

        int recursoAgua = maquina.getAgua();
        int recursoShampoo = maquina.getShampoo();
        maquina.setAgua(recursoAgua - 3);
        maquina.setAgua(recursoShampoo - 1);
        maquina.setEstaLimpa(true);
        System.out.println("===============================");
    }


}