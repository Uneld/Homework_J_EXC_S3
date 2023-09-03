import Exceptions.ErrorWriteFileException;
import Interfaces.FileHandlerInterface;
import Records.PhonebookData;

import java.io.File;
import java.io.FileWriter;

/**
 * Класс для работы с файлами.
 */
public class FileHandler implements FileHandlerInterface {
    private static final String FOLDER_NAME = "PBData";

    /**
     * Метод записывает переданные данные в файл с указанным именем. Если файл не существует, то создает его в папке "PBData".
     * Если папка не существует, то создает ее. Если при записи произошла ошибка, то выбрасывает исключение ErrorWriteFileException.
     *
     * @param fileName имя файла
     * @param data     данные для записи
     * @throws ErrorWriteFileException если произошла ошибка записи в файл
     */
    private void writeToFile(String fileName, String data) throws ErrorWriteFileException {
        File folder = new File(FOLDER_NAME);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folder, fileName);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(data + "\n");
        } catch (Exception e) {
            throw new ErrorWriteFileException("Ошибка записи в файл", file.getAbsolutePath());
        }
    }

    /**
     * Метод записывает переданные данные телефонной книги в файл с именем, равным фамилии абонента и расширением .txt.
     * Данные записываются в формате "<Фамилия><Имя><Отчество><дата рождения><номер телефона><пол>".
     * Если файл не существует, то создает его в папке "PBData". Если папка не существует, то создает ее.
     * Если файл существует, то дописывает в него новые данные
     * Если при записи произошла ошибка, то выбрасывает исключение ErrorWriteFileException.
     *
     * @param data данные телефонной книги
     * @throws ErrorWriteFileException если произошла ошибка записи в файл
     */
    @Override
    public void writePhonebook(PhonebookData data) throws ErrorWriteFileException {
        String fileName = data.lastName() + ".txt";
        String content = String.format("<%s><%s><%s><%s><%s><%s>", data.lastName(), data.firstName(), data.middleName(), data.getDateOfBirthToString(), data.phoneNumber(), data.gender());

        writeToFile(fileName, content);
    }
}
