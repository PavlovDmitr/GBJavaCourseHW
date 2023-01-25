// Написать программу вычисления n-ого треугольного числа.

package seminar1;

import java.util.Scanner;

public class Sem1Hw1 {
    public static void main(String[] args) {
        int numTriNum = getNumberByUser("Введите номер необходимого числа ");
        int triAngularNumber = calcTriangularNumber(numTriNum);
        System.out.printf("Треугольное число № %d имеет значение %d ", numTriNum, triAngularNumber);
        
    }

    public static int calcTriangularNumber(int number) {
        int result = 0;
        for (int i = number; i>0; i--){
            result = result + i;
        }
        return result;
    }

    public static int getNumberByUser(String text){
        int result = 0;
        boolean cicleChecker = true;
        Scanner myScanner = new Scanner(System.in);
        boolean numberChecker = true;
        while (cicleChecker){
            System.out.println("\033[H\033[2J");
            if (!numberChecker) System.out.println("Номер введеного числа должен быть целым, положительным");
            System.out.println(text);
            boolean flag = myScanner.hasNextInt();
            if (flag) {
                result = myScanner.nextInt();
                if (result>0) cicleChecker = false;
                else numberChecker = false;
            }
            else{
                myScanner.nextLine();
            }
        }
        myScanner.close();
        return result;
    }



    
}


// Написать программу вычисления n-ого треугольного числа. url

/**
 * 0. Прочитать что такое треугольное число.
 * 0.0.1 Рекуррентная формула для n-го треугольного числа:
 *
 *              T{n}=T{n-1}+n
 * 
 * 0.1 Уточнить ТЗ (решил что не нужно)
 * 0.2 Задание - пользователь вводит номер числа программа вычисляет и возвращает значение числа.
 * 0.3 Декомпозиция 
 *   1. Получение от пользователя номера (n) необходимого числа
 *   2. Вычисление треугольного числа
 *   3. Вывод результата на печать
 * 
 */