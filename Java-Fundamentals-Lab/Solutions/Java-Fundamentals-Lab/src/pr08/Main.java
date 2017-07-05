package pr08;

import pr08.interfaces.IBook;
import pr08.models.Book;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<IBook> books = Stream.of(
                new Book("Vinetu3", "Karl Mai", 20),
                new Book("Vinetu1", "Karl Mai", 20),
                new Book("Vinetu2", "Karl Mai", 15),
                new Book("Sherlock Holmes", "Arthur C. Doyl", 12),
                new Book("The Lost World", "Arthur C. Doyl", 43),
                new Book("Hunger Games", "Suzan Colins", 150));

        Map<String, Double> pricesByAuthor = books
                .collect(Collectors.groupingBy(
                        IBook::getAuthor, Collectors.summingDouble(IBook::getPrice)));

        Comparator<Map.Entry<String, Double>> pricesDecreasing =
                (e1, e2) -> e2.getValue().compareTo(e1.getValue());
        Comparator<Map.Entry<String, Double>> pricesDecreasingAndNamesAscending =
                pricesDecreasing.thenComparing((e1, e2) -> e1.getKey().compareTo(e2.getKey()));

        pricesByAuthor.entrySet().stream().sorted(pricesDecreasingAndNamesAscending)
                .forEach(System.out::println);

    }
}
