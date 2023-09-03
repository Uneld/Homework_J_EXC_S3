package Interfaces;

import Exceptions.ErrorWriteFileException;
import Records.PhonebookData;

/**
 * Интерфейс для работы с файлами.
 */
public interface FileHandlerInterface {
    /**
     * Метод для записи данных в файл.
     *
     * @param data - данные для записи в файл.
     * @throws ErrorWriteFileException - исключение, которое выбрасывается при ошибке записи в файл.
     */
    void writePhonebook(PhonebookData data) throws ErrorWriteFileException;
}
