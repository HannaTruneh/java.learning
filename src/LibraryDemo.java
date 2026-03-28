import java.util.List;
import java.util.ArrayList;


abstract class Book {

    String title;
    int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    abstract void bookInfo();
}

class FictionBook extends Book {
    String genre;

    public FictionBook(String title, int pages, String genre) {
        super(title, pages);
        this.genre = genre;
    }

    @Override
    void bookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Pages: " + pages);
        System.out.println("Genre: " + genre);
    }
}

class NonFictionBook extends Book {
    String subject;

    public NonFictionBook(String title, int pages, String subject) {
        super(title, pages);
        this.subject = subject;
    }

    @Override
    void bookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Pages: " + pages);
        System.out.println("Subject: " + subject);
    }
}

interface Librarian {
    String getName();

    void addBook(Book book);
}


class LibraryStaff implements Librarian {
    private String name;
    private List<Book> books;

    public LibraryStaff(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }


    @Override
    public String getName() {
        return name;
    }


    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    public void printBooks() {
        for (Book book : books) {
            book.bookInfo();
            System.out.println("-------------------");
        }
    }
}
        public class LibraryDemo {
            public static void main(String[] args) {
                LibraryStaff librarian = new LibraryStaff("Alice");
                FictionBook fictionBook = new FictionBook("The Great Gatsby", 180, "Classic");
                NonFictionBook nonFictionBook = new NonFictionBook("Sapiens", 400, "History");

                librarian.addBook(fictionBook);
                librarian.addBook(nonFictionBook);

                librarian.printBooks();

            }
        }





