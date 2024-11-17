package libraryManagementSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LibraryManagerTest {

    @Test
    public void testAddBook() {
        LibraryManager manager = new LibraryManager();
        Book book = new Book("Title", "Author", "ISBN123", 200);
        manager.addBook(book);
        assertEquals(1, manager.getBooks().size());
    }
}
