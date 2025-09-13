import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Book
class Book {
    int id;
    String title;
    String author;
    boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // by default available
    }

    public void displayBook() {
        System.out.println(id + " - " + title + " by " + author + " | Available: " + isAvailable);
    }
}

// Class representing the Library
class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added successfully!");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("⚠ No books in library!");
        } else {
            for (Book b : books) {
                b.displayBook();
            }
        }
    }

    public void borrowBook(int id) {
        for (Book b : books) {
            if (b.id == id && b.isAvailable) {
                b.isAvailable = false;
                System.out.println("📖 You borrowed: " + b.title);
                return;
            }
        }
        System.out.println("❌ Book not available!");
    }

    public void returnBook(int id) {
        for (Book b : books) {
            if (b.id == id && !b.isAvailable) {
                b.isAvailable = true;
                System.out.println("🔄 Book returned: " + b.title);
                return;
            }
        }
        System.out.println("❌ Invalid return operation!");
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.showBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowId = sc.nextInt();
                    library.borrowBook(borrowId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 5:
                    System.out.println("👋 Exiting system...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("⚠ Invalid choice!");
            }
        }
    }
}