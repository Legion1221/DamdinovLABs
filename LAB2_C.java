import java.util.*;

/**
 * Выполнил: Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 09.12.2024
 */
public class LAB2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем азмерность матрицы
        System.out.println("Введите размерность матрицы (n):");
        int n = scanner.nextInt();

        // Создаем матрицу и заполняем её случайными числами
        int[][] matrix = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n;
            }
        }

        // Выводим матрицу
        System.out.println("Сгенерированная матрица:");
        printMatrix(matrix);

        // Задание 1
        System.out.println("\n1. Упорядочить строки (столбцы) в порядке возрастания значений элементов.");
        orderMatrix(matrix, n);

        // Задание 2
        System.out.println("\n2. Выполнить циклический сдвиг на k позиций вправо.");
        System.out.println("Введите k для сдвига:");
        int k = scanner.nextInt();
        shiftMatrix(matrix, k, "right");

        // Задание 3
        System.out.println("\n3. Найти наибольшее количество подряд идущих возрастающих или убывающих элементов.");
        findLongestSequence(matrix);
    }

    // Метод для вывода матрицы
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для упорядочивания строк или столбцов
    private static void orderMatrix(int[][] matrix, int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие: 1 - Упорядочить строки, 2 - Упорядочить столбцы");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // Сортируем строки
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        // Сортировка строк по возрастанию
                        if (matrix[i][j] > matrix[i][k]) {
                            int temp = matrix[i][j];
                            matrix[i][j] = matrix[i][k];
                            matrix[i][k] = temp;
                        }
                    }
                }
            }
            System.out.println("Матрица после сортировки строк:");
        } else if (choice == 2) {
            // Сортируем столбцы
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n - 1; i++) {
                    for (int k = i + 1; k < n; k++) {
                        // Сортировка столбцов по возрастанию
                        if (matrix[i][j] > matrix[k][j]) {
                            int temp = matrix[i][j];
                            matrix[i][j] = matrix[k][j];
                            matrix[k][j] = temp;
                        }
                    }
                }
            }
            System.out.println("Матрица после сортировки столбцов:");
        } else {
            // Если выбор неверный
            System.out.println("Неверный выбор!");
        }

        // Выводим отсортированную матрицу
        printMatrix(matrix);
    }

    // Метод для выполнения циклического сдвига
    private static void shiftMatrix(int[][] matrix, int k, String direction) {
        int n = matrix.length;
        if (direction.equals("right")) {
            // Выполняем сдвиг вправо
            for (int i = 0; i < n; i++) {
                int[] row = matrix[i];
                for (int shift = 0; shift < k; shift++) {
                    int last = row[n - 1]; // Сохраняем последний элемент строки
                    System.arraycopy(row, 0, row, 1, n - 1); // Сдвигаем вправо
                    row[0] = last; // Помещаем последний элемент в начало
                }
            }
        }
        System.out.println("Матрица после циклического сдвига вправо на " + k + " позиций:");
        // Выводим изменённую матрицу
        printMatrix(matrix);
    }


    // Метод для поиска наибольшего количества подряд идущих возрастающих или убывающих элементов
    private static void findLongestSequence(int[][] matrix) {
        int maxLength = 0;
        int currentLength;

        // Проверяем строки на наличие возрастающих последовательностей
        for (int i = 0; i < matrix.length; i++) {
            currentLength = 1; // Начинаем с длины последовательности 1
            for (int j = 1; j < matrix[i].length; j++) {
                // Если текущий элемент больше предыдущего, увеличиваем длину
                if (matrix[i][j] > matrix[i][j - 1]) {
                    currentLength++;
                } else {
                    // Иначе обновляем максимальную длину и сбрасываем текущую
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = 1;
                }
            }
            // Обновляем максимальную длину последовательности для строки
            maxLength = Math.max(maxLength, currentLength);
        }

        // Проверяем столбцы на наличие возрастающих последовательностей
        for (int j = 0; j < matrix[0].length; j++) {
            currentLength = 1;
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] > matrix[i - 1][j]) {
                    currentLength++;
                } else {
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = 1;
                }
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        // Выводим результат
        System.out.println("Наибольшее количество подряд идущих возрастающих элементов: " + maxLength);
    }
}
