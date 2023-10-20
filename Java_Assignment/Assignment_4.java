import java.util.Scanner;

class Book {
    private int bookId;
    private String bookTitle;
    private int yearOfPublication;
    private String authorName;
    private String publisherName;
    private int numberOfAvailableCopies;
    private int totalCopies;

    
    public Book() {
        
    }

    public Book(int totalCopies) {
        this.totalCopies = totalCopies;
        this.numberOfAvailableCopies = totalCopies;
    }

    // Set book details
    public void setDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Book ID: ");
        bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Book Title: ");
        bookTitle = scanner.nextLine();
        System.out.print("Enter Year of Publication: ");
        yearOfPublication = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Author Name: ");
        authorName = scanner.nextLine();
        System.out.print("Enter Publisher Name: ");
        publisherName = scanner.nextLine();
    }

    public void setDetails(int id, String title, int year, String author, String publisher, int count) {
        bookId = id;
        bookTitle = title;
        yearOfPublication = year;
        authorName = author;
        publisherName = publisher;
        totalCopies = count;
        numberOfAvailableCopies = count;
    }

    
    public void getDetails(int id) {
        if (id == bookId) {
            System.out.println("Book ID: " + bookId);
            System.out.println("Title: " + bookTitle);
            System.out.println("Year of Publication: " + yearOfPublication);
            System.out.println("Author: " + authorName);
            System.out.println("Publisher: " + publisherName);
            System.out.println("Total Copies: " + totalCopies);
            System.out.println("Available Copies: " + numberOfAvailableCopies);
        } else {
            System.out.println("Book not found.");
        }
    }


    public void issue(int id) {
        if (id == bookId) {
            if (numberOfAvailableCopies > 0) {
                numberOfAvailableCopies--;
                System.out.println("Book issued successfully.");
            } else {
                System.out.println("No copies available to issue.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    
    public void returnBook(int id) {
        if (id == bookId) {
            if (numberOfAvailableCopies < totalCopies) {
                numberOfAvailableCopies++;
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("All copies are already returned.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    public void getBookId()
    {
        return bookId;
    }
}

 class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[5]; // Create an array of Book objects

        for (int i = 0; i < 5; i++) {
            books[i] = new Book(); // Initialize each book object
            System.out.println("Enter details for Book " + (i + 1));
            books[i].setDetails();
        }

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Set Details");
            System.out.println("2. Get Details");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID to set details: ");
                    int setId = scanner.nextInt();
                    for (Book book : books) {
                        if(book.getBookId()== setId){
                        book.setDetails();
                        break;
                    }
                    }
                    break;
                case 2:
                    System.out.print("Enter Book ID to get details: ");
                    int getId = scanner.nextInt();
                    for (Book book : books) {
                        if(book.getBookId()== getId){
                        book.getDetails();
                        break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = scanner.nextInt();
                    for (Book book : books) {
                       if(book.getBookId()== issueId){
                        book.issue();
                        break;
                       }
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    for (Book book : books) {
                        if(book.getBookId()== returnId){
                        book.returnBook();
                        break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
