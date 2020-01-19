package library;

import library.bean.Book;
import library.bean.Library;
import library.bean.User;
import library.dao.exception.DAOException;
import library.dao.impl.txt.TxtUserDAOImpl;
import library.service.impl.LibraryServiceImpl;
import library.service.util.FileHelper;
import library.service.util.InputUtil;

import java.util.List;

public class MainMenu {
    private static User user = new User();
    private static Library library = null;
    private static TxtUserDAOImpl txtUserDAO = new TxtUserDAOImpl();

    public static boolean entrance() {
        User user = null;
        while (user == null) {
            System.out.print("Enter login: ");
            String username = InputUtil.checkInputLine();
            System.out.print("Enter password: ");
            String password = InputUtil.checkInputLine();
            user = new User.Security(username, password);
            if (user == null) {
                System.out.println("Wrong login or password. Try again.");
            }
        }
        List<Book> books = FileHelper.loadBooks();
        library = new Library(user, books);
        return true;
    }

    private static void performOperation(int option) throws DAOException {
        switch (option) {
            case 1:
                if (!LibraryServiceImpl.printBooks(library.getBooks())) {
                    System.out.println("The catalog is empty.\n");
                }
                break;
            case 2:
                while (!LibraryServiceImpl.findBook(library)) {
                    System.out.println("Error in request, try again.");
                }
                break;
            case 3:
                Book book = LibraryServiceImpl.createBook();
                if (library.getUser().getUserRole() == User.UserRole.ADMIN) {
                    if (LibraryServiceImpl.addBook(library, book)) {
                        System.out.println("Book successfully added.");
                    } else {
                        System.out.println("The book is already in the catalog.\n");
                    }
                } else {
                    if (LibraryServiceImpl.suggestBook(library, book)) {
                        System.out.println("The book was sent to the administrator by e-mail.");
                    } else {
                        System.out.println("The book is already in the catalog.\n");
                    }
                }
                break;
            case 4:
                Book removeBook = LibraryServiceImpl.createBook();
                if (LibraryServiceImpl.removeBook(library, removeBook)) {
                    System.out.println("Book successfully deleted from catalog.");
                } else {
                    System.out.println("The catalog doesn't contain this book!");
                }
                break;
            case 5:
                if (txtUserDAO.add(user)) {
                    System.out.println("New user added successfully.");
                }
                break;
            case 6:
                if (txtUserDAO.delete(user)) {
                    System.out.println("User successfully deleted.");
                }
                break;
            case 9:
                if (entrance()) {
                    System.out.println("Good day, " + library.getUser().getName() + "!");
                }

        }
    }
}
