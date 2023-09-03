package Exceptions;

/**
 * Исключение, возникающее при передаче пустого массива строк
 */
public class ParsePhonebookNullPointerException extends RuntimeException {
    /**
     * Конструктор для создания исключения, которое выбрасывается, когда происходит NullPointerException при парсинге телефонной книги.
     *
     * @param message сообщение об ошибке, которое будет отображаться при выбрасывании исключения
     */
    public ParsePhonebookNullPointerException(String message) {
        super(message);
    }
}
