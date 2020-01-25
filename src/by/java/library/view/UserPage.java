package library.view;

import javatrDay5.helper.ScannerHelper;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.AddUserCommand;
import library.controller.command.impl.DeleteUserCommand;
import library.controller.command.impl.GetUsersCommand;
import library.controller.command.impl.UpdateUserCommand;

import java.util.Scanner;

 class UserPage implements Page {
     private static UserPage instance;
     protected UserPage(){}
     public static synchronized UserPage getInstance(){
         if (instance==null){
             instance=new UserPage();
         }
         return instance;
     }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAvailable options:\n");
        sb.append("1. Add a new user.\n");
        sb.append("2. Delete user.\n");
        sb.append("3. Find user.\n");
        sb.append("4. Update user\n");
        sb.append("5. Show all users.\n");
        sb.append("6. Go to Book menu.\n");
        sb.append("7. Go to Main menu.\n");
        sb.append("0. To finish work.\n");
        System.out.println(sb.toString());
        Scanner sc = new Scanner(System.in);
        int result = 0;
        boolean b = false;
        do {
            result = Integer.parseInt(sc.next());
            switch (result) {

                case 1:
                    addUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    findUser();
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
                    b = true;
                default:
                    System.out.println("Go to main menu and make your choice!\n " +
                            "1. Use books menu.\n" +
                            "2. Use users menu.\n" +
                            "0. To finish work.\n");
                    return;
            }
        } while ((result != 6) && (!b));
    }

    private void finishWork() {
        System.out.println("Work with users finished! \n");
    }

    private void goToMainMenu() {
        MainPage mainPage = new MainPage();
        mainPage.run();
    }

    private void goToBookMenu() {
        BookPage bookPage = new BookPage();
        bookPage.run();
    }

    private void addUser() {
        Request request = new Request();
        Command command = new AddUserCommand();
        System.out.println("Enter login");
        String login = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter password");
        String password = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter name: ");
        String name = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter email: ");
        String email = ScannerHelper.inputStringFromConsole();

        request.getBody().put("login", login);
        request.getBody().put("password", password);
        request.getBody().put("name", name);
        request.getBody().put("email", email);

        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        System.out.println("\n Please, make your choice!");
    }

    private void deleteUser() {
        Request request = new Request();
        Command deleteUserCommand = new DeleteUserCommand();
        Response response = deleteUserCommand.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            System.out.println(response.getBody().get("list"));
        }
        System.out.println("\n Please, make your choice!");
    }

    private void findUser() {
        Request request = new Request();
        Command command = new DeleteUserCommand();
        System.out.println("Enter login user");
        String login = ScannerHelper.inputStringFromConsole();
        request.getBody().put("login", login);
        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        System.out.println("\n Please, make your choice!");
    }

    private void updateUser() {
        Request request = new Request();
        Command command = new UpdateUserCommand();
        System.out.println("Enter id user");
        int id = ScannerHelper.inputInt();
        request.getBody().put("id", id);
        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        System.out.println("\n Please, make your choice!");
    }

    private void showAllUsers() {
        Request request = new Request();
        Command userCommand = new GetUsersCommand();
        Response response = userCommand.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            System.out.println(response.getBody().get("list"));
        }
        System.out.println("\n Please, make your choice!");
    }
}
