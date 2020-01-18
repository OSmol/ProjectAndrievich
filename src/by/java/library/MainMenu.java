package library;

import library.bean.Book;
import library.bean.User;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private static String getMainOptions(User.UserRole userRole) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAvailable options:\n").append("1. View books in the catalog.\n");
        sb.append("2. Find a book in the catalog.\n");
        if(userRole == User.UserRole.ADMIN) {
            sb.append("3. Add a book to the catalog.\n");
            sb.append("4. Remove book from catalog.\n");
            sb.append("5. Register a new user.\n");
            sb.append("6. Delete user.\n");
        } else {
            sb.append("3. Suggest an administrator to add a book.\n");
        }
        sb.append("9. Change user\n");
        sb.append("0. To finish work.\n");
        return sb.toString();
    }
    private static boolean entrance() {
        User user = new User();
        List<Book> books = new ArrayList<>();
        while (user == null) {
            System.out.print("Enter login: ");
            String username = user.getLogin();
            System.out.print("Enter password: ");
            String password = user.getPassword();

            if(user == null) {
                System.out.println("Wrong login or password. Try again.");
            }
        }

        return true;
    }

}
