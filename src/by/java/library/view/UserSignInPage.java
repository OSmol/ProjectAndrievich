package library.view;

import javatrDay5.helper.ScannerHelper;
import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.GetBookByNameCommand;
import library.controller.command.impl.GetBooksCommand;
import library.controller.command.impl.SortBooksByNameCommand;

import java.util.List;
import java.util.Scanner;

/*
работаю с реквестом и респонсом, не могу вызвать дао, сервис, могу вызвать на 1 приватном методе 1 контроллер
в этом  классе предпол работа с пользователем, поэтому дб много соут
 */
class UserSignInPage implements Page {
    private static UserSignInPage instance;
    private StringBuilder sb;
    private Scanner sc = new Scanner(System.in);

    private UserSignInPage() {
        sb = new StringBuilder();//sb созд в пределах объекта, а не в методе run()
        sb.append("\nAvailable options:\n");
        sb.append("1. View books in the catalog.\n");
        sb.append("2. Find a book in the catalog.\n");
        sb.append("3. Sort books by name. \n");
        sb.append("4. Sort books by year. \n");
        sb.append("0. To finish work.\n");
    }

    public static synchronized UserSignInPage getInstance() {
        if (instance == null) {
            instance = new UserSignInPage();
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
                    showBooks();
                    break;
                case 2:
                    findBookByName();
                    break;
                case 3:
                    sortBookByName();
                    break;
                case 4:
                    sortBookByYear();
                    break;
                case 0:
                    finishWork();
                    break;
            }
        }
    }

       private void showBooks() {
        Request request = new Request();
        Command bookCommand = new GetBooksCommand();
        Response response = bookCommand.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            List<Book> list = (List<Book>) response.getBody().get("list");
            for (Book book : list) {
                System.out.println(book);
            }
        }
        System.out.println("\n Please, make your choice!");
    }

    private void sortBookByName() {
        Request request = new Request();
        Command command = new SortBooksByNameCommand();
        Response response = command.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
            System.out.println(response.getResponseCode());
        } else {
            if (response.getResponseCode() == 201) {
                List<Book> list = (List<Book>) response.getBody().get("title");
                for (Book book : list) {
                    System.out.println(book);
                }
            }
            System.out.println("\n Please, make your choice!");
        }
    }

    private void sortBookByYear() {
        Request request = new Request();
        Command command = new SortBooksByNameCommand();
        Response response = command.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
            System.out.println(response.getResponseCode());
        } else {
            if (response.getResponseCode() == 201) {
                List<Book> list = (List<Book>) response.getBody().get("title");
                for (Book book : list) {
                    System.out.println(book);
                }
            }
            System.out.println("\n Please, make your choice!");
        }
    }

    private void findBookByName() {
        Request request = new Request();
        Command command = new GetBookByNameCommand();
        System.out.println("Enter name book: ");
        String title = ScannerHelper.inputStringFromConsole();
        request.getBody().put("title", title);
        Response response = command.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            List<Book> list = (List<Book>) response.getBody().get("list");
            for (Book book : list) {
                System.out.println(book);
            }
        }
        System.out.println("\n Please, make your choice!");
    }

    private void finishWork() {
        System.out.println("Work with books finished! \n");
    }
}




