import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(11, -9, 9, 10, 22, 23, 34, 17, 20, 65);
        List<Double> tempsC = Arrays.asList(2.1, 31.1, 27.3, 57.0);
        List<String> noms = Arrays.asList("Miguel", "Angel", "Beatriz", "Fernando", "Andres", "Maria");

        System.out.println("Lista original de números: " + nums);
        System.out.println("==========================================");

        System.out.println("\n--- Nivel 1 — Operaciones básicas ---");

        int sum = nums.stream()
                .reduce(0, (acc, cur) -> acc + cur);
        System.out.println("1. Suma de elementos: " + sum);

        int maxVal = nums.stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("2. Valor máximo: " + maxVal);

        int minVal = nums.stream()
                .min(Integer::compareTo)
                .orElse(0);
        System.out.println("3. Valor mínimo: " + minVal);

        long totalCnt = nums.stream().count();
        System.out.println("4. Cantidad de elementos: " + totalCnt);

        System.out.println("\n--- Nivel 2 — filter ---");

        List<Integer> pares = nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("5. Números pares: " + pares);

        List<Integer> may50 = nums.stream()
                .filter(n -> n > 50)
                .collect(Collectors.toList());
        System.out.println("6. Mayores que 50: " + may50);

        long posCnt = nums.stream()
                .filter(n -> n > 0)
                .count();
        System.out.println("7. Cantidad de números positivos: " + posCnt);

        List<Integer> rango = nums.stream()
                .filter(n -> n >= 10 && n <= 50)
                .collect(Collectors.toList());
        System.out.println("8. Números en rango [10, 50]: " + rango);

        System.out.println("\n--- Nivel 3 — map ---");

        List<Integer> cuads = nums.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("9. Números elevados al cuadrado: " + cuads);

        List<Integer> mult10 = nums.stream()
                .map(n -> n * 10)
                .collect(Collectors.toList());
        System.out.println("10. Números multiplicados por 10: " + mult10);

        List<Double> tempsF = tempsC.stream()
                .map(c -> (c * 9 / 5) + 32)
                .collect(Collectors.toList());
        System.out.println("11. Temperaturas en Fahrenheit: " + tempsF);

        System.out.println("\n--- Nivel 4 — combinar operaciones ---");

        List<Integer> paresCuad = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("12. Pares al cuadrado: " + paresCuad);

        int sumPares = nums.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("13. Suma de números pares: " + sumPares);

        OptionalDouble promMay50 = nums.stream()
                .filter(n -> n > 50)
                .mapToDouble(Integer::doubleValue)
                .average();
        System.out.println("14. Promedio de mayores a 50: " +
                (promMay50.isPresent() ? promMay50.getAsDouble() : 0));

        int maxPares = nums.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("15. Máximo de los pares: " + maxPares);

        System.out.println("\n--- Nivel 5 — ordenamiento ---");

        List<Integer> ascOrd = nums.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("16. Orden menor a mayor: " + ascOrd);

        List<Integer> descOrd = nums.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("17. Orden mayor a menor: " + descOrd);

        List<Integer> top3Max = nums.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("18. Tres números más grandes: " + top3Max);

        System.out.println("\n--- Nivel 6 — String ---");
        System.out.println("Lista de nombres: " + noms);

        List<String> nomsConA = noms.stream()
                .filter(nom -> nom.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("19. Nombres que empiezan con 'A': " + nomsConA);

        List<String> nomsLargos = noms.stream()
                .filter(nom -> nom.length() > 5)
                .collect(Collectors.toList());
        System.out.println("20. Nombres con más de 5 caracteres: " + nomsLargos);

        List<String> mayus = noms.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("21. Nombres en mayúsculas: " + mayus);

        List<String> nomsOrd = noms.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("22. Nombres ordenados: " + nomsOrd);

        System.out.println("\n--- Nivel 7 ---");

        Integer numBuscado = nums.stream()
                .filter(n -> n == 22)
                .findFirst()
                .orElse(null);
        System.out.println("23. Buscar el número 22: " + (numBuscado != null ? "Encontrado" : "No encontrado"));

        boolean todosMen200 = nums.stream()
                .allMatch(n -> n < 200);
        System.out.println("24. ¿Todos los números son menores a 200?: " + todosMen200);

        boolean algNeg = nums.stream()
                .anyMatch(n -> n < 0);
        System.out.println("25. ¿Existe algún número negativo en la lista?: " + algNeg);
    }
}