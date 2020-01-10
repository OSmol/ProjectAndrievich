package library.view;

import library.service.exception.ServiceException;

import java.util.Map;

public interface Page {
    Map<String, String> run() throws ServiceException;
}
