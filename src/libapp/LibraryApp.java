package libapp;
import java.util.ArrayList;

public class LibraryApp {
    private BookRepository bookRepo = new BookRepository();

    public void searchByIsbn(String isbn){
       Book book = bookRepo.findByIsbn(isbn);
       if(book != null){
           System.out.printf("Book found: \n\tTitle: %s\n\tGenre: %s\n\tAuthor: %s", book.getTitle(), book.getGenre(), book.getAuthor());
       }else{
           System.out.printf("Book not found");
       }
       System.out.print("\n\n");
    }

    public void searchByTitle(String keyword){
        System.out.printf("Searching for books containing '%s'\n", keyword);
        ArrayList<Book> books = bookRepo.findByTitle(keyword);
        if(!books.isEmpty()){
            System.out.printf("%s books found%s", books.size(), (books.size() > 0) ? ":" : ".");
            for (Book book : books){
                System.out.printf("\n\tTitle: %s\n\tGenre: %s\n\tAuthor: %s\n", book.getTitle(), book.getGenre(), book.getAuthor());
                System.out.print("---------");
            }
        }else{
            System.out.printf("Book not found");
        }
        System.out.print("\n\n");
    }

    public void checkOutBook(String isbn){
        Book book = bookRepo.findByIsbn(isbn);
        if(book != null){
            book.checkOut();
            if(book.checkOut()){
                System.out.println("Checking out book");
            }else{
                System.out.println("Could not check out book. More books checked out than recorded quantity");
            }
            System.out.printf("Book\n\tTitle: %s\n\tGenre: %s\n\tAuthor: %s\n", book.getTitle(), book.getGenre(), book.getAuthor());
            System.out.println("checked out.");
        }else{
            System.out.printf("ISBN %s not found.\n", isbn);
        }
    }

    public void checkInBook(String isbn){
        Book book = bookRepo.findByIsbn(isbn);
        if(book != null){
            book.checkIn();
            System.out.printf("Book\n\tTitle: %s\n\tGenre: %s\n\tAuthor: %s\n", book.getTitle(), book.getGenre(), book.getAuthor());
            System.out.println("checked in.");
        }else{
            System.out.printf("ISBN %s not found.\n", isbn);
        }
    }
}
