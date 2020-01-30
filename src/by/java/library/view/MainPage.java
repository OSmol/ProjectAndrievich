package library.view;

import java.util.Scanner;
/*
каждая пейдж должна быть синглтоном
 */

public class MainPage implements Page {
    private static MainPage instance;
    private StringBuilder sb;
    private Scanner sc = new Scanner(System.in);

    private MainPage() {
        sb = new StringBuilder();
        sb.append("\nMain options:\n");
        sb.append("1. Use books menu.\n");
        sb.append("2. Use users menu.\n");
        sb.append("0. To finish work.\n");
    }

    public static synchronized MainPage getInstance() {
        if (instance == null) {
            instance = new MainPage();
        }
        return instance;
    }

    @Override
    public void run() {

        int result;
        while (true) {
            System.out.println(sb.toString());
            result = Integer.parseInt(sc.next());
            switch (result) {
                case 1:
                    useBooksMenu();
                    return;
                case 2:
                    useUsersMenu();
                    return;
                case 0:
                    finishWork();
                    return;
            }
        }
    }

    private void useBooksMenu() {
        BookPage bookPage = BookPage.getInstance();
        bookPage.run();

    }

    private void useUsersMenu() {
        UserPage userPage = UserPage.getInstance();
        userPage.run();

    }

    private void finishWork() {
        System.out.println("Work finished!");
    }
}


