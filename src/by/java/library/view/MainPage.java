package library.view;

import library.controller.Request;

import java.util.Scanner;


public class MainPage implements Page {
    @Override
    public Request run() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nMain options:\n");
        sb.append("1. Use books menu.\n");
        sb.append("2. Use users menu.\n");
        sb.append("0. To finish work.\n");
        System.out.println(sb.toString());
        Scanner sc = new Scanner(System.in);
        String result = sc.next();

        switch (result) {
            case "1":
                useBooksMenu();
                break;
            case "2":
                useUsersMenu();
                break;
            case "0":
                finishWork();
                break;
        }
        return null;
    }

    private void useBooksMenu() {

        BookPage bookPage = new BookPage();
        bookPage.run();
        System.out.println();
    }

    private void useUsersMenu() {
        UserPage userPage = new UserPage();
        userPage.run();
        System.out.println();
    }

    private void finishWork() {
        System.out.println("Work finished!");
    }
}


