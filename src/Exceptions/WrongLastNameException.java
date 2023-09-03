package Exceptions;

/**
 * Исключение, которое возникает при неправильной фамилии.
 */
public class WrongLastNameException extends WrongFullNameException {
    /**
     * Конструктор исключения.
     *
     * @param message сообщение об ошибке
     * @param value   неправильное значение фамилии
     */
    public WrongLastNameException(String message, String value) {
        super(message, value);
    }
}
