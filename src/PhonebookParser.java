import Exceptions.*;
import Records.PhonebookData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Класс для парсинга данных телефонной книги.
 */
public class PhonebookParser {

    /**
     * Метод для парсинга данных телефонной книги.
     *
     * @param input массив строк, содержащий данные телефонной книги
     * @return объект типа PhonebookData, содержащий распарсенные данные телефонной книги
     * @throws WrongFullNameException             исключение, возникающее при неверно введенном ФИО
     * @throws WrongDateOfBirthException          исключение, возникающее при неверно введенной дате рождения
     * @throws WrongGenderException               исключение, возникающее при неверно введенном поле
     * @throws WrongPhoneNumberException          исключение, возникающее при неверно введенном номере телефона
     * @throws ParsePhonebookNullPointerException исключение, возникающее при передаче пустого массива строк
     */
    public static PhonebookData parsePhonebookString(String[] input) throws WrongFullNameException, WrongDateOfBirthException, WrongGenderException, WrongPhoneNumberException, ParsePhonebookNullPointerException {
        if (input == null) {
            throw new ParsePhonebookNullPointerException("Массив строк должен быть инициализирован");
        }

        PhonebookData data;
        String lastName = parseFullName(input[0], new WrongLastNameException("Неверно введена фамилия", input[0]));
        String firstName = parseFullName(input[1], new WrongFirstNameException("Неверно введено имя", input[1]));
        String middleName = parseFullName(input[2], new WrongMiddleNameException("Неверно введено отчество", input[2]));
        LocalDate dateOfBirth = parseDateOfBirth(input[3]);
        long phoneNumber = parsePhoneNumber(input[4]);
        char gender = parseGender(input[5]);

        data = new PhonebookData(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
        return data;
    }

    /**
     * Метод для парсинга строки с ФИО.
     *
     * @param input     строка с ФИО
     * @param exception исключение, которое будет выброшено, если ФИО неверно введено
     * @return строка с ФИО
     * @throws WrongFullNameException если ФИО неверно введено
     */
    private static String parseFullName(String input, WrongFullNameException exception) throws WrongFullNameException {
        if (input == null || input.isEmpty() || input.matches(".*\\d.*")) {
            throw exception;
        }
        return input;
    }

    /**
     * Метод для парсинга строки с датой рождения.
     *
     * @param input строка с датой рождения
     * @return дата рождения в формате LocalDate
     * @throws WrongDateOfBirthException если дата рождения неверно введена
     */
    private static LocalDate parseDateOfBirth(String input) throws WrongDateOfBirthException {
        try {
            return LocalDate.parse(input, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new WrongDateOfBirthException("Неверно введена дата рождения", input);
        }
    }

    /**
     * Метод для парсинга строки с номером телефона.
     *
     * @param input строка с номером телефона
     * @return номер телефона в формате long
     * @throws WrongPhoneNumberException если номер телефона неверно введен
     */
    private static long parsePhoneNumber(String input) throws WrongPhoneNumberException {
        try {
            return Long.parseLong(input);
        } catch (Exception e) {
            throw new WrongPhoneNumberException("Неверно введен номер телефона", input);
        }
    }

    /**
     * Метод для парсинга строки с полом.
     *
     * @param input строка с полом
     * @return символ пола
     * @throws WrongGenderException если пол неверно введен
     */
    private static char parseGender(String input) throws WrongGenderException {
        char gender;
        try {
            gender = input.charAt(0);
            if (gender != 'f' && gender != 'm') {
                throw new WrongGenderException("Неверный введен пол", input);
            }
        } catch (Exception e) {
            throw new WrongGenderException(e.getMessage(), input);
        }

        return gender;
    }
}

