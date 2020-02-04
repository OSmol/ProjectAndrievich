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
class BookPage implements Page {
    private static BookPage instance;
    private StringBuilder sb;
    private Scanner sc = new Scanner(System.in);

    private BookPage() {
        sb = new StringBuilder();//sb созд в пределах объекта, а не в методе run()
        sb.append("\nAvailable options:\n");
        sb.append("1. View books in the catalog.\n");
        sb.append("2. Find a book in the catalog.\n");
        sb.append("3. Add a book to the catalog.\n");
        sb.append("4. Remove book from catalog.\n");
        sb.append("5. Update book. \n");
        sb.append("6. Sort books by name. \n");
        sb.append("7. Sort books by year. \n");
        sb.append("8. Go to User menu.\n");
        sb.append("9. Go to Main menu.\n");
        sb.append("0. To finish work.\n");

    }

    public static synchronized BookPage getInstance() {
        if (instance == null) {
            instance = new BookPage();
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
                    addBooks();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    updateBook();
                    break;
                case 6:
                    sortBookByName();
                    break;
                case 7:
                    sortBookByYear();
                    break;
                case 8:
                    goToUserMenu();
                    return;
                case 9:
                    goToMainMenu();
                    return;
                case 0:
                    finishWork();
                    break;


            }
        }
    }

    private void goToMainMenu() {
        MainPage mainPage = MainPage.getInstance();
        mainPage.run();
    }

    private void goToUserMenu() {
        UserPage userPage = UserPage.getInstance();
        userPage.run();
    }

    private void showBooks() {
        Request request = new Request();
        Command bookCommand = GetBooksCommand.getInstance();
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
        Command command = SortBooksByNameCommand.getInstance();
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
        Command command = SortBooksByNameCommand.getInstance();
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
        Command command = GetBookByNameCommand.getInstance();
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

    private void removeBook() {
        Request request = new Request();
        Command bookCommand = DeleteBookByIdCommand.getInstance();
        System.out.println("Enter id book: ");
        int id = ScannerHelper.inputInt();
        request.getBody().put("id", id);
        Response response = bookCommand.execute(request);
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        if (response.getResponseCode() == 201) {
            System.out.println(response.getBody().get("list"));
        }
        System.out.println("\n Please, make your choice!");
    }


    private void addBooks() {
        Command command = AddBookCommand.getInstance();
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
        System.out.println("\n Please, make your choice!");
    }


    private void updateBook() {
        Request request = new Request();
        Command bookCommand = UpdateBookCommand.getInstance();
        System.out.println("Enter id book");
        int id = sc.nextInt();
        request.getBody().put("id", id);
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


    private void finishWork() {
        System.out.println("Work with books finished! \n");
    }
}



