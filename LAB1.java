import java.util.Scanner;
import java.util.Random;

public class LAB1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задания к главе 1");

        // Вариант A
        // 1. Приветствие
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");

        // 2. Отобразить в окне консоли аргументы командной строки в обратном порядке.

        // 3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
        System.out.print("Введите количество случайных чисел: ");
        int count = scanner.nextInt();
        Random random = new Random();
        System.out.println("Случайные числа:");
        for (int i = 0; i < count; i++) {
            System.out.print(random.nextInt(100) + " ");
        }
        System.out.println();

        // 4. Ввести пароль и проверить его
        scanner.nextLine(); // Очистка буфера
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        String correctPassword = "12345";
        if (password.equals(correctPassword)) {
            System.out.println("Пароль введён верно.");
        } else {
            System.out.println("Пароль неверный.");
        }


        // 6. Вывести фамилию разработчика, дату и время получения задания, а также дату и время сдачи задания.
        System.out.println("Разработчик: Дамдинов Арья Аюрович");
        System.out.println("Дата получения задания: 01.09.2024");
        System.out.println("Дата сдачи задания: 21.11.2024");

        // Вариант B
        System.out.println("\nЧасть 2: Работа с числами");
        System.out.print("Введите количество чисел n: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // 1. Чётные и нечётные числа
        System.out.println("Чётные числа:");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println("\nНечётные числа:");
        for (int num : numbers) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // 2. Наибольшее и наименьшее число
        int max = numbers[0];
        int min = numbers[0];
        for (int num : numbers) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("Наибольшее число: " + max);
        System.out.println("Наименьшее число: " + min);

        // 3. Числа, которые делятся на 3 или 9
        System.out.println("Числа, которые делятся на 3 или 9:");
        for (int num : numbers) {
            if (num % 3 == 0 || num % 9 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // 4. Числа, которые делятся на 5 и на 7
        System.out.println("Числа, которые делятся на 5 и 7:");
        for (int num : numbers) {
            if (num % 5 == 0 && num % 7 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // 5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр
        System.out.println("Трёхзначные числа без одинаковых цифр:");
        for (int num : numbers) {
            if (num >= 100 && num <= 999 && Uniq(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // 6. Простые числа
        System.out.println("Простые числа:");
        for (int num : numbers) {
            if (Prime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        // 9. Счастливые числа
        System.out.println("Счастливые числа:");
        for (int num : numbers) {
            if (HappyNumber(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

        scanner.close();

        // 10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают
        System.out.println("Числа-палиндромы:");
        for (int num : numbers) {
            if (Palindrome(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    // Метод для проверки уникальности цифр
    public static boolean Uniq(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Метод для проверки простоты числа
    public static boolean Prime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Метод для проверки числа-палиндрома
    public static boolean Palindrome(int num) {
        int original = num;
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return original == reversed;
    }

    // Метод для проверки счастливого числа
    public static boolean HappyNumber(int num) {
        String strNum = String.valueOf(num);

        if (strNum.length() % 2 != 0) {
            return false;
        }

        int halfLength = strNum.length() / 2;
        int sumFirstHalf = 0;
        int sumSecondHalf = 0;

        for (int i = 0; i < halfLength; i++) {
            sumFirstHalf += strNum.charAt(i) - '0';
        }

        for (int i = halfLength; i < strNum.length(); i++) {
            sumSecondHalf += strNum.charAt(i) - '0';
        }

        return sumFirstHalf == sumSecondHalf;
    }
}
