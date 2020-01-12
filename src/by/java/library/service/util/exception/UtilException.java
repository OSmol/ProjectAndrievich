package library.service.util.exception;

public class UtilException extends Exception {
    public UtilException() {
        super();
    }

    public UtilException(String s) {
        super(s);
    }

    public UtilException(String s, Exception e) {
        super(s, e);
    }
    public UtilException(Exception e) {
        super(e);
    }
}
