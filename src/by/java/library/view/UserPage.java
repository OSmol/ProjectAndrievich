package library.view;

import javatrDay5.helper.ScannerHelper;
import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.*;

import java.util.List;
import java.util.Scanner;

public final class UserPage implements Page {
    private static UserPage instance;
    private StringBuilder sb;
    Scanner sc = new Scanner(System.in);

    private UserPage() {
        sb = new StringBuilder();
        sb.append("\nAvailable options:\n");
        sb.append("1. Add a new user.\n");
        sb.append("2. Delete user.\n");
        sb.append("3. Find user.\n");
        sb.append("4. Update user\n");
        sb.append("5. Show all users.\n");
        sb.append("6. Go to Book menu.\n");
        sb.append("7. Go to Main menu.\n");
        sb.append("0. To finish work.\n");
    }

    public static synchronized UserPage getInstance() {
        if (instance == null) {
            instance = new UserPage();
        }
        return instance;
    }

    @Override
    public void run() {
        int result = 1;
        while (result != 0) {
            System.out.println(sb.toString());
            result = Integer.parseInt(sc.next());
            switch (result) {
                case 1:
                    addUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    findUserByLogin();
                    break;
                case 4:
                    updateUser();
                    break;
                case 5:
                    showAllUsers();
                    break;
                case 6:
                    goToBookMenu();
                    return;
                case 7:
                    goToMainMenu();
                    return;
                case 0:
                    finishWork();
                    break;
            }
        }
    }

    private void finishWork() {
        System.out.println("Work with users finished! \n");
    }

    private void goToMainMenu() {
        MainPage mainPage = MainPage.getInstance();
        mainPage.run();
    }

    private void goToBookMenu() {
        BookPage bookPage = BookPage.getInstance();//вызвали синглетон
        bookPage.run();
    }

    private void addUser() {
        Command command = AddUserCommand.getInstance();
        Request request = new Request();
        System.out.println("Enter login");
        String login = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter password");
        String password = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter name: ");
        String name = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter email: ");
        String email = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter locale: ");
        String locale = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter role: ");
        String role = ScannerHelper.inputStringFromConsole();

        request.getBody().put("login", login);
        request.getBody().put("password", password);
        request.getBody().put("name", name);
        request.getBody().put("email", email);
        request.getBody().put("locale", locale);
        request.getBody().put("userRole", role);

        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        System.out.println("\n Please, make your choice!");
    }

    private void deleteUser() {
        Request request = new Request();
        Command deleteUserCommand = DeleteUserByLoginCommand.getInstance();
        System.out.println("Enter user login");
        String login = ScannerHelper.inputStringFromConsole();
        request.getBody().put("login", login);
        Response response = deleteUserCommand.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            List<User> list = (List<User>) response.getBody().get("list");
            for (User user : list) {
                System.out.println(user);
            }
            System.out.println("\n Please, make your choice!");
        }
    }

    private void findUserByLogin() {
        Request request = new Request();
        Command command = GetUserByLoginCommand.getInstance();
        System.out.println("Enter login user");
        String login = ScannerHelper.inputStringFromConsole();
        request.getBody().put("login", login);
        Response response = command.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            System.out.println(response.getBody().get("user"));
        }
        System.out.println("\n Please, make your choice!");
    }

    private void updateUser() {
        Request request = new Request();
        Command command = UpdateUserCommand.getInstance();
        System.out.println("Enter id user");
        int id = ScannerHelper.inputInt();
        request.getBody().put("id", id);
        Response response = command.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            System.out.println(response.getBody().get("list"));
        }
        System.out.println("\n Please, make your choice!");
    }

    private void showAllUsers() {
        Request request = new Request();
        Command userCommand = GetUsersCommand.getInstance();
        Response response = userCommand.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            List<User> list = (List<User>) response.getBody().get("list");
            for (User user : list) {
                System.out.println(user);
            }
            System.out.println("\n Please, make your choice!");
        }
    }
}
