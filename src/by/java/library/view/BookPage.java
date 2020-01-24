package library.view;

import javatrDay5.helper.ScannerHelper;
import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.*;

import java.util.List;
import java.util.Scanner;

/*
работаю с реквестом и респонсом, не могу вызвать дао, сервис, могу вызвать на 1 приватном методе 1 контроллер
в этом  классе предпол работа с пользователем, поэтому дб много соут
 */
public class BookPage implements Page {
    Scanner sc = new Scanner(System.in);

    @Override
    public Request run() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nAvailable options:\n");
        sb.append("1. View books in the catalog.\n");
        sb.append("2. Find a book in the catalog.\n");
        sb.append("3. Add a book to the catalog.\n");
        sb.append("4. Remove book from catalog.\n");
        sb.append("5. Update book. \n");
        sb.append("0. To finish work.\n");
        System.out.println(sb.toString());

        String result = sc.next();

        switch (result) {
            case "1":
                showBooks();
                break;
            case "2":
                findBookByName();
                break;
            case "3":
                addBooks();
                break;
            case "4":
                removeBook();
                break;
            case "5":
                updateBook();
                break;
            case "0":
                finishWork();
                break;
        }
        return null;
    }

    private void showBooks() {
        Request request = new Request();
        Command bookCommand = new GetBooksCommand();
        Response response = bookCommand.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            System.out.println(response.getBody().get("list"));
        }
        System.out.println();
    }

    private void findBookByName() {
        Request request = new Request();
        Command command = new FindBookByNameCommand();
        System.out.println("Enter name book: ");
        String title = ScannerHelper.inputStringFromConsole();
        request.getBody().put("title", title);
        Response response = command.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            System.out.println(response.getBody().get("list"));
        }
        System.out.println();

    }

    private void removeBook() {
        Request request = new Request();
        Command bookCommand = new DeleteBookByIdCommand();
        System.out.println("Enter id book: ");
        int id = ScannerHelper.inputInt();
        request.getBody().put("id",id);
        Response response = bookCommand.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            System.out.println(response.getBody().get("list"));
        }
        System.out.println();
    }


    private void addBooks() {
        Command command = new AddBookCommand();
        Request request = new Request();
        //  System.out.println("Enter id: ");
        //   String id = String.valueOf(ScannerHelper.inputInt());
        System.out.println("Enter title: ");
        String title = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter author: ");
        String author = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter publishingHouse: ");
        String publishingHouse = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter year: ");
        String year = String.valueOf(ScannerHelper.inputInt());
        System.out.println("Enter genre: ");
        String genre = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter country: ");
        String country = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter isbn: ");
        String isbn = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter countOfPages: ");
        String countOfPages = String.valueOf(ScannerHelper.inputInt());
        System.out.println("Enter language: ");
        String language = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter authorOfTranslation: ");
        String authorOfTranslation = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter description: ");
        String description = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter price: ");
        String price = String.valueOf(ScannerHelper.inputInt());

        request.getBody().put("title", title);
        request.getBody().put("author", author);
        request.getBody().put("publishingHouse", publishingHouse);
        request.getBody().put("year", year);
        request.getBody().put("genre", genre);
        request.getBody().put("country", country);
        request.getBody().put("isbn", isbn);
        request.getBody().put("countOfPages", countOfPages);
        request.getBody().put("language", language);
        request.getBody().put("authorOfTranslation", authorOfTranslation);
        request.getBody().put("description", description);
        request.getBody().put("price", price);

        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        // return request;
    }


    private void updateBook() {
        Request request = new Request();
        Command bookCommand = new UpdateBookCommand();
        System.out.println("Enter id book");
        int id = sc.nextInt();
        request.getBody().put("id", id);
        Response response = bookCommand.execute(request);
        System.out.println(response.getErrorMessage());
        System.out.println(response.getResponseCode());

    }


    private void finishWork() {
        System.out.println("Work with books finished!");
    }


    private Request sortBookByName() {
        Command command = new SortBookByNameCommand();
        Request request = new Request();
        Response response = command.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
            System.out.println(response.getResponseCode());
        } else {
            List<Book> list = (List<Book>) response.getBody().get("title");
        }
        return request;
    }
}



