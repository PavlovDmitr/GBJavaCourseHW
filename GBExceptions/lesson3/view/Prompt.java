package view;

import java.util.Scanner;

public class Prompt {

    public static String prompt(String entryText){
        Scanner scanner = new Scanner(System.in);

        System.out.print(entryText);

        return scanner.nextLine();
    }
}
