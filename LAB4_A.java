import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Класс Город
class City {
    private String name;
    private double area;

    public City(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Double.compare(city.area, area) == 0 && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}

// Класс Район
class District {
    private String name;
    private City capital;
    private List<City> cities;

    public District(String name, City capital, List<City> cities) {
        this.name = name;
        this.capital = capital;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public City getCapital() {
        return capital;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(name, district.name) && Objects.equals(capital, district.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital);
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", capital=" + capital +
                ", cities=" + cities +
                '}';
    }
}

// Класс Область
class Region {
    private String name;
    private double area;
    private City capital;
    private List<District> districts;

    public Region(String name, double area, City capital, List<District> districts) {
        this.name = name;
        this.area = area;
        this.capital = capital;
        this.districts = districts;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public City getCapital() {
        return capital;
    }

    public List<District> getDistricts() {
        return districts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Double.compare(region.area, area) == 0 &&
                Objects.equals(name, region.name) &&
                Objects.equals(capital, region.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area, capital);
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", capital=" + capital +
                ", districts=" + districts +
                '}';
    }
}

// Класс Государство
class Country {
    private String name;
    private City capital;
    private List<Region> regions;

    public Country(String name, City capital, List<Region> regions) {
        this.name = name;
        this.capital = capital;
        this.regions = regions;
    }

    public String getName() {
        return name;
    }

    public City getCapital() {
        return capital;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public int getRegionCount() {
        return regions.size();
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Region region : regions) {
            totalArea += region.getArea();
        }
        return totalArea;
    }

    public List<City> getRegionalCapitals() {
        List<City> capitals = new ArrayList<>();
        for (Region region : regions) {
            capitals.add(region.getCapital());
        }
        return capitals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) && Objects.equals(capital, country.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital=" + capital +
                ", regions=" + regions +
                '}';
    }
}

// Главный класс с запуском программы
public class LAB4_A {
    public static void main(String[] args) {
        // Создание городов
        City city1 = new City("City1", 321);
        City city2 = new City("City2", 1020);
        City city3 = new City("City3", 982);
        City city4 = new City("City4", 741);

        // Создание районов
        District district1 = new District("District1", city1, List.of(city1, city2));
        District district2 = new District("District2", city2, List.of(city3, city4));

        // Создание областей
        Region region1 = new Region("Region1", 2002, city1, List.of(district1, district2));

        // Создание государства
        Country country = new Country("Country1", city1, List.of(region1));

        // Вывод информации о государстве
        System.out.println("Столица государства: " + country.getCapital().getName());
        System.out.println("Количество областей: " + country.getRegionCount());
        System.out.println("Общая площадь государства: " + country.getTotalArea());

        // Вывод столиц областей
        System.out.println("Областные центры:");
        for (City capital : country.getRegionalCapitals()) {
            System.out.println("- " + capital.getName());
        }

        // Дополнительный вывод для областей и районов
        System.out.println("\nОбласти:");
        for (Region region : country.getRegions()) {
            System.out.println("Область: " + region.getName() + ", Столица: " + region.getCapital().getName());
            System.out.println("Площадь области: " + region.getArea());

            // Вывод районов в области
            System.out.println("Районы:");
            for (District district : region.getDistricts()) {
                System.out.println("- Район: " + district.getName() + ", Столица района: " + district.getCapital().getName());
            }
        }
    }
}
