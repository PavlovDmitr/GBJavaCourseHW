package controllers;

import exceptions.AppException;
import exceptions.ExceptionText;
import core.Person;

import java.io.FileWriter;
import java.io.IOException;

public class PersonWriter  implements AutoCloseable{
    private static Person person;

    public PersonWriter(Person inPerson) {
        person = inPerson;
    }

    public void writePersonToFile() throws AppException {
        String fileName = person.getLastName() + ".txt";
        String data = person.getFullData()+"\n";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(data);
        } catch (IOException e) {
            throw new AppException(ExceptionText.fileWrite);
        }
    }

    @Override
    public void close() {
        System.gc();
    }
}
