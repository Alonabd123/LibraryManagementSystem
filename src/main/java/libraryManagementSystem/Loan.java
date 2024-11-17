package libraryManagementSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
    private final Book book;
    private final Member member;
    private final LocalDate loanDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    public Loan(Book book, Member member, LocalDate loanDate, LocalDate dueDate) {
        if (book == null || member == null) throw new IllegalArgumentException("Book and Member cannot be null.");
        if (loanDate == null || dueDate == null || loanDate.isAfter(dueDate)) throw new IllegalArgumentException("Invalid loan or due date.");
        if (!book.isAvailable()) throw new IllegalStateException("Book is not available for loan.");
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = null;
        book.setAvailable(false);
    }

    public Book getBookDetails() {
        return book;
    }

    public Member getMemberDetails() {
        return member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isOverdue() {
        return returnDate == null && LocalDate.now().isAfter(dueDate);
    }

    public void markAsReturned() {
        if (returnDate != null) throw new IllegalStateException("Book is already returned.");
        this.returnDate = LocalDate.now();
        book.setAvailable(true);
    }

    public long getOverdueDays() {
        if (!isOverdue()) return 0;
        return ChronoUnit.DAYS.between(dueDate, LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("Loan Details:\nBook: %s\nMember: %s\nLoan Date: %s\nDue Date: %s\nReturn Date: %s\nOverdue: %s",
                book.getTitle(),
                member.getName(),
                loanDate,
                dueDate,
                returnDate != null ? returnDate : "Not Returned",
                isOverdue() ? "Yes" : "No");
    }
}
