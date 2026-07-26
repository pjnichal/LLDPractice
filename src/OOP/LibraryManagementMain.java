package OOP;

class Book {
    // Add private fields: title (String), author (String), isbn (String), isAvailable (boolean)
    private String title,author,isbn;
    private boolean isAvailable;
    public Book(String title, String author, String isbn) {
        // Initialize fields. Book starts as available.
        this.title=title;
        this.author=author;
        this.isbn=isbn;
        this.isAvailable=true;
    }

    public boolean borrowBook() {
        // Mark book as unavailable if currently available
        // Return true if successful, false if already borrowed
        if(!this.isAvailable) return false;
        this.isAvailable=false;
        return true;
    }

    public void returnBook() {
        // Mark book as available
        this.isAvailable=true;
    }

    public void displayInfo() {
        // Print: "Title by Author (ISBN: isbn) - Available" or "- Borrowed"
        String status= isAvailable ? "Available" : "Borrowed";
        String displayMessage=this.title+" by "+this.author+" (ISBN: "+this.isbn+") - "+status;
        System.out.println(displayMessage);
    }
}

// Test your implementation
public class LibraryManagementMain {
    public static void main(String[] args) {
        Book book = new Book("The Pragmatic Programmer", "David Thomas", "978-0135957059");
        book.displayInfo();

        boolean success = book.borrowBook();
        System.out.println("Borrow successful: " + success);
        book.displayInfo();

        success = book.borrowBook();
        System.out.println("Borrow successful: " + success);

        book.returnBook();
        book.displayInfo();
    }
}