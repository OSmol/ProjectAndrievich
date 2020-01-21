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
        sb.append("5. Register a new user.\n");
        sb.append("6. Delete user.\n");
        sb.append("9. Change user\n");
        sb.append("0. To finish work.\n");
        System.out.println(sb.toString());
        Scanner sc = new Scanner(System.in);
        String result = sc.next();
        Response response = new Response();
        Request request = new Request();
        switch (result) {

            case "6":
                registerUser(request);
                break;
            case "7":
                deleteUser(request);
                break;
            case "8":
                findUser(request);
                break;
            case "9":
                updateUser(request);
                break;
            case "0":
                finishWork();
                break;
        }

        return null;
    }


    private void registerUser(Request request) {
        Command command = new RegistrationCommand();
        System.out.println("Enter name: ");
        String name = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter email: ");
        String email = ScannerHelper.inputStringFromConsole();
        request.getBody().put("name", name);
        request.getBody().put("email", email);
        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        System.out.println("User registered.");
    }

    private void deleteUser(Request request) {

        Command deleteUserCommand = new DeleteUserCommand();
        System.out.println("Enter id user");
        int id = ScannerHelper.inputInt();
        request.getBody().put("id", id);
        Response response = deleteUserCommand.execute(request);
        System.out.println(response.getResponseCode());
    }

    private void findUser(Request request) {
        Command command = new DeleteUserCommand();
        System.out.println("Enter login user");
        String login = ScannerHelper.inputStringFromConsole();
        request.getBody().put("login", login);
        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
    }

    private void updateUser(Request request) {
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
