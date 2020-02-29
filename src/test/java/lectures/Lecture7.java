package lectures;

import beans.Car;
import beans.Person;
import mockdata.MockData;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Lecture7 {

    @Test
    public void count() throws Exception {
        List<Person> people = MockData.getPeople();

        long count = people.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female"))
                .count();

        System.out.println("Number of women " + count);
    }

    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();

        double min = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(car -> car.getPrice())
                .min()
                .getAsDouble();

        System.out.println("Minimum car price " + min);
    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();

        double max = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                .mapToDouble(car -> car.getPrice())
                .max()
                .getAsDouble();

        System.out.println("Maximum car price " + max);
    }

    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();

        double average = cars.stream()
                .mapToDouble(car -> car.getPrice())
                .average()
                .orElse(0);

        System.out.println("Average car price " + average);
    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();

        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
        BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);

        System.out.println("Sum of all car prices " + bigDecimalSum);
    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();

        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();

        System.out.println("Cars statistics: " + statistics);
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
    }
}