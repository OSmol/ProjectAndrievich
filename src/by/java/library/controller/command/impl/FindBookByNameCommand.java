package library.controller.command.impl;

import library.bean.User;
import library.controller.Request;
import library.controller.Response;
import library.controller.command.Command;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

public class FindBookByNameCommand implements Command {
    private static Logger logger = Logger.getLogger(FindBookByNameCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private User.Security security = new User.Security();


    @Override
    public Response execute(Request request) {
       String title= String.valueOf(request.getBody().get("title"));
        Response response = new Response();
        if (title == null || title.isEmpty()) {
            response.setErrorMessage("Enter title");

            try {

                serviceFactory.getBookServiceImpl().findBookByName(title);
                response.setResponseCode(201);

                return response;

            } catch (ServiceException e) {
                response.setErrorMessage(e.getMessage());
                response.setResponseCode(501);
                return response;
            }
        }
       return response;
    }
}
