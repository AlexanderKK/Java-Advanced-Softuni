package _09IteratorsAndComparators._01Lab._02Library;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookFour = new Book("The Documents in the End", 1950);

        Library library = new Library(bookOne, bookTwo, bookThree, bookFour);

        for (Book book: library) {
            System.out.println(book.getTitle());
        }
    }
}
