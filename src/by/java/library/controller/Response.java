package library.controller;

import java.util.HashMap;
import java.util.Map;

public class Response {
    private Map<Object, Object> body = new HashMap();
    private String errorMessage;
    private int responseCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public Map<Object, Object> getBody() {
        return body;
    }

    public void setBody(Map<Object, Object> body) {
        this.body = body;
    }
}


