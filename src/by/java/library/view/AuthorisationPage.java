package library.view;

import javatrDay5.helper.ScannerHelper;
import library.controller.command.Command;
import library.controller.command.impl.RegistrationCommand;
import library.service.exception.ServiceException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AuthorisationPage implements Page {
    private Page page = new RegistrationPage();
    private Page mainPage = new MainPage();

    @Override
    public Map<String, String> run() throws ServiceException {
        Command command = new RegistrationCommand();
        System.out.println("Enter login: ");
        String login = ScannerHelper.inputStringFromConsole();
        System.out.println("Enter password: ");
        String password = ScannerHelper.inputStringFromConsole();
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("login", login);
        parameters.put("password", password);
        command.execute(parameters);
        return null;
    }
}
