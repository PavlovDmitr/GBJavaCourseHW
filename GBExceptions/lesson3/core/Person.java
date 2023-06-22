package core;

public class Person {

    protected String name;
    protected String patronymic;
    protected String lastName;
    protected String birthDate;
    protected long phoneNumber;
    protected Gender gender;

    protected enum Gender {
        male,
        female
    }

    public String getLastName() {
        return lastName;
    }
    public String getFullData(){
        return "<"+lastName+">" + "<"+name+">" + "<"+patronymic+">" + "<"+birthDate+">" + " " + "<"+phoneNumber+">" + " " + "<"+gender+">" + "\n";
    }

    public Person() {
        new Person(
                "",
                "",
                "",
                "",
                0,
                Gender.male);
    }

    public Person(String name, String patronymic, String lastNme, String birthDate, long phoneNumber, Gender gender) {
        this.name = name;
        this.patronymic = patronymic;
        this.lastName = lastNme;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }


}
