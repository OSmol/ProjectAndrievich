package library.view;

import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.SortBookByNameCommand;
import library.service.exception.ServiceException;

import java.util.HashMap;
import java.util.Map;

public class SortBookByNamePage implements Page {
    @Override
    public Map<String, String> run() throws ServiceException {
        Command command = new SortBookByNameCommand();
        Map<String, String> parameters = new HashMap<String, String>();
        Response response = command.execute(parameters);
        System.out.println(response.getResponseCode());
        if (response.getResponseCode() == 501) {
            System.out.println(response.getErrorMessage());
        }
        return parameters;
    }
}
