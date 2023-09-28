package _09IteratorsAndComparators._01Lab._03ComparableBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the End", 2002);
        Book bookFour = new Book("The Documents in the End", 1950);

        System.out.println(bookOne.compareTo(bookTwo));

        List<Book> books = new ArrayList<>();

        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        books.add(bookFour);

        Collections.sort(books);

        for (Book book : books) {
            System.out.println(book.getTitle() + " " + book.getYear());
        }

//        int result = bookOne.getYear() < bookTwo.getYear() ? -1 : (bookOne.getYear() == bookTwo.getYear() ? 0 : 1);
    }
}
