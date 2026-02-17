import java.util.*;
import java.util.function.*;
import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);


        while(true) {

        System.out.println("Informe o numero do exercicio escolhido: (1 - 19)");
        var op = scanner.nextInt();
            switch (op) {
                case 1 -> {
                    var sortedList = numeros.stream()
                            .distinct()
                            .sorted()
                            .toList();
                    System.out.println(sortedList);
                }
                case 2 -> {
                    var resultStream = numeros.stream()
                            .filter(n -> n % 2 == 0)
                            .reduce(0, Integer::sum);
                    System.out.println(resultStream);
                }
                case 3 -> {
                    var verifyStream = numeros.stream().allMatch(n -> n > 0);
                    System.out.println(verifyStream);
                }
                case 4 -> {
                    var resultStream = numeros.stream()
                            .filter(n -> n % 2 == 0)
                            .toList();
                    System.out.println(resultStream);
                }
                case 5 -> {
                    double resultStream = numeros.stream()
                            .filter(n -> n > 5)
                            .mapToDouble(Integer::doubleValue)
                            .average()
                            .orElseThrow(() -> new RuntimeException("Media nao encontrada"));

                    System.out.println("A media e: " + resultStream);
                }
                case 6 -> {
                    var resultStream = numeros.stream()
                            .anyMatch(n -> n > 10);
                    System.out.println(resultStream ? "Contem numero maior que 10" : "Nao contem");
                }
                case 7 -> {
                    Integer resultStream = numeros.stream()
                            .distinct()
                            .sorted(Comparator.reverseOrder())
                            .skip(1)
                            .findFirst()
                            .orElseThrow(() -> new NoSuchElementException("Elemento nao encontrado"));

                    System.out.println("O segundo maior numero eh: " + resultStream);
                }
                case 8 -> {
                    var resultStram = numeros.stream()
                            .flatMapToInt(n -> String.valueOf(n)
                                    .chars()
                                    .map(Character::getNumericValue))
                            .sum();
                    System.out.println(resultStram);
                }
                case 9 -> {
                    var verifyDuplicatesValues = (numeros.stream().distinct().count() < numeros.size())
                            ? "Contem numeros duplicados" : "Nenhum valor se repete";
                    System.out.println(verifyDuplicatesValues);
                }
                case 10 -> {
                    var multiplesOfNumbers = numeros.stream()
                            .sorted()
                            .distinct()
                            .filter(n -> ((n % 2 != 0) && ((n % 3 == 0) || (n % 5 == 0))))
                            .toList();
                    System.out.println(multiplesOfNumbers);
                }
                case 11 -> {
                    var resultStream = numeros.stream()
                            .flatMapToDouble(n -> DoubleStream.of(Math.pow(2, n)))
                            .reduce(0, Double::sum);
                    System.out.println("A soma do quadrado dos numeros eh: " + resultStream);
                }
                case 12 -> {
                    var resultStream = numeros.stream()
                            .reduce(1, (a, b) -> a * b);
                    System.out.println(resultStream);
                }
                case 13 -> {
                    var resultFilterStream = numeros.stream()
                            .filter(n -> (n > 5 && n < 10)).toList();
                    System.out.println(resultFilterStream);
                }
                case 14 -> {

                    var resultStream = numeros.stream()
                            .filter(n -> {
                                if (n <= 1) return false;
                                for (int i = 2; i <= n / 2; i++) {
                                    if ((n % i) == 0) return false;
                                }
                                return true;
                            })
                            .max(Comparator.naturalOrder())
                            .orElseThrow(() -> new NoSuchElementException("Nenhum numero primo encontrado"));
                    System.out.println("O maior numero primo e: " + resultStream);
                }
                case 15 -> {
                    String resultNegativeValue = (numeros.stream().anyMatch(n -> n < 0))
                            ? "Contem algum numero negativo" : "Nao contem numeros negativos";

                    System.out.println(resultNegativeValue);
                }
                case 16 -> {
                    var listaNumerosPares = numeros.stream().sorted().filter(n -> n % 2 == 0).toList();
                    var listaNumerosImpares = numeros.stream().sorted().filter(n -> n % 2 != 0).toList();
                    System.out.println("Lista de numeros pares: " + listaNumerosPares);
                    System.out.println("Lista de numeros impares: " + listaNumerosImpares);
                }
                case 17 -> {
                    var listaNumerosPrimos = numeros.stream()
                            .sorted()
                            .distinct()
                            .filter(n -> {
                                if (n == 1) return false;
                                for (int i = 2; i <= n / 2; i++) {
                                    if (n % i == 0) return false;
                                }
                                return true;
                            }).toList();
                    System.out.println("Numeros primos: " + listaNumerosPrimos);
                }
                case 18 -> {
                    var allValuesIsEquals = (numeros.stream()
                            .allMatch(o -> {
                                for (var n : numeros)
                                    if (!Objects.equals(n, o)) return false;
                                return true;
                            })) ? "Todos os numeros sao iguais" : "Nem todos os numeros sao iguais";
                    System.out.println(allValuesIsEquals);
                }
                case 19 -> {
                    var resultStream = numeros.stream()
                            .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                            .reduce(0, Integer::sum);
                    System.out.println("A soma dos numeros multiplos de 3 e 5 na lista e: " + resultStream);
                }
                default -> System.out.println("Exercicio nao existe!");
            }
            System.out.println("Deseja verificar outro desafio? (1) Sim | (2) Nao");
            op = scanner.nextInt();
            if(op == 2) System.exit(0);
        }
    }

}
