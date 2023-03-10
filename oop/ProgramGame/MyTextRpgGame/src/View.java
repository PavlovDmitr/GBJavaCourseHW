import units.BaseHero;
import units.Team;

import java.util.Collections;

public class View {
    private static int step = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(10, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(10, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(10, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getChar(int x, int y){
        String out = "| ";
        for (BaseHero human: Main.fight) {
            if (human.getCoordinate().getPosX() == x && human.getCoordinate().getPosY() == y){
                if (human.getCurrentHp() == 0) {
                    out = "|" + (AnsiColors.ANSI_YELLOW + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                    break;
                }
                if (human.getTeam() == Team.RED) out = "|" + (AnsiColors.ANSI_RED + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                if (human.getTeam() == Team.BLUE) out = "|" + (AnsiColors.ANSI_BLUE + human.getInfo().charAt(0) + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        int team1members = Main.team1.toArray().length;
        int team2members = Main.team2.toArray().length;
        if (step == 1 ){
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;
        Main.fight.forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
        System.out.print("_".repeat(l[0]*2));
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("Red side");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l[0]-9));
        System.out.println(":\tBlue side");
        for (int i = 0; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.printf("%s %s", Main.team1.get(0).getInfo(), Main.team1.get(0).getStatus());
        tabSetter(Main.team1.get(0).toString().length(), l[0]);
        System.out.printf("%s %s\n", Main.team2.get(0).getInfo(), Main.team2.get(0).getStatus());
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.printf("%s %s",Main.team1.get(i-1).getInfo(), Main.team1.get(i-1).getStatus());
            tabSetter(Main.team1.get(i-1).toString().length(), l[0]);
            System.out.printf("%s %s\n",Main.team2.get(i-1).getInfo(), Main.team2.get(i-1).getStatus());
            System.out.println(midl10);
        }
        for (int j = 0; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.printf("%s %s", Main.team1.get(9).getInfo(), Main.team1.get(9).getStatus()); // System.out.printf("%s | %s | %s, \n", baseHero.getInfo(), baseHero.getSpeed(), baseHero.getTeam());
        tabSetter(Main.team1.get(9).toString().length(), l[0]);
        System.out.printf("%s %s\n",Main.team2.get(9).getInfo(), Main.team2.get(9).getStatus());
        System.out.println(bottom10);
    }

    public static void finish(String message) {
        System.out.printf("Победила сторона %s \n", message);
    }
}