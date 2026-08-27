package Task4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static Optional<String> findLongestBookTitle(List<Book> books) {
        return books.stream()
                .map(Book::getTitle)
                .max(Comparator.comparingInt(String::length));

    }

    public  static  Optional<String> findMostPages(List<Book> books) {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPageCount))
                .map(Book::getTitle);
    }

    static void main(String[] args) {
        List<Book> books = List.of(
                new Book(1L, "Clean Code", "Anar", 200),
                new Book(2L, "Effective Java", "Arzu", 400),
                new Book(3L, "Design Patterns", "Ali", 250),
                new Book(4L, "Java Concurrency in Practice", "Adam", 300)

                ) ;

        Optional<String> result = findLongestBookTitle(books) ;
        System.out.println(result);

        Optional<String> result2 = findMostPages(books) ;
        System.out.println(result2);

    }

}
