import java.util.*;

/**
 * Выполнил: Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 14.12.2024
 */
class Abiturient {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String phone;
    private List<Integer> grades;

    // Конструктор с параметрами
    public Abiturient(int id, String lastName, String firstName, String patronymic, String address, String phone, List<Integer> grades) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.grades = grades;
    }

    // Конструктор без оценок
    public Abiturient(int id, String lastName, String firstName, String patronymic, String address, String phone) {
        this(id, lastName, firstName, patronymic, address, phone, new ArrayList<>());
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    // Метод для получения суммы баллов
    public int getSumOfGrades() {
        return grades.stream().mapToInt(Integer::intValue).sum();
    }

    // Метод для проверки наличия неудовлетворительных оценок
    public boolean hasUnsatisfactoryGrades() {
        return grades.contains(2);  // предположу, что "2" - это неудовлетворительная оценка
    }

    @Override
    public String toString() {
        return "Abiturient{id=" + id + ", lastName='" + lastName + "', firstName='" + firstName + "', patronymic='" + patronymic +
                "', address='" + address + "', phone='" + phone + "', grades=" + grades + "}";
    }
}

class AbiturientArray {
    private List<Abiturient> abiturients;

    public AbiturientArray() {
        this.abiturients = new ArrayList<>();
    }

    public void addAbiturient(Abiturient abiturient) {
        abiturients.add(abiturient);
    }

    // Метод для вывода абитуриентов с неудовлетворительными оценками
    public void printAbiturientsWithUnsatisfactoryGrades() {
        System.out.println("\nАбитуриенты с неудовлетворительными оценками:");
        for (Abiturient abiturient : abiturients) {
            if (abiturient.hasUnsatisfactoryGrades()) {
                System.out.println(abiturient);
            }
        }
    }

    // Метод для вывода абитуриентов с суммой баллов выше заданной
    public void printAbiturientsWithSumGreaterThan(int threshold) {
        System.out.println("\nАбитуриенты с суммой баллов выше " + threshold + ":");
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getSumOfGrades() > threshold) {
                System.out.println(abiturient);
            }
        }
    }

    // Метод для вывода абитуриентов с самой высокой суммой баллов
    public void printTopAbiturientsBySum(int n) {
        abiturients.sort(Comparator.comparingInt(Abiturient::getSumOfGrades).reversed());
        System.out.println("\nТоп " + n + " абитуриентов с самой высокой суммой баллов:");
        for (int i = 0; i < Math.min(n, abiturients.size()); i++) {
            System.out.println(abiturients.get(i));
        }
    }

    // Метод для вывода всех абитуриентов
    public void printAllAbiturients() {
        System.out.println("\nВсе абитуриенты:");
        for (Abiturient abiturient : abiturients) {
            System.out.println(abiturient);
        }
    }
}

public class LAB3 {
    public static void main(String[] args) {
        AbiturientArray abiturientArray = new AbiturientArray();

        // Добавление абитуриентов
        abiturientArray.addAbiturient(new Abiturient(1, "Гомбоев", "Дорж", "Баирович", "Владивосток", "322136", Arrays.asList(4, 5, 3, 2)));
        abiturientArray.addAbiturient(new Abiturient(2, "Дамдинов", "Арья", "Аюрович", "Улан-Удэ", "654321", Arrays.asList(5, 5, 5, 5)));
        abiturientArray.addAbiturient(new Abiturient(3, "Йовчу", "Никита", "Александрович", "Владивосток", "618254", Arrays.asList(3, 3, 4, 2)));
        abiturientArray.addAbiturient(new Abiturient(3, "Петушков", "Денис", "Дмитриевич", "Томск", "555353", Arrays.asList(4, 3, 5, 2)));

        // Вывод всех абитуриентов
        abiturientArray.printAllAbiturients();

        // ВЫвод абитуриентов с неудовлетворительными оценками
        abiturientArray.printAbiturientsWithUnsatisfactoryGrades();

        // Вывод абитуриентов с суммой баллов выше заданной
        abiturientArray.printAbiturientsWithSumGreaterThan(12);

        // Топ 2 абитуриентов с самой высокой суммой баллов
        abiturientArray.printTopAbiturientsBySum(2);
    }
}
