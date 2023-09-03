package Exceptions;


/**
 * Исключение, которое возникает при неправильной дате рождения.
 */
public class WrongDateOfBirthException extends Exception {
    private final String dateString;

    /**
     * Конструктор исключения.
     *
     * @param message    сообщение об ошибке
     * @param dateString неправильная дата рождения в виде строки
     */
    public WrongDateOfBirthException(String message, String dateString) {
        super(message);
        this.dateString = dateString;
    }

    /**
     * Метод для получения строки с неправильной датой рождения.
     *
     * @return строка с неправильной датой рождения
     */
    public String getDateString() {
        return dateString;
    }
}
