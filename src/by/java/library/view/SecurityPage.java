package library.view;

import javatrDay5.helper.ScannerHelper;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.RegistrationCommand;
import library.controller.command.impl.SignInCommand;

import java.util.Scanner;

public class SecurityPage implements Page {
    private static SecurityPage instance;
    private StringBuilder sb;
    private Scanner sc = new Scanner(System.in);

    private SecurityPage() {
        sb = new StringBuilder();
        sb.append("\nMain options:\n");
        sb.append("1. Registration. \n");
        sb.append("2. Sign in. \n");
        sb.append("3. Sign out. \n");
        sb.append("0. To finish work.\n");
    }

    public static synchronized SecurityPage getInstance() {
        if (instance == null) {
            instance = new SecurityPage();
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
                    registration();
                    return;
                case 2:
                    signIn();
                    return;
                case 3:
                    signOut();
                    return;
                case 0:
                    finishWork();
                    return;
            }
        }
    }

    public void registration() {
        //ввести логин и пароль, проверить, новые они или нет,
        // если новые - записать их в файл, "данные записаны" и перейти на меню мэйн - добавить нового пользователя
        // если данные есть - "логин и пароль уже существуют" и перейти на меню секьюрити
        System.out.println("\n Please register!\n ");
        Request request = new Request();
        Command command = new RegistrationCommand();
        System.out.println("Enter login: ");
        String login = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter password: ");
        String password = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter name: ");
        String name = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter email: ");
        String email = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter locale: ");
        String locale = ScannerHelper.inputStringFromConsole();
        request.getBody().put("login", login);
        request.getBody().put("password", password);
        request.getBody().put("name", name);
        request.getBody().put("email", email);
        request.getBody().put("locale", locale);
        Response response = command.execute(request);

        if (response.getResponseCode() == 501 || response.getResponseCode() == 401) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            System.out.println(response.getBody().get("list"));
            goToMainMenu();
        }
    }

    //ввести данные, прочитать файл, если данные совпадают - перейти на Маин меню
    public void signIn() {
        Command command = new SignInCommand();
        System.out.println("Enter login: ");
        String login = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter password: ");
        String password = ScannerHelper.inputStringFromConsole();
        Request request = new Request();
        request.getBody().put("login", login);
        request.getBody().put("password", password);
        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        if (response.getResponseCode() == 501) {//Not Implemented («не реализовано»);
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {//Created («создано»);
            System.out.println(response.getBody().get("list"));
            goToMainMenu();
        }
        if (response.getResponseCode()==403){
            registration();
        }
    }

    //перейти на signIn
    public void signOut() {
        signIn();
    }

    private void finishWork() {
        System.out.println("Work with users finished! \n");
    }

    private void goToMainMenu() {
        MainPage mainPage = MainPage.getInstance();
        mainPage.run();
    }
}
