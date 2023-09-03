package Exceptions;

/**
 * Исключение, которое возникает при неправильном отчестве.
 */
public class WrongMiddleNameException extends WrongFullNameException {
    /**
     * Конструктор исключения.
     *
     * @param message сообщение об ошибке
     * @param value   неправильное значение отчества
     */
    public WrongMiddleNameException(String message, String value) {
        super(message, value);
    }
}
