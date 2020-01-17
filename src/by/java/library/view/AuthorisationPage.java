package library.view;

import javatrDay5.helper.ScannerHelper;
import library.controller.Request;
import library.controller.command.Command;
import library.controller.command.impl.RegistrationCommand;
import library.service.exception.ServiceException;

public class AuthorisationPage implements Page {
    private Page page = new RegistrationPage();
    private Page mainPage = new MainPage();

    @Override
    public Request run() throws ServiceException {
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
}
