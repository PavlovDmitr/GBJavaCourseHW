package seminarFin;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {

        String filesFolder = "seminar4\\";
        String inputFile = new String();

        try {
            String folderPath = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String folderPathStr = String.valueOf(folderPath).substring(0, folderPath.length() - 11);
            System.out.println(folderPathStr);
            inputFile = folderPathStr.concat("map.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] data = fileRead(inputFile);
        for (String string : data) {
            System.out.println(string);
        }
        System.out.println("end---------------------------text");
        Integer[][] dataInt = convertToNumMap(data);
        printIntArray(dataInt);
        paintArr(dataInt, new Point2D(4, 3, 1), new Point2D(0, 0, -5));
        printIntArray(dataInt);
        tracePath(dataInt);

    }

    public static LinkedList<Point2D> tracePath(Integer[][] arrMap, Point2D endPoint){
        LinkedList<Point2D> result = new LinkedList<>();
        Point2D finishPoint = new Point2D(1, 1, 1);
        Integer minFinishPointAreaValue = arrMap.length*arrMap[0].length;
        Boolean changeFlag = false;
        for (int i = 0; i < arrMap.length; i++) {
            for (int j = 0; j < arrMap[i].length; j++) {
                changeFlag = false;
                if  (arrMap[i][j] == endPoint.getValue()) {

                    for (int k: new int[] {-1, 1}) {
                        if (arrMap[i+k][j] != -1 && arrMap[i+k][j] < minFinishPointAreaValue){
                            minFinishPointAreaValue = arrMap[i+k][j];
                            changeFlag = true;
                        }
                        if (arrMap[i][j+k] != -1 && arrMap[i][j+k] < minFinishPointAreaValue){
                            minFinishPointAreaValue = arrMap[i][j+k];
                            changeFlag = true;
                        }
                    }
                    if (changeFlag) finishPoint = new Point2D(i,j,arrMap[i][j]);
                }
            }
        }
        Deque<Point2D> turn = new LinkedList<>();
        turn.addLast(finishPoint);
        while (turn.isEmpty() != true && !turn.peekLast().equalsValue(new Point2D(1,1,1))) {

        }


        return result;
    }

    public static void paintArr(Integer[][] arrMap, Point2D startPoint, Point2D endPoint) {
        Deque<Point2D> turn = new LinkedList<Point2D>();
        startPoint.setValue(1);
        turn.addLast(startPoint);
        arrMap[startPoint.getX()][startPoint.getY()] = 1;
        Point2D step = new Point2D(1,1,1);

        while (turn.isEmpty() != true && !turn.peekLast().equalsValue(endPoint)) {
            step = turn.pollFirst();
            for (int i : new int[] { -1, 1 }) {

                if (arrMap[step.getX() + i][step.getY()] == 0) {
                    turn.addLast(new Point2D(step.getX() + i, step.getY(), step.getValue() + 1));
                    arrMap[step.getX() + i][step.getY()] = step.getValue() + 1;
                    System.out.printf("x = %d, y = %d, value = %d \n", turn.peekLast().getX(), turn.peekLast().getY(),
                            turn.peekLast().getValue());
                }

                if (arrMap[step.getX()][step.getY() + i] == 0) {
                    turn.addLast(new Point2D(step.getX(), step.getY() + i, step.getValue() + 1));
                    arrMap[step.getX()][step.getY() + i] = step.getValue() + 1;
                    System.out.printf("x = %d, y = %d, value = %d \n", turn.peekLast().getX(), turn.peekLast().getY(),
                            turn.peekLast().getValue());
                }
            }

            if (arrMap[step.getX()][step.getY()] == -5) {
                turn.add(endPoint);
                System.out.printf("Exit find! X = %d, Y = %d \n", step.getX(), step.getY());
            }
            ;
        }
    }

    public static void li(Integer[][] arrMap) {

    }

    public static String[] fileRead(String filename) {
        try (DataInputStream doc = new DataInputStream(new FileInputStream(filename))) {
            StringBuilder dataFromFile = new StringBuilder();
            int i = -1;
            while ((i = doc.read()) != -1) {
                dataFromFile.append((char) i);
            }
            String[] data = dataFromFile.toString().split(System.lineSeparator()).clone();
            return data;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new String[] { ex.getMessage() };
        }

    }

    public static Integer[][] convertToNumMap(String[] inputData) {
        int tempStrArrLenght = inputData.length;
        int tempStrArr0Lenght = inputData[0].split(" ").length;
        String[] tempStrArrChars = new String[tempStrArr0Lenght];
        Integer[][] newData = new Integer[tempStrArrLenght][tempStrArr0Lenght];
        try {
            for (int j = 0; j < tempStrArrLenght; j++) {
                tempStrArrChars = inputData[j].split(" ");
                for (int j2 = 0; j2 < tempStrArr0Lenght; j2++) {
                    newData[j][j2] = Integer.parseInt(tempStrArrChars[j2]);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return newData;
    }

    private static void printIntArray(Integer[][] gameMap) {
        System.out.println("------------------------------------------");
        for (int i = 0; i < gameMap[0].length; i++) {
            for (int j = 0; j < gameMap.length; j++) {
                int memb = gameMap[i][j];
                if (memb == -1) {
                    System.out.printf(" ## ");
                }
                if (memb == -5) {
                    System.out.printf(" @@ ");
                }
                if (memb != -1 && memb >= 0 && memb < 10)
                    System.out.printf("  %d ", memb);
                if (memb != -1 && memb > 9)
                    System.out.printf(" %d ", memb);
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }
}


