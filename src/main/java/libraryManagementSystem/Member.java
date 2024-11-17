package libraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String id;
    private String name;
    private List<Loan> loanHistory;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.loanHistory = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Loan> getLoanHistory() {
        return new ArrayList<>(loanHistory);
    }

    public void addLoan(Loan loan) {
        loanHistory.add(loan);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", loanHistory=" + loanHistory.size() + " loans" +
                '}';
    }
}
