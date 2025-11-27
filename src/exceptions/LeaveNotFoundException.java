package exceptions;

public class LeaveNotFoundException extends ApplicationException {
    public LeaveNotFoundException(String message) {
        super(message);
    }
}
