package library.view;

import library.controller.Request;
import library.controller.Response;
import library.controller.command.impl.DeleteUserCommand;
import library.controller.command.impl.RegistrationCommand;

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


    private void registerUser(Request request) {
        RegistrationCommand command = new RegistrationCommand();
        command.execute(request);
        System.out.println("User registered.");
    }

    private void deleteUser(Request request) {
        System.out.println();
        DeleteUserCommand deleteUserCommand = new DeleteUserCommand();
        deleteUserCommand.execute(request);
    }

    private void findUser() {
    }

    private void updateUser() {
    }

    private void finishWork() {
    }
}
