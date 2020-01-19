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

    @Override
    public Request run() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nAvailable options:\n");
        sb.append("1. View books in the catalog.\n");
        sb.append("2. Find a book in the catalog.\n");
        sb.append("3. Add a book to the catalog.\n");
        //  sb.append("3. Suggest an administrator to add a book.\n");
        sb.append("4. Remove book from catalog.\n");
        sb.append("5. Register a new user.\n");
        sb.append("6. Delete user.\n");
        sb.append("7. Update book. \n");
        sb.append("8. Find user. \n");
        sb.append("9. Change user\n");
        sb.append("0. To finish work.\n");
        System.out.println(sb.toString());
        Scanner sc = new Scanner(System.in);
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
                registerUser(request);
                break;
            case "6":
                deleteUser(request);
                break;
            case "7":
                updateBook(request);
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

    private void showBook(Request request) {
        GetBookCommand bookCommand = new GetBookCommand();
        bookCommand.execute(request);
          //  System.out.println("The catalog is empty.\n");

    }

    private void findBook(Request request) {
        FindBookByNameCommand nameCommand = new FindBookByNameCommand();
        nameCommand.execute(request);
           // System.out.println("Error in request, try again.");

    }

    private void addBooks(Request request) {
        AddBookCommand bookCommand = new AddBookCommand();
        bookCommand.execute(request);
            System.out.println("Book added!");

    }

    private void removeBook(Request request) {
        DeleteBookCommand bookCommand = new DeleteBookCommand();
        bookCommand.execute(request);
    }

    private void updateBook(Request request) {
        UpdateBookCommand bookCommand = new UpdateBookCommand();
        bookCommand.execute(request);
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

    public Request addBook() throws ServiceException {
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

        Request request = new Request();

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
        return request;
    }
}

