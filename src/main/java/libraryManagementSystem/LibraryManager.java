package libraryManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Book> books;
    private List<Member> members;
    private List<Loan> loans;

    public LibraryManager() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (books.stream().anyMatch(b -> b.getIsbn().equals(book.getIsbn()))) {
            System.out.println("A book with ISBN " + book.getIsbn() + " already exists.");
        } else {
            books.add(book);
            System.out.println("Book added: " + book.getTitle());
        }
    }

    public void removeBook(String isbn) {
        if (books.removeIf(book -> book.getIsbn().equals(isbn))) {
            System.out.println("Book with ISBN " + isbn + " removed.");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    public Book searchBookByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    public Book getBook(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(null);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void registerMember(Member member) {
        if (members.stream().anyMatch(m -> m.getId().equals(member.getId()))) {
            System.out.println("Member with ID " + member.getId() + " already exists.");
        } else {
            members.add(member);
            System.out.println("Member registered: " + member.getName());
        }
    }

    public List<Member> getMembers() {
        return members;
    }

    public void borrowBook(Book book, Member member) {
        if (!books.contains(book)) throw new IllegalArgumentException("The book does not exist in the library.");
        if (!members.contains(member)) throw new IllegalArgumentException("The member is not registered.");
        if (!book.isAvailable()) throw new IllegalStateException("Book is already on loan.");

        Loan loan = new Loan(book, member, LocalDate.now(), LocalDate.now().plusWeeks(2));
        loans.add(loan);
        member.addLoan(loan);
        book.setAvailable(false);
        System.out.println("Book borrowed: " + book.getTitle());
    }

    public void returnBook(Book book) {
        Loan loan = loans.stream().filter(l -> l.getBookDetails().equals(book)).findFirst().orElse(null);
        if (loan != null) {
            loan.markAsReturned();
            loans.remove(loan);
            book.setAvailable(true);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("The book is not currently on loan.");
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            books.forEach(Book::displayInfo);
        }
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered in the library.");
        } else {
            members.forEach(System.out::println);
        }
    }

    public void displayLoans() {
        if (loans.isEmpty()) {
            System.out.println("No books currently on loan.");
        } else {
            loans.forEach(System.out::println);
        }
    }

    public List<Loan> getLoans() {
        return loans;
    }
}