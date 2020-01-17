package library.view;

import library.controller.Request;
import library.service.exception.ServiceException;

import java.util.Map;

public interface Page {
    Request run() throws ServiceException;
}
