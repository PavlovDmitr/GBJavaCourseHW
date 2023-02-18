package seminar1;


import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * program
 */
public class program2 {

    public static void main(String[] args) {

//         Scanner in = new Scanner(System.in);
//         System.out.print( "insert russian text: ");

//         String input = in.nextLine();
//         System.out.println(input);
//         try{
//             String result = new String(input.getBytes("cp866"), Charset.forName("cp866"));
//             System.out.printf("You write(тут русский текст должен быть): %s \n", result);
//         } catch (UnsupportedEncodingException e) {
//             System.out.println(e);
//         }
        

//         in.close();
            
            Scanner input = new Scanner(System.in,  "UTF-8");
            String word = input.nextLine();

            try {
                word = new String(word.getBytes("windows-1251"), Charset.forName("UTF-8"));
            } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("\033[H\033[2J");
            System.out.println(word);
            input.close();


    }
}