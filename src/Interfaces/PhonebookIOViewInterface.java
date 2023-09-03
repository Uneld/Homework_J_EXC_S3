package Interfaces;

import Exceptions.IncorrectAmountOfDataException;
import Exceptions.ScannerOperationErrorException;
import Records.PhonebookData;

/**
 * Интерфейс PhonebookIOViewInterface определяет методы для взаимодействия с пользователем в приложении для работы с телефонной книгой.
 */
public interface PhonebookIOViewInterface {
    /**
     * Метод inputRequest() запрашивает у пользователя ввод данных для добавления в телефонную книгу.
     *
     * @return массив строк, содержащих введенные пользователем данные
     * @throws IncorrectAmountOfDataException если пользователь ввел неправильное количество данных
     * @throws ScannerOperationErrorException если произошла ошибка при работе с объектом Scanner
     */
    String[] inputRequest() throws IncorrectAmountOfDataException, ScannerOperationErrorException;

    /**
     * Метод showData() выводит данные в телефонную книгу.
     *
     * @param data объект PhonebookData, содержащий данные для вывода
     */
    void showData(PhonebookData data);

    /**
     * Метод showMessage() выводит сообщение для пользователя.
     *
     * @param msg строка, содержащая сообщение
     */
    void showMessage(String msg);

    /**
     * Метод showError() выводит сообщение об ошибке для пользователя.
     *
     * @param msg строка, содержащая сообщение об ошибке
     */
    void showError(String msg);
}
