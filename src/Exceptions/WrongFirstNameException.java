package Exceptions;

/**
 * Исключение, которое возникает при неправильном имени.
 */
public class WrongFirstNameException extends WrongFullNameException {
    /**
     * Конструктор исключения.
     *
     * @param message сообщение об ошибке
     * @param value   неправильное значение имени
     */
    public WrongFirstNameException(String message, String value) {
        super(message, value);
    }
}
