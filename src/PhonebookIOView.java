import Exceptions.IncorrectAmountOfDataException;
import Exceptions.ScannerOperationErrorException;
import Interfaces.PhonebookIOViewInterface;
import Records.PhonebookData;

import java.util.Scanner;

/**
 * Класс для работы с вводом/выводом данных телефонной книги.
 */
public class PhonebookIOView implements PhonebookIOViewInterface {
    private static final int AMOUNT_DATA = 6;
    private final Scanner scanner;

    /**
     * Конструктор класса. Инициализирует сканер для считывания данных с консоли.
     */
    public PhonebookIOView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Метод запрашивает у пользователя данные телефонной книги и возвращает их в виде массива строк.
     * Если количество введенных данных не соответствует AMOUNT_DATA, выбрасывает исключение IncorrectAmountOfDataException.
     * Если при считывании данных произошла ошибка, выбрасывает исключение ScannerOperationErrorException.
     *
     * @return массив строк с данными телефонной книги
     * @throws IncorrectAmountOfDataException если количество введенных данных не соответствует AMOUNT_DATA
     * @throws ScannerOperationErrorException если при считывании данных произошла ошибка
     */
    @Override
    public String[] inputRequest() throws IncorrectAmountOfDataException, ScannerOperationErrorException {
        String[] data;
        try {
            String input = scanner.nextLine();
            data = input.split(" ");

            if (data.length != AMOUNT_DATA) {
                throw new IncorrectAmountOfDataException("Введено неверное количество данных", data.length);
            }
        } catch (RuntimeException e) {
            throw new ScannerOperationErrorException("Ошибка работы сканера");
        }
        return data;
    }

    /**
     * Метод выводит на экран данные телефонной книги.
     *
     * @param data данные телефонной книги
     */
    @Override
    public void showData(PhonebookData data) {
        System.out.println(data);
    }

    /**
     * Метод выводит на экран сообщение.
     *
     * @param msg сообщение для вывода на экран
     */
    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    /**
     * Метод выводит на экран сообщение об ошибке.
     *
     * @param msg сообщение об ошибке для вывода на экран
     */
    @Override
    public void showError(String msg) {
        System.err.println(msg);
    }
}

