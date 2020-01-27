package library.view;

import javatrDay5.helper.ScannerHelper;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.RegistrationCommand;
import library.controller.command.impl.SignInCommand;

import java.util.Scanner;

public final class SecurityPage implements Page {
    private static SecurityPage instance;
    private StringBuilder sb;
    Scanner sc = new Scanner(System.in);

    private SecurityPage() {
        sb = new StringBuilder();
        sb.append("\nAvailable options:\n");
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
                    break;
                case 2:
                    signIn();
                    break;
                case 3:
                    signOut();
                    break;
                case 0:
                    finishWork();
                    break;
            }
        }
    }

    public void registration() {
        //ввести логин и пароль, проверить, новые они или нет,
        // если новые - записать их в файл, "данные записаны" и перейти на меню мэйн - добавить нового пользователя
        // если данные есть - "логин и пароль уже существуют" и перейти на меню секьюрити
        Command command = new RegistrationCommand();
        System.out.println("Enter login: ");
        String login = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter password: ");
        String password = ScannerHelper.inputStringFromConsole();
        Request request = new Request();
        request.getBody().put("login", login);
        request.getBody().put("password", password);

        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
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
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }

    }

    //перейти на signIn
    public void signOut() {

    }

    private void finishWork() {
        System.out.println("Work with users finished! \n");
    }

    private void goToMainMenu() {
        MainPage mainPage = MainPage.getInstance();
        mainPage.run();
    }
}
