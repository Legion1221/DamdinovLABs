import java.util.*;

/**
 * Выполнил: Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 14.12.2024
 */
class Polynomial {
    private List<Integer> coefficients;  // Коэффициенты полинома, начиная с постоянного (x^0)

    // Конструктор для полинома
    public Polynomial(List<Integer> coefficients) {
        this.coefficients = new ArrayList<>(coefficients);
    }

    // Сложение полиномов
    public Polynomial add(Polynomial other) {
        int degree = Math.max(this.coefficients.size(), other.coefficients.size());
        List<Integer> resultCoefficients = new ArrayList<>();

        for (int i = 0; i < degree; i++) {
            int thisCoeff = i < this.coefficients.size() ? this.coefficients.get(i) : 0;
            int otherCoeff = i < other.coefficients.size() ? other.coefficients.get(i) : 0;
            resultCoefficients.add(thisCoeff + otherCoeff);
        }

        return new Polynomial(resultCoefficients);
    }

    // Вычитание полиномов
    public Polynomial subtract(Polynomial other) {
        int degree = Math.max(this.coefficients.size(), other.coefficients.size());
        List<Integer> resultCoefficients = new ArrayList<>();

        for (int i = 0; i < degree; i++) {
            int thisCoeff = i < this.coefficients.size() ? this.coefficients.get(i) : 0;
            int otherCoeff = i < other.coefficients.size() ? other.coefficients.get(i) : 0;
            resultCoefficients.add(thisCoeff - otherCoeff);
        }

        return new Polynomial(resultCoefficients);
    }

    // Умножение полиномов
    public Polynomial multiply(Polynomial other) {
        int resultDegree = this.coefficients.size() + other.coefficients.size() - 1;
        List<Integer> resultCoefficients = new ArrayList<>();

        // Инициализация списка коэффициентов для результата
        for (int i = 0; i < resultDegree; i++) {
            resultCoefficients.add(0);
        }

        for (int i = 0; i < this.coefficients.size(); i++) {
            for (int j = 0; j < other.coefficients.size(); j++) {
                resultCoefficients.set(i + j, resultCoefficients.get(i + j) + this.coefficients.get(i) * other.coefficients.get(j));
            }
        }

        return new Polynomial(resultCoefficients);
    }

    // Деление полиномов с осатком
    public Polynomial divide(Polynomial other) {
        List<Integer> resultCoefficients = new ArrayList<>();
        List<Integer> dividend = new ArrayList<>(this.coefficients);

        while (dividend.size() >= other.coefficients.size()) {
            int leadingCoeff = dividend.get(0) / other.coefficients.get(0);  // деление ведущих коэффициентов
            resultCoefficients.add(leadingCoeff);

            List<Integer> subtracted = new ArrayList<>();
            for (int i = 0; i < other.coefficients.size(); i++) {
                subtracted.add(other.coefficients.get(i) * leadingCoeff);
            }

            for (int i = 0; i < subtracted.size(); i++) {
                dividend.set(i, dividend.get(i) - subtracted.get(i));
            }

            // Удаление ведущих нулей
            while (!dividend.isEmpty() && dividend.get(0) == 0) {
                dividend.remove(0);
            }
        }

        return new Polynomial(resultCoefficients);
    }

    // Преобразование полинома в строку
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coefficients.size(); i++) {
            if (coefficients.get(i) != 0) {
                if (sb.length() > 0 && coefficients.get(i) > 0) {
                    sb.append("+");
                }
                sb.append(coefficients.get(i));
                if (i > 0) {
                    sb.append("x^" + i);
                }
            }
        }
        return sb.toString();
    }

    // Получение коэффициентов
    public List<Integer> getCoefficients() {
        return coefficients;
    }
}

class PolynomialArray {
    private List<Polynomial> polynomials;

    public PolynomialArray() {
        this.polynomials = new ArrayList<>();
    }

    public void addPolynomial(Polynomial polynomial) {
        polynomials.add(polynomial);
    }

    // Метод для вычисления суммы полиномов
    public Polynomial sumPolynomials() {
        Polynomial sum = polynomials.get(0);
        for (int i = 1; i < polynomials.size(); i++) {
            sum = sum.add(polynomials.get(i));
        }
        return sum;
    }

    // Преобразование массива полиномов в строку
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Polynomial polynomial : polynomials) {
            sb.append(polynomial.toString() + "\n");
        }
        return sb.toString();
    }
}

public class LAB3_B {
    public static void main(String[] args) {
        // Создание полиномов
        Polynomial p1 = new Polynomial(List.of(1, 2, 3));  // 3x^2 + 2x + 1
        Polynomial p2 = new Polynomial(List.of(2, 3, 4));  // 4x^2 + 3x + 2
        Polynomial p3 = new Polynomial(List.of(1, 1));     // x + 1

        // Вывод полиномов
        System.out.println("Полином p1: " + p1);
        System.out.println("Полином p2: " + p2);
        System.out.println("Полином p3: " + p3);

        // Сложение полиномов
        Polynomial sum = p1.add(p2);
        System.out.println("Сумма p1 + p2: " + sum);

        // Вычитание полиномов
        Polynomial difference = p1.subtract(p2);
        System.out.println("Разность p1 - p2: " + difference);

        // Умножение полиномов
        Polynomial product = p1.multiply(p2);
        System.out.println("Произведение p1 * p2: " + product);

        // Деление полиномов
        Polynomial quotient = p2.divide(p3);
        System.out.println("Частное p2 / p3: " + quotient);

        // Создание массива полиномов и их сумма
        PolynomialArray polynomialArray = new PolynomialArray();
        polynomialArray.addPolynomial(p1);
        polynomialArray.addPolynomial(p2);
        polynomialArray.addPolynomial(p3);

        Polynomial totalSum = polynomialArray.sumPolynomials();
        System.out.println("Сумма всех полиномов массива: " + totalSum);
    }
}
