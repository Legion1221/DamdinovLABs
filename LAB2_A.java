import java.util.*;

/**
 * Выполнин : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 05.12.2024
 */


public class LAB2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества чисел
        System.out.println("Введите количество чисел:");
        int n = scanner.nextInt();
        String[] numbers = new String[n];

        // Ввод самих чисел
        System.out.println("Введите числа:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.next();
        }

        // Задания
        findShortestAndLongest(numbers);
        sortByLength(numbers);
        findNumbersByAverageLength(numbers);
        findMinimalUniqueDigits(numbers);
        countEvenDigitNumbers(numbers);
        findIncreasingDigitNumber(numbers);
        findUniqueDigitNumber(numbers);
        findSecondPalindrome(numbers);
    }

    /**
     * Находит самое короткое и самое длинное число и выводит их.
     */
    private static void findShortestAndLongest(String[] numbers) {
        String shortest = numbers[0];
        String longest = numbers[0];

        for (String num : numbers) {
            if (num.length() < shortest.length()) {
                shortest = num;
            }
            if (num.length() > longest.length()) {
                longest = num;
            }
        }

        System.out.println("Самое короткое число: " + shortest + " (длина: " + shortest.length() + ")");
        System.out.println("Самое длинное число: " + longest + " (длина: " + longest.length() + ")");
    }

    /**
     * Упорядочивает числа по длине и выводит их.
     */
    private static void sortByLength(String[] numbers) {
        Arrays.sort(numbers, Comparator.comparingInt(String::length));
        System.out.println("Числа по возрастанию длины: " + Arrays.toString(numbers));
    }

    /**
     * Выводит числа, длина которых меньше или больше средней длины.
     */
    private static void findNumbersByAverageLength(String[] numbers) {
        double averageLength = Arrays.stream(numbers).mapToInt(String::length).average().orElse(0);

        System.out.println("Средняя длина: " + averageLength);
        System.out.println("Числа, длина которых меньше средней:");
        for (String num : numbers) {
            if (num.length() < averageLength) {
                System.out.println(num + " (длина: " + num.length() + ")");
            }
        }
    }

    /**
     * Находит число с минимальным количеством уникальных цифр.
     */
    private static void findMinimalUniqueDigits(String[] numbers) {
        String result = numbers[0];
        int minUniqueDigits = countUniqueDigits(result);

        for (String num : numbers) {
            int uniqueDigits = countUniqueDigits(num);
            if (uniqueDigits < minUniqueDigits) {
                result = num;
                minUniqueDigits = uniqueDigits;
            }
        }

        System.out.println("Число с минимальным количеством уникальных цифр: " + result);
    }

    private static int countUniqueDigits(String number) {
        return (int) number.chars().distinct().count();
    }

    /**
     * Подсчитывает числа с только четными цифрами и среди них числа с равным количеством четных и нечетных цифр.
     */
    private static void countEvenDigitNumbers(String[] numbers) {
        int allEvenCount = 0;
        int equalEvenOddCount = 0;

        for (String num : numbers) {
            long evenCount = num.chars().filter(ch -> (ch - '0') % 2 == 0).count();
            long oddCount = num.length() - evenCount;

            if (evenCount == num.length()) {
                allEvenCount++;
            }
            if (evenCount == oddCount) {
                equalEvenOddCount++;
            }
        }

        System.out.println("Чисел с только четными цифрами: " + allEvenCount);
        System.out.println("Чисел с равным количеством четных и нечетных цифр: " + equalEvenOddCount);
    }

    /**
     * Находит первое число, в котором цифры расположены в порядке возрастания.
     */
    private static void findIncreasingDigitNumber(String[] numbers) {
        for (String num : numbers) {
            if (isDigitsIncreasing(num)) {
                System.out.println("Число с цифрами в порядке возрастания: " + num);
                return;
            }
        }
        System.out.println("Нет числа с цифрами в порядке возрастания.");
    }

    private static boolean isDigitsIncreasing(String number) {
        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i) <= number.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Находит первое число, состоящее только из уникальных цифр.
     */
    private static void findUniqueDigitNumber(String[] numbers) {
        for (String num : numbers) {
            if (countUniqueDigits(num) == num.length()) {
                System.out.println("Число с уникальными цифрами: " + num);
                return;
            }
        }
        System.out.println("Нет числа с уникальными цифрами.");
    }

    /**
     * Находит второе число-палиндром.
     */
    private static void findSecondPalindrome(String[] numbers) {
        int palindromeCount = 0;

        for (String num : numbers) {
            if (isPalindrome(num)) {
                palindromeCount++;
                if (palindromeCount == 2) {
                    System.out.println("Второе число-палиндром: " + num);
                    return;
                }
            }
        }

        System.out.println("Второго числа-палиндрома нет.");
    }

    private static boolean isPalindrome(String number) {
        return new StringBuilder(number).reverse().toString().equals(number);
    }
}

