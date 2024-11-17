package libraryManagementSystem;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int numberOfPages;
    private boolean isAvailable;

    public Book(String title, String author, String isbn, int numberOfPages) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty");
        if (author == null || author.isEmpty()) throw new IllegalArgumentException("Author cannot be null or empty");
        if (isbn == null || isbn.isEmpty()) throw new IllegalArgumentException("ISBN cannot be null or empty");
        if (numberOfPages <= 0) throw new IllegalArgumentException("Number of pages must be greater than 0");
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty");
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) throw new IllegalArgumentException("Author cannot be null or empty");
        this.author = author;
    }

    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages < 0) throw new IllegalArgumentException("Number of pages must be non-negative");
        this.numberOfPages = numberOfPages;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        if (numberOfPages > 0) {
            System.out.println("Type: Printed Book");
            System.out.println("Number of Pages: " + numberOfPages);
        } else {
            System.out.println("Type: Book (No specific page count)");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
