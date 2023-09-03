package Exceptions;

/**
 * Исключение, которое возникает при неправильном количестве данных при вводе.
 */
public class IncorrectAmountOfDataException extends Exception {
    private final int amount;

    /**
     * Конструктор исключения.
     *
     * @param message сообщение об ошибке
     * @param amount  количество данных, введенных во время ошибки
     */
    public IncorrectAmountOfDataException(String message, int amount) {
        super(message);
        this.amount = amount;
    }

    /**
     * Метод для получения количества данных, введенных во время ошибки.
     *
     * @return количество данных
     */
    public int getAmount() {
        return amount;
    }
}