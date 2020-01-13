package library.view;

import javatrDay5.helper.ScannerHelper;
import library.bean.Country;
import library.bean.Genre;
import library.bean.Person;
import library.bean.User;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.AddBookCommand;
import library.service.exception.ServiceException;

import java.util.*;

public class AddPage implements Page {

    private Page mainPage = new MainPage();

    @Override
    public Map<String, String> run() throws ServiceException {
        Command command = new AddBookCommand();

        System.out.println("Enter id: ");
        String id = String.valueOf(ScannerHelper.inputInt());
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

        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("id", id);
        parameters.put("title", title);
        parameters.put("author", author);
        parameters.put("publishingHouse", publishingHouse);
        parameters.put("year", year);
        parameters.put("genre", genre);
        parameters.put("country", country);
        parameters.put("isbn", isbn);
        parameters.put("countOfPages", countOfPages);
        parameters.put("language", language);
        parameters.put("authorOfTranslation", authorOfTranslation);
        parameters.put("description", description);
        parameters.put("averageMark", averageMark);
        parameters.put("price", price);
        Response response = command.execute(parameters);
        System.out.println(response.getResponseCode());
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        return parameters;
    }
}
