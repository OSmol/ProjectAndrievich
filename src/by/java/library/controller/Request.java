package library.controller;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private Map<Object, Object> body = new HashMap();

    public Request (){}

    public Map<Object, Object> getBody() {
        return body;
    }

    public void setBody(Map<Object, Object> body) {
        this.body = body;
    }
}
