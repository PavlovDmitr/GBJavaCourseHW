package exceptions;

public class ExceptionText {
    private static final String constForName = "тест должен состоять из букв, ";
    private static final String tryAgain = "попробуйте ещё раз\n";
    private static final String startFillFullName = "\n не верно задано ";

    public static String name = startFillFullName + "имя\n " + constForName + tryAgain;
    public static String surname = startFillFullName + "отчество\n" + constForName + tryAgain;
    public static String lastName = startFillFullName + "фамилия\n" + constForName + tryAgain;
    public static String wordsCountName = startFillFullName + "количество слов в полном имени\n" + tryAgain;
    public static String wrongDate = "не верно задана дата (формат даты дд.мм.гггг пример -> 21.08.1985)\n" + tryAgain;
    public static String wrongPhone = "не верно задан телефон (пример -> 89798765432)\n" + tryAgain;
    public static String wrongGender = "не верно задан пол (пример -> male, или female)\n" + tryAgain;
    public static String fileWrite = "ошибка в записи файла\n" + tryAgain;
}
