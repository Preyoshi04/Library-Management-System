package Library;
import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String name;
    private String bookId;
    private boolean isIssued;

    public Book(String name, String bookId) {
        this.name = name;
        this.bookId = bookId;
        this.isIssued = false;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return bookId;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    public void display() {
        System.out.println("----------------------------------------");
        System.out.println("Book Name : " + name);
        System.out.println("Book ID   : " + bookId);
        System.out.println("Status    : " + (isIssued ? "Issued" : "Available"));
        System.out.println("----------------------------------------");
    }

    @Override
    public String toString() {
        return name + " (ID: " + bookId + ")";
    }
}

// User class
class User {
    private String name;
    private String id;
    private ArrayList<Book> booksBorrowed = new ArrayList<>();
    private static final int BORROW_LIMIT = 3;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public boolean borrowBook(Book book) {
        if (booksBorrowed.size() >= BORROW_LIMIT) {
            System.out.println("Cannot borrow more than " + BORROW_LIMIT + " books.");
            return false;
        }
        booksBorrowed.add(book);
        return true;
    }

    public void returnBook(Book book) {
        booksBorrowed.remove(book);
    }

    public void displayBorrowBooks() {
        if (booksBorrowed.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book bk : booksBorrowed) {
                System.out.println("- " + bk);
            }
        }
    }
}

// Library class
class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getName() + "' added successfully.");
    }

    public void removeBook(String id) {
        Book book = findById(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Book '" + book.getName() + "' removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public boolean issueBook(String id) {
        Book book = findById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        } else if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return false;
        } else {
            book.issueBook();
            return true;
        }
    }

    public boolean returnBook(String id) {
        Book book = findById(id);
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        } else if (!book.isIssued()) {
            System.out.println("Book was not issued.");
            return false;
        } else {
            book.returnBook();
            return true;
        }
    }

    public Book findById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }

    public void display() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book b : books) {
                b.display();
            }
        }
    }
}

// Main class
public class Library_Management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        ArrayList<User> users = new ArrayList<>();
        int choice;

        System.out.println("=======================================");
        System.out.println("  WELCOME TO LIBRARY MANAGEMENT SYSTEM ");
        System.out.println("=======================================");

        do {
            System.out.println("\n--------------- MENU ---------------");
            System.out.println("1: Add a Book");
            System.out.println("2: Remove a Book");
            System.out.println("3: Issue a Book to User");
            System.out.println("4: Return a Book from User");
            System.out.println("5: Register a User");
            System.out.println("6: View All Books");
            System.out.println("7: View All Users");
            System.out.println("8: Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Name: ");
                    String bookName = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();
                    lib.addBook(new Book(bookName, bookId));
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    String removeId = sc.nextLine();
                    lib.removeBook(removeId);
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    String userId = sc.nextLine();
                    User user = findUser(users, userId);
                    if (user == null) {
                        System.out.println("User not found.");
                        break;
                    }

                    System.out.print("Enter Book ID to issue: ");
                    String bookToIssueId = sc.nextLine();
                    Book bookToIssue = lib.findById(bookToIssueId);
                    if (bookToIssue == null) {
                        System.out.println("Book not found.");
                    } else if (bookToIssue.isIssued()) {
                        System.out.println("Book already issued.");
                    } else {
                        if (user.borrowBook(bookToIssue)) {
                            lib.issueBook(bookToIssueId);
                            System.out.println("Book issued to " + user.getName());
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    String returnUserId = sc.nextLine();
                    User returnUser = findUser(users, returnUserId);
                    if (returnUser == null) {
                        System.out.println("User not found.");
                        break;
                    }

                    System.out.print("Enter Book ID to return: ");
                    String returnBookId = sc.nextLine();
                    Book returnBook = lib.findById(returnBookId);
                    if (returnBook == null) {
                        System.out.println("Book not found.");
                    } else if (!returnUser.getBooksBorrowed().contains(returnBook)) {
                        System.out.println("User did not borrow this book.");
                    } else {
                        returnUser.returnBook(returnBook);
                        lib.returnBook(returnBookId);
                        System.out.println("Book returned successfully.");
                    }
                    break;

                case 5:
                    System.out.print("Enter User Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter User ID: ");
                    String uid = sc.nextLine();
                    users.add(new User(uname, uid));
                    System.out.println("User registered.");
                    break;

                case 6:
                    lib.display();
                    break;

                case 7:
                    if (users.isEmpty()) {
                        System.out.println("No users registered.");
                    } else {
                        for (User u : users) {
                            System.out.println("----------------------------------");
                            System.out.println("Name: " + u.getName());
                            System.out.println("ID  : " + u.getId());
                            System.out.println("Books Borrowed: " + u.getBooksBorrowed().size());
                            u.displayBorrowBooks();
                            System.out.println("----------------------------------");
                        }
                    }
                    break;

                case 8:
                    System.out.println("Exiting system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 8);

        sc.close();
    }

    private static User findUser(ArrayList<User> users, String id) {
        for (User u : users) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }
}
