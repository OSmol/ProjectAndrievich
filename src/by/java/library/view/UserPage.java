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

public class UserPage implements Page {
    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAvailable options:\n");
        sb.append("6. Add a new user.\n");
        sb.append("7. Delete user.\n");
        sb.append("8. Find user.\n");
        sb.append("9. Update user\n");
        sb.append("10. Show all users.\n");
        sb.append("0. To finish work.\n");
        System.out.println(sb.toString());
        Scanner sc = new Scanner(System.in);
        String result = sc.next();

        switch (result) {

            case "6":
                addUser();
                break;
            case "7":
                deleteUser();
                break;
            case "8":
                findUser();
                break;
            case "9":
                updateUser();
                break;
            case "10":
                showAllUsers();
                break;
            case "0":
                finishWork();
                break;
        }
            }

    private void finishWork() {
        System.out.println("Work with users finished!");
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
        System.out.println();
    }

    private void findUser() {
        Request request = new Request();
        Command command = new DeleteUserCommand();
        System.out.println("Enter login user");
        String login = ScannerHelper.inputStringFromConsole();
        request.getBody().put("login", login);
        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
    }

    private void updateUser() {
        Request request = new Request();
        Command command = new UpdateUserCommand();
        System.out.println("Enter id user");
        int id = ScannerHelper.inputInt();
        request.getBody().put("id", id);
        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
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
        System.out.println();
    }
}
