import java.util.*;

/**
 * Выполнил: Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 19.12.2024
 */
class ComplexNumber {
    private double real;
    private double imaginary; // Мнимая часть

    // КОнсттруктор
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Метод для сложения комплексных чисел
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    // Метод для строкового представления комплексного числа
    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }

    // Геттеры для реальной и мнимой части
    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}

class Fraction {
    private ComplexNumber numerator;   // Числитель
    private ComplexNumber denominator; // Знаменатель

    // Конструктор
    public Fraction(ComplexNumber numerator, ComplexNumber denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Метод для сложения дробей
    public Fraction add(Fraction other) {
        ComplexNumber newNumerator = this.numerator.add(other.numerator);
        ComplexNumber newDenominator = this.denominator.add(other.denominator);
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для строкового представления дроби
    @Override
    public String toString() {
        return "(" + numerator.toString() + " / " + denominator.toString() + ")";
    }

    // Геттеры для числителя и знаменателя
    public ComplexNumber getNumerator() {
        return numerator;
    }

    public ComplexNumber getDenominator() {
        return denominator;
    }
}

public class LAB3_C {

    // Метод для изменения элементов массива с четным индексом
    public static void modifyArray(Fraction[] fractions) {
        for (int i = 0; i < fractions.length - 1; i += 2) {
            fractions[i] = fractions[i].add(fractions[i + 1]);
        }
    }

    public static void main(String[] args) {
        // Создание массива дробей с комплексными числами
        Fraction[] fractions = new Fraction[5];

        // Инициализация дробей
        fractions[0] = new Fraction(new ComplexNumber(1, 1), new ComplexNumber(2, 2));
        fractions[1] = new Fraction(new ComplexNumber(3, 3), new ComplexNumber(4, 4));
        fractions[2] = new Fraction(new ComplexNumber(5, 5), new ComplexNumber(6, 6));
        fractions[3] = new Fraction(new ComplexNumber(7, 7), new ComplexNumber(8, 8));
        fractions[4] = new Fraction(new ComplexNumber(9, 9), new ComplexNumber(10, 10));

        System.out.println("Массив дробей до изменения:");
        for (Fraction fraction : fractions) {
            System.out.println(fraction);
        }

        // Изменение элементов массива с четным индексом
        modifyArray(fractions);

        // Вывод массива дробей после изменения
        System.out.println("\nМассив дробей после изменения:");
        for (Fraction fraction : fractions) {
            System.out.println(fraction);
        }
    }
}
