import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите пароль: ");
        String inputPassword = scanner.nextLine();
        String rightPassword = "Damdinov762v4";

        if (inputPassword.equals(rightPassword)) {
            System.out.println("Пароль введен правильно.");
        } else {
            System.out.println("Пароль неверный.");
            scanner.close();
            return;
        }

        System.out.print("Введите количество чисел n: ");
        int n = scanner.nextInt();

        ArrayList<Integer> divisibleNumbers = new ArrayList<>();
        System.out.println("Введите " + n + " целых чисел:");

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            if (number % 5 == 0 && number % 7 == 0) {
                divisibleNumbers.add(number);
            }
        }

        System.out.println("Числа, делящиеся на 5 и 7:");
        for (int num : divisibleNumbers) {
            System.out.println(num);
        }

        scanner.close();
    }
}
