package exceptions;

public class InvalidLeaveRequestException extends ApplicationException {
    public InvalidLeaveRequestException(String message) {
        super(message);
    }
}
