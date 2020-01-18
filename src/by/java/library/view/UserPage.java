package library.view;

import javatrDay5.helper.ScannerHelper;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.RegistrationCommand;
import library.service.exception.ServiceException;

public class UserPage {
    public Request authorisation() throws ServiceException {
        Command command = new RegistrationCommand();
        System.out.println("Enter login: ");
        String login = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter password: ");
        String password = ScannerHelper.inputStringFromConsole();
        Request request=new Request();
        request.getBody().put("login", login);
        request.getBody().put("password", password);
        command.execute(request);
        return null;
    }

    public Request registration() throws ServiceException {
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
        if (response.getResponseCode()==501){
            System.out.println(response.getErrorMessage());
        }
        return request;
    }
    public Request signIn() throws ServiceException {
        Command command = new RegistrationCommand();
        System.out.println("Enter login: ");
        String login = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter password: ");
        String password = ScannerHelper.inputStringFromConsole();
        Request request=new Request();
        request.getBody().put("login", login);
        request.getBody().put("password", password);
        Response response = command.execute(request);
        System.out.println(response.getResponseCode());
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        return request;
    }
    public Request signOut() throws ServiceException {
        return null;
    }
}
