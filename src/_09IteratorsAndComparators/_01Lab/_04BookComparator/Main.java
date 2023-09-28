package _09IteratorsAndComparators._01Lab._04BookComparator;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the End", 2002);
        Book bookFour = new Book("The Documents in the End", 1950);

        List<Book> books = new ArrayList<>();

        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        books.add(bookFour);

        //Sort using lambda function
        books.sort((f, s) -> {
            int result = f.getTitle().compareTo(s.getTitle());

            if(result == 0) {
                result = Integer.compare(f.getYear(), s.getYear());
            }

            return result;
        });

        //Sort using Comparator chain
        books.sort(Comparator.comparing((Book e) -> e.getTitle()).thenComparingInt(Book::getYear));

        //Sort using custom Comparator
        books.sort(new BookComparator());

        for (Book book : books) {
            System.out.println(book.getTitle() + " " + book.getYear());
        }
    }
}
