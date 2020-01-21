package library.controller.command;

import library.controller.Request;
import library.controller.Response;



public interface Command {//map = request
    Response execute(Request request) ;
}
