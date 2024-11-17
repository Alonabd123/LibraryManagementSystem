package libraryManagementSystem;

import java.util.Scanner;

public class LibraryTest {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary System - Choose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register Member");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Display All Members");
            System.out.println("8. Display All Loans");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn, choice));
                }
                case 2 -> {
                    System.out.print("Enter ISBN to remove: ");
                    String isbn = scanner.nextLine();
                    library.removeBook(isbn);
                }
                case 3 -> {
                    System.out.print("Enter member ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    library.registerMember(new Member(id, name));
                }
                case 4 -> {
                    System.out.print("Enter book title to borrow: ");
                    String title = scanner.nextLine();
                    Book book = library.searchBookByTitle(title);
                    if (book != null) {
                        System.out.print("Enter member ID: ");
                        String id = scanner.nextLine();
                        Member member = library.getMembers().stream()
                                .filter(m -> m.getId().equals(id))
                                .findFirst()
                                .orElse(null);

                        if (member != null) {
                            library.borrowBook(book, member);
                        } else {
                            System.out.println("Member not found.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter book title to return: ");
                    String title = scanner.nextLine();
                    Book book = library.searchBookByTitle(title);
                    if (book != null) {
                        library.returnBook(book);
                    } else {
                        System.out.println("Book not found.");
                    }
                }
                case 6 -> library.displayAllBooks();
                case 7 -> library.displayAllMembers();
                case 8 -> library.displayLoans();
                case 0 -> {
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
