package core;

import exceptions.AppException;
import exceptions.ExceptionText;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonFillController {
    private final Person person;

    private enum EntryFromFullName {
        NAME,
        PATRONYMIC,
        LASTNAME
    }

    public PersonFillController() {
        person = new Person();
    }

    public Person getEntry() {
        return person;
    }

    public void setGender(String input) throws AppException {
        Map<String, Person.Gender> gender = new HashMap<>();
        gender.put("f", Person.Gender.female);
        gender.put("m", Person.Gender.male);
        try {
            compareWithEnum(String.valueOf(gender.get(input)));
        } catch (IllegalArgumentException e){
            throw new AppException(ExceptionText.wrongGender);
        }
    }

    private void compareWithEnum(String text) throws AppException {
        try {
            person.gender = Person.Gender.valueOf(text);
        } catch (IllegalArgumentException e) {
            throw new AppException(ExceptionText.wrongGender);
        }
    }

    private boolean VerifyEntryFromFullName(String name) {
        return containsDigitsOrSpecialChars(name);
    }

    private static boolean containsDigitsOrSpecialChars(String input) {
        Pattern pattern = Pattern.compile("[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]");
        Matcher matcher = pattern.matcher(input);
        return !matcher.find();
    }

    private void fillEntryFromFullName(String nameText, String exceptionText, EntryFromFullName inNamePart) throws AppException {

        if (VerifyEntryFromFullName(nameText)) {
            switch (inNamePart) {
                case NAME -> person.name = nameText;
                case LASTNAME -> person.lastName = nameText;
                case PATRONYMIC -> person.patronymic = nameText;
            }

            return;
        }
        throw new AppException(exceptionText);

    }

    private boolean isValidBirthday(String birthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate;

        try {
            birthDate = LocalDate.parse(birthday, formatter);
        } catch (Exception e) {
            return false;
        }

        LocalDate now = LocalDate.now();
        long age = ChronoUnit.YEARS.between(birthDate, now);

        return age >= 0 && age <= 150;
    }

    private static boolean isValidNumber(String text) throws AppException {
        try {
            long number = Long.parseLong(text);
            return String.valueOf(number).length() == 11;
        } catch (NumberFormatException e) {
            throw new AppException(ExceptionText.wrongPhone);
        }
    }

    public void setNme(String name) throws AppException {
        fillEntryFromFullName(name, ExceptionText.name, EntryFromFullName.NAME);
    }

    public void setPatronymic(String patronymic) throws AppException {
        fillEntryFromFullName(patronymic, ExceptionText.surname, EntryFromFullName.PATRONYMIC);
    }

    public void setLastName(String lastName) throws AppException {
        fillEntryFromFullName(lastName, ExceptionText.lastName, EntryFromFullName.LASTNAME);
    }

    public void setBirthDate(String date) throws AppException {
        if (isValidBirthday(date)) {
            person.birthDate = date;
            return;
        }
        throw new AppException(ExceptionText.wrongDate);
    }

    public void setPhoneNumber(String number) throws AppException {
        if (isValidNumber(number)) {
            person.phoneNumber = Long.parseLong(number);
        }
    }

}
