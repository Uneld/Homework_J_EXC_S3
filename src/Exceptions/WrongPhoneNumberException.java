package Exceptions;

/**
 * Исключение, которое возникает при неправильном номере телефона.
 */
public class WrongPhoneNumberException extends Exception {
    private final String phoneNumber;

    /**
     * Конструктор исключения.
     *
     * @param message     сообщение об ошибке
     * @param phoneNumber неправильный номер телефона
     */
    public WrongPhoneNumberException(String message, String phoneNumber) {
        super(message);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Метод для получения номера телефона, который вызвал ошибку.
     *
     * @return номер телефона
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
