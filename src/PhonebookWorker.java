import Exceptions.*;
import Interfaces.FileHandlerInterface;
import Interfaces.PhonebookIOViewInterface;
import Records.PhonebookData;

import java.util.Arrays;
// Использованные валидные входные данные
//String[] inputDataTest = new String[]{
//        "Сыромятникова Ульяна Павловна 24.10.1994 1264773 f",
//        "Сыромятникова Любовь Вячеславовна 08.09.1994 1134445 f",
//        "Якушкин Давид Себастьянович 12.08.1991 62959615 m",
//        "Булдакова Римма Павловна 11.12.1980 4965710 f",
//        "Якушкин Федор Ильич 15.02.1968 7058554 m",
//        "Головина Аполлинария Никаноровна 27.08.1985 3031835 f",
//        "Якушкин Марк Яковлевич 23.01.1990 9532882 m",
//        "Ошурков Тимофей Климентьевич 14.12.1989 8213254 m",
//        "Серых Юлиана Михаиловна 14.06.1963 6585477 f",
//        "Серых Юлия Феликсовна 15.03.1994 1702167 f"
//        };

/**
 * Класс для работы с телефонной книгой.
 */
public class PhonebookWorker {
    private static final String SUCCESS_MESSAGE = "Запись в файл завершена.";

    private final PhonebookIOViewInterface phonebookIOView;
    private final FileHandlerInterface fileHandler;

    /**
     * Конструктор класса.
     *
     * @param phonebookIOView интерфейс для взаимодействия с пользователем
     * @param fileHandler     интерфейс для работы с файлами
     */
    public PhonebookWorker(PhonebookIOViewInterface phonebookIOView, FileHandlerInterface fileHandler) {
        this.phonebookIOView = phonebookIOView;
        this.fileHandler = fileHandler;
    }

    /**
     * Метод для запуска работы с телефонной книгой.
     */
    public void process() {
        while (true) {
            phonebookIOView.showMessage("Введите данные: фамилия, имя, отчество, дата рождения (в формате dd.mm.yyyy), номер телефона и пол (f или m), разделенные пробелом:");

            try {
                String[] inputData = phonebookIOView.inputRequest();
                if (processInputData(inputData)) {
                    return;
                }
            } catch (IncorrectAmountOfDataException e) {
                phonebookIOView.showError(String.format("%s, количество данных: %d\n", e.getMessage(), e.getAmount()));
            } catch (ScannerOperationErrorException e) {
                phonebookIOView.showError(e.getMessage());
            }
        }
    }

    /**
     * Метод для обработки введенных пользователем данных.
     *
     * @param inputData массив строк с данными
     * @return true, если данные были обработаны успешно и записаны в файл, иначе - false
     */
    private boolean processInputData(String[] inputData) {
        try {
            PhonebookData dataPhonebook = PhonebookParser.parsePhonebookString(inputData);
            phonebookIOView.showData(dataPhonebook);

            fileHandler.writePhonebook(dataPhonebook);
            phonebookIOView.showMessage(SUCCESS_MESSAGE);
            return true;
        } catch (WrongFullNameException e) {
            phonebookIOView.showError(String.format("%s, введено: %s\n", e.getMessage(), e.getValue()));
        } catch (WrongDateOfBirthException e) {
            phonebookIOView.showError(String.format("%s, введено: %s\n", e.getMessage(), e.getDateString()));
        } catch (WrongGenderException e) {
            phonebookIOView.showError(String.format("%s, введено: %s\n", e.getMessage(), e.getGender()));
        } catch (WrongPhoneNumberException e) {
            phonebookIOView.showError(String.format("%s, введено: %s\n", e.getMessage(), e.getPhoneNumber()));
        } catch (ParsePhonebookNullPointerException e) {
            phonebookIOView.showError("Ошибка разбора телефонной книги: " + e.getMessage());
        } catch (ErrorWriteFileException e) {
            phonebookIOView.showError(String.format("%s, Абсолютный путь: %s\n", e.getMessage() + Arrays.toString(e.getStackTrace()), e.getFileName()));
        }
        return false;
    }
}

