import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String numeroString, tipoLinha;

    public static void main(String[] args) {
        do{
            System.out.println("Informe o numero da linha:");
            numeroString = scanner.nextLine();

            if(numeroString.isEmpty()){
                System.out.println("Campo vazio!");
                continue;
            }

            if(!verificarSimbolos(numeroString)){
                System.out.println("Numero invalido!");
                continue;
            }

            if(!verificarTamanho(numeroString)) {
                System.out.println("Numero Invalido!");
                continue;
            }

            var ar1 = numeroString.replace("(","").replace(")","")
                    .replace("-","");

            System.out.println("===========================");
            System.out.printf("%s | Linha: %s\n",formatar(ar1, tipoLinha), tipoLinha);
            System.out.println("===========================");

            if(!consultarNovamente()) break;

        }while(true);

        System.out.println("Saindo....");
        System.exit(0);
    }

    private static boolean consultarNovamente(){
        while(true){
            int option;
            System.out.println("Deseja fazer nova consulta? \n(1) Sim | (2) Não");
            option = scanner.nextInt();
            if(option != 1 && option != 2){
                System.out.println("Opção invalida");
            }else return option == 1;
        }
    }

    private static boolean verificarSimbolos(String strNumero){
        var arrTemp = strNumero.split("");
        String[] simbolos = {"(",")","-"};

        for (String string : arrTemp)
            if (!Caracteres.verificarCaracteres(string)) return false;

        for(String sim : simbolos){
            if(strNumero.contains(sim)) {
                var count = 0;
                for (String s : arrTemp) {
                    if (s.equalsIgnoreCase(sim)) count++;
                }
                if(count > 1) return false;
            }
        }
        return true;
    }

    private static boolean verificarFormatado(String[] stringNumero){
        if(stringNumero[0].equalsIgnoreCase("(") &&
            stringNumero[3].equalsIgnoreCase(")")){
            if(stringNumero[9].equalsIgnoreCase("-") ||
                    stringNumero[8].equalsIgnoreCase("-")){
                System.out.println("Numero já formatado!");
                return true;
            }
        }
        return false;
    }

    private static String formatar(String numero, String linha){
        if(linha.equalsIgnoreCase("telefone_fixo")){
            return "(" + numero.substring(0,2) + ")" + numero.substring(2,6) + "-" + numero.substring(6,10);
        } else{
            return "(" + numero.substring(0,2) + ")" + numero.substring(2,7) + "-" + numero.substring(7,11);
        }
    }

    private static boolean verificarTamanho(String numero){
        var verifyCount = 0;
        var str = numero.split("");
        var arTemp = numero.replace("(","").replace(")","")
                .replace("-","").split("");
        for(LinhaTelefonica l : LinhaTelefonica.values()){

            if(arTemp.length < l.getTamanhoMin()){
                verifyCount++;
            } else if(arTemp.length > l.getTamanhoMax()){
                verifyCount++;
            } else if(arTemp.length == l.getTamanhoMin()){
                if (str.length == l.getTamanhoMax()) {
                    if(!verificarFormatado(str)){
                        System.out.println("Numero formatado de forma errada, corrigindo...");
                    }
                    tipoLinha = l.name().toLowerCase();
                    return true;
                }
                tipoLinha = l.name().toLowerCase();
                return true;
            } else {
                verifyCount++;
            }
        }
        return (verifyCount != 2);
    }
}