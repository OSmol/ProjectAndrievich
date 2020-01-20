package library.view;

import javatrDay5.helper.ScannerHelper;
import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.*;
import library.service.exception.ServiceException;

import java.util.List;
import java.util.Scanner;

/*
работаю с реквестом и респонсом, не могу вызвать дао, сервис, могу вызвать на 1 приватном методе 1 контроллер
в этом  классе предпол работа с пользователем, поэтому дб много соут
задача: написать бук пэйдж
 */
public class BookPage implements Page {
    Scanner sc = new Scanner(System.in);

    @Override
    public Request run() throws ServiceException {

        StringBuilder sb = new StringBuilder();
        sb.append("\nAvailable options:\n");
        sb.append("1. View books in the catalog.\n");
        sb.append("2. Find a book in the catalog.\n");
        sb.append("3. Add a book to the catalog.\n");
        sb.append("4. Remove book from catalog.\n");
        sb.append("7. Update book. \n");
        sb.append("0. To finish work.\n");
        System.out.println(sb.toString());

        String result = sc.next();
        Response response = new Response();
        Request request = new Request();
        switch (result) {
            case "1":
                showBook(request);
                break;
            case "2":
                findBook(request);
                break;
            case "3":
                addBooks(request);
                break;
            case "4":
                removeBook(request);
                break;
            case "5":
                updateBook(request);
                break;
            case "0":
                finishWork();
                break;
        }
        return null;
    }

    private void showBook(Request request) throws ServiceException {
        Command bookCommand = new GetBookCommand();
        System.out.println("Enter id book");
        int idBook = sc.nextInt();
        request.getBody().put("idBook", idBook);
        Response response = bookCommand.execute(request);
        System.out.println(response.getErrorMessage());
        System.out.println(response.getResponseCode());
        System.out.println("This book show.\n");
    }

    private void findBook(Request request) throws ServiceException {
        Command nameCommand = new FindBookByNameCommand();
        System.out.println("Enter book name");
        String bookName = sc.nextLine();
        request.getBody().put("bookName", bookName);
        Response response = nameCommand.execute(request);
        System.out.println(response.getErrorMessage());
        System.out.println(response.getResponseCode());
        // System.out.println("Error in request, try again.");

    }

    private void addBooks(Request request) throws ServiceException {
        Command command = new AddBookCommand();

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
        System.out.println("Enter averageMark: ");
        String averageMark = String.valueOf(ScannerHelper.inputInt());
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
        request.getBody().put("averageMark", averageMark);
        request.getBody().put("price", price);

        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        // return request;
    }


    private void removeBook(Request request) throws ServiceException {
        Command bookCommand = new DeleteBookCommand();
        System.out.println("Enter id book");
        int id = sc.nextInt();
        request.getBody().put("id", id);
        Response response = bookCommand.execute(request);
        System.out.println(response.getErrorMessage());
        System.out.println(response.getResponseCode());
    }

    private void updateBook(Request request) throws ServiceException {
        Command bookCommand = new UpdateBookCommand();
        System.out.println("Enter id book");
        int id = sc.nextInt();
        request.getBody().put("id", id);
        Response response = bookCommand.execute(request);
        System.out.println(response.getErrorMessage());
        System.out.println(response.getResponseCode());
    }


    private void finishWork() {
    }


    private Request sortBookByName() throws ServiceException {
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



