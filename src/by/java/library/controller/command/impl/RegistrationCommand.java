package library.controller.command.impl;

import library.bean.Security;
import library.bean.User;
import library.controller.command.Command;
import library.dao.factory.DAOFactory;
import library.service.UserService;
import library.service.exception.ServiceException;
import library.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class RegistrationCommand implements Command {
    private static Logger logger = Logger.getLogger(RegistrationCommand.class);
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private Security security = new Security();

    @Override
    public Map<Object, Object> execute(Map<String, String> parameters) throws ServiceException {

        return null;
    }
}


