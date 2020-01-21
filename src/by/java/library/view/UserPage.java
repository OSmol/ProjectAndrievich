package library.view;

import javatrDay5.helper.ScannerHelper;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.DeleteUserCommand;
import library.controller.command.impl.RegistrationCommand;
import library.controller.command.impl.UpdateUserCommand;

import java.util.Scanner;

public class UserPage implements Page {
    @Override
    public Request run() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAvailable options:\n");
        sb.append("6. Register a new user.\n");
        sb.append("7. Delete user.\n");
        sb.append("8. Find user.\n");
        sb.append("9. Update user\n");
        sb.append("0. To finish work.\n");
        System.out.println(sb.toString());
        Scanner sc = new Scanner(System.in);
        String result = sc.next();

        switch (result) {

            case "6":
                registerUser();
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
            case "0":
                finishWork();
                break;
        }

        return null;
    }


    private Response registerUser() {
        Request request = new Request();
        Command command = new RegistrationCommand();
        System.out.println("Enter name: ");
        String name = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter email: ");
        String email = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter new login: ");
        String login = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter new password: ");
        String password = ScannerHelper.inputStringFromConsole();
        request.getBody().put("name", name);
        request.getBody().put("email", email);
        request.getBody().put("login", login);
        request.getBody().put("password", password);
        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        System.out.println("User registered.");
        return response;
    }

    private void deleteUser() {
        Request request = new Request();
        Command deleteUserCommand = new DeleteUserCommand();
        System.out.println("Enter id user");
        int id = ScannerHelper.inputInt();
        request.getBody().put("id", id);
        Response response = deleteUserCommand.execute(request);
        System.out.println(response.getResponseCode());
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

    private void finishWork() {
    }
}
