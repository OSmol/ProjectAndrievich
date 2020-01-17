package library.view;

import library.bean.Book;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.controller.command.impl.SortBookByNameCommand;
import library.service.exception.ServiceException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortBookByNamePage implements Page {
    @Override
    public Request run() throws ServiceException {
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
