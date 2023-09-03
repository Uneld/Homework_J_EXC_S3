package Records;

import java.time.LocalDate;

/**
 * Класс PhonebookData представляет запись в телефонной книге.
 * Каждая запись содержит фамилию, имя, отчество, дату рождения, номер телефона и пол.
 */
public record PhonebookData(String lastName, String firstName, String middleName, LocalDate dateOfBirth,
                            long phoneNumber, char gender) {
    /**
     * Получает дату рождения в виде строки в формате "dd.MM.yyyy".
     *
     * @return Дата рождения в виде строки.
     */
    public String getDateOfBirthToString() {
        return String.format("%d.%d.%d", dateOfBirth.getDayOfMonth(), dateOfBirth.getMonthValue(), dateOfBirth.getYear());
    }

    /**
     * Возвращает строковое представление объекта PhonebookData.
     *
     * @return Строковое представление объекта PhonebookData.
     */
    @Override
    public String toString() {
        return String.format("Фамилия: %s, Имя: %s, Отчество: %s, Дата рождения: %s, Номер телефона: %d, Пол: %c", lastName, firstName, middleName, getDateOfBirthToString(), phoneNumber, gender);
    }
}
