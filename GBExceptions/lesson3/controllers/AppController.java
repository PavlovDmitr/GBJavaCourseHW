package controllers;

import exceptions.AppException;
import exceptions.ExceptionText;
import view.View;
import view.PromptText;
import core.PersonFillController;

import java.util.Objects;

public class AppController {
    private final View view;
    private final PersonFillController entry;

    public AppController() {
        view = new View();
        entry = new PersonFillController();
    }

    public void run() {
        String input = "";
        while (!Objects.equals(input, "EXIT")) {
            try {
                input = view.enterText(PromptText.fullNameMsg);
                setFullName(input);

                input = view.enterText(PromptText.dateMsg);
                entry.setBirthDate(input);

                input = view.enterText(PromptText.phoneNumberMsg);
                entry.setPhoneNumber(input);

                input = view.enterText(PromptText.genderMsg);
                entry.setGender(input);

                try (PersonWriter person = new PersonWriter(entry.getEntry())) {
                    person.writePersonToFile();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    throw new AppException(e.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.gc();
            }


        }
    }

    private void setFullName(String msg) throws AppException {
        String[] splitInput = msg.split(" ");
        verifyWordsCount(splitInput);
        entry.setNme(splitInput[0]);
        entry.setPatronymic(splitInput[1]);
        entry.setLastName(splitInput[1]);
    }

    private void verifyWordsCount(String[] splitInput) throws AppException {
        if (splitInput.length == 3) {
            return;
        }
        throw new AppException(ExceptionText.wordsCountName);
    }

}





