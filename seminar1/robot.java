package seminar1;

/*
 * Задача:
 * два числа: 
 *      a, b, a<b a,b целые числа
 * два действия +c, *d
 * сколькими путями достичь ситуации a == b
 */
import java.util.Scanner;

public class robot {
    public static void main(String[] args) {
        int[] startValues = getStartValues();
        int a = startValues[0];
        int b = startValues[1];
        int c = startValues[2];
        int d = startValues[3];
        int count = 0;
        int newA = 0;
        System.out.println("\033[H\033[2J");
        System.out.printf("a = %d, b = %d, c = %d, d = %d \n", a, b, c, d);
        int aStart = a;
        int k = 0;
        for (int i = a; i < b; i = i + c) {
            count = k;
            for (int j = aStart; j <= a; j = j + c)
                System.out.printf("a(count) = %d ", j);
            k++;
            a = i;
            while (a < b) {
                newA = mult(a, d);
                if (newA <= b) {
                    System.out.printf("a(if) = %d ", a);
                    a = newA;
                    count++;
                } else {
                    System.out.printf("a(else) = %d ", a);
                    a = inc(a, c);
                    count++;

                }
            }

            if (a == b) {
                System.out.printf("a(end) = %d ", a);
                System.out.printf("\nкол-во шагов: %d в маршруте %d\n", count, i);
            } else {
                System.out.printf("\nнет маршрута %d\n", i);
                count = 0;
            }
            count = 0;
        }

    }

    public static int[] getStartValues() {
        int[] result = new int[4];
        char[] varName = { 'A', 'B', 'C', 'D' };
        Scanner myScanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            result[i] = getNumByUser(String.format("pls insrt %c: ", varName[i]), myScanner);
        }
        myScanner.close();
        return result;
    }

    public static int getNumByUser(String text, Scanner myScanner) {
        int result = 0;
        boolean cicle_checker = true;

        boolean flag = false;
        while (cicle_checker) {
            System.out.println("\033[H\033[2J");
            System.out.println(text);
            flag = myScanner.hasNextInt();
            if (flag) {
                result = myScanner.nextInt();
                cicle_checker = false;
            } else {
                myScanner.next();
            }
        }

        return result;
    }

    public static int inc(int a, int c) {
        return a + c;
    }

    public static int mult(int a, int d) {
        return a * d;
    }

}
