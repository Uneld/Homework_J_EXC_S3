package Exceptions;

/**
 * Исключение, которое возникает при неправильном формате ФИО.
 */
public abstract class WrongFullNameException extends Exception {
    private final String value;

    /**
     * Конструктор исключения.
     *
     * @param message сообщение об ошибке
     * @param value   неправильное значение ФИО
     */
    public WrongFullNameException(String message, String value) {
        super(message);
        this.value = value;
    }

    /**
     * Метод для получения значения ФИО, которое вызвало ошибку.
     *
     * @return значение ФИО
     */
    public String getValue() {
        return value;
    }
}
