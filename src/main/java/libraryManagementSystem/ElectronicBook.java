package libraryManagementSystem;

public class ElectronicBook extends Book {
    private double fileSizeMB;

    public ElectronicBook(String title, String author, String isbn, double fileSizeMB) {
        super(title, author, isbn, 0); // מספר עמודים 0 לספרים אלקטרוניים
        if (fileSizeMB <= 0) throw new IllegalArgumentException("File size must be greater than 0 MB");
        this.fileSizeMB = fileSizeMB;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(double fileSizeMB) {
        if (fileSizeMB <= 0) throw new IllegalArgumentException("File size must be greater than 0 MB");
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("File Size: " + fileSizeMB + " MB");
    }

    @Override
    public String toString() {
        return super.toString() + ", File Size: " + fileSizeMB + " MB";
    }
}
