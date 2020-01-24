package library.view;

import library.controller.Request;
import library.controller.Response;

import java.util.Scanner;


public class MainPage implements Page {
    @Override
    public Request run() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nMain options:\n");
        sb.append("1. Use books menu.\n");
        sb.append("2. Use users menu.\n");
        System.out.println(sb.toString());
        Scanner sc = new Scanner(System.in);
        String result = sc.next();

        switch (result) {
            case "1":
                useBooksmenu();
                break;
            case "2":
                useUsersMenu();
                break;
        }
        return null;
    }

    private void useBooksmenu() {

        BookPage bookPage = new BookPage();
        Request request = new Request();
        bookPage.run();
        Response response = new Response();

        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            System.out.println(response.getBody().get("list"));
        }
        System.out.println();
    }

    private void useUsersMenu() {
    }
}

