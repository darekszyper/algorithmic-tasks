package exception;

public class NotEnoughNumbersException extends IllegalArgumentException {
    public NotEnoughNumbersException(String s) {
        super(s);
    }
}
