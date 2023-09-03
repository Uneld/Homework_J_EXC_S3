package Exceptions;

/**
 * Исключение, которое возникает при неправильном поле "Пол".
 */
public class WrongGenderException extends Exception {
    private final String gender;

    /**
     * Конструктор исключения.
     *
     * @param message сообщение об ошибке
     * @param gender  неправильное значение пола
     */
    public WrongGenderException(String message, String gender) {
        super(message);
        this.gender = gender;
    }

    /**
     * Метод для получения значения пола, которое вызвало ошибку.
     *
     * @return значение пола
     */
    public String getGender() {
        return gender;
    }
}
