package nl.ordina.exceptions;

public class WorkshopFollowerNotFoundException extends Throwable {
    private String message;
    private int statusCode;

    public WorkshopFollowerNotFoundException() {
        this.message = "Not Found";
        this.statusCode = 404;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
