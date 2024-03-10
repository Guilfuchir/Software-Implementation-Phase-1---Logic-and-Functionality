import java.util.ArrayList;
import java.util.Scanner;

// Book class to represent individual books
class Book {
    private String title;
    private String author;
    private String barcode;
    private boolean checkedOut;
    private String dueDate;

   
    public Book(String title, String author, String barcode) {
        this.title = title;
        this.author = author;
        this.barcode = barcode;
        this.setCheckedOut(false);
        this.dueDate = null;
    }

   
    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }

    
    public String getBarcode() {
        return barcode;
    }

    // Method to check out the book
    public void checkOut() {
        setCheckedOut(true);
        
        
        
        // calculation
        dueDate = "Set due date 4 weeks from current date";
    }

    
    public void checkIn() {
        setCheckedOut(false);
        dueDate = null; 
    }

    
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Barcode: " + barcode + ", Checked Out: " + isCheckedOut()
                + ", Due Date: " + dueDate;
    }

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
}

// Library class to manage a collection of books
class Library {
    private ArrayList<Book> books;

    
    public Library() {
        
        books = new ArrayList<>();
    }

    
    public void addBook(Book book) {
        
        books.add(book);
    }

    // Method to remove a book from the library by barcode
    public void removeBookByBarcode(String barcode) {
        // Iterate through the books and remove the book with the given barcode
        for (Book book : books) {
            if (book.getBarcode().equals(barcode)) {
                books.remove(book);
                break;
            }
        }
    }

    // Method to remove a book from the library by title
    public void removeBookByTitle(String title) {
        // Iterate through the books and remove the book with the given title
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                break;
            }
        }
    }

    // Method to check out a book from the library
    public void checkOutBook(String title) {
        // Iterate through the books and check out the book with the given title
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (!book.isCheckedOut()) {
                    book.checkOut();
                    System.out.println("Book checked out successfully.");
                } else {
                    System.out.println("Error: Book is already checked out.");
                }
                break;
            }
        }
    }

    // Method to check in a book to the library
    public void checkInBook(String title) {
        // Iterate through the books and check in the book with the given title
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.checkIn();
                System.out.println("Book checked in successfully.");
                break;
            }
        }
    }

    // Method to print the list of books in the library
    public void printBooks() {
        // Print the details of all books in the library
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

// Main class containing the main method to run the program
public class LibraryManagementSystem {
    public static void main(String[] args) {
        
        Library library = new Library();

        
        Scanner scanner = new Scanner(System.in);

        
       

        
        System.out.println("Initial list of books:");
        library.printBooks();

       
        System.out.print("Enter the barcode of the book to remove: ");
        String barcodeToRemove = scanner.nextLine();
        library.removeBookByBarcode(barcodeToRemove);
        System.out.println("Book with barcode " + barcodeToRemove + " removed.");

        
        System.out.println("Updated list of books:");
        library.printBooks();

        
        System.out.print("Enter the title of the book to remove: ");
        String TitleToRemove = scanner.nextLine();
        library.removeBookByTitle(TitleToRemove);
        System.out.println("Book with the title " + TitleToRemove + " removed.");

        
        System.out.println("Updated list of books:");
        library.printBooks();

       
        System.out.print("Enter the title of the book to check out: ");
        String titleToCheckout = scanner.nextLine();
        library.checkOutBook(titleToCheckout);

        
        System.out.println("Updated list of books after check out:");
        library.printBooks();

       
        System.out.print("Enter the title of the book to check in: ");
        String titleToCheckin = scanner.nextLine();
        library.checkInBook(titleToCheckin);

        
        System.out.println("Updated list of books after check in:");
        library.printBooks();

        
        scanner.close();
    }
}
