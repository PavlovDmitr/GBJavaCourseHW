package seminar3;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class pathToEndMap {
    public static void main(String[] args) {
        String filesFolder = "seminar3\\";
        String inputFile = new String();
        
        try {
            String folderPath = pathToEndMap.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            System.out.println(folderPath);
            inputFile = folderPath.concat(filesFolder.concat("map.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] data = fileRead(inputFile);
        calcTracesToEndMap(convertToNumMap(data), 1, 1);
    }

    


    private static void printIntArray(int[][] gameMap) {
        System.out.println("------------------------------------------");
        for (int i = 0; i < gameMap[0].length; i++) {
            for (int j = 0; j < gameMap.length; j++) {
                System.out.printf(" %d ", gameMap[j][i]);
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    public static int[][] convertToNumMap(String[] inputData) {
        int tempStrArrLenght = inputData.length;
        int tempStrArr0Lenght = inputData[0].split(" ").length;
        String[] tempStrArrChars = new String[tempStrArr0Lenght];
        int[][] newData = new int[tempStrArrLenght][tempStrArr0Lenght];
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


    public static void calcTracesToEndMap2(int[][] gameMap, int startXPosition, int startYPosition) {
        int currentYPOsition = startYPosition;
        int currentXPosition = startXPosition;
        int setter = 1;
        printIntArray(gameMap);
        if (startXPosition > 1) {for (int i = startXPosition - 1; i < gameMap.length; i++) {gameMap[i][startYPosition - 1] = 0;}        }
        if (startYPosition > 1) {for (int i = startYPosition - 1; i < gameMap[startXPosition].length; i++) {gameMap[startXPosition - 1][i] = 0;}        }
        System.out.println("--------------------------------------------------------");
        printIntArray(gameMap);
        for (currentYPOsition = startYPosition; currentYPOsition < gameMap.length; currentYPOsition++) {
            for (currentXPosition = startXPosition; currentXPosition < gameMap[currentYPOsition].length; currentXPosition++) {

                if (gameMap[currentYPOsition][currentXPosition] == -1 && gameMap[currentYPOsition][currentXPosition-1] != 0){
                    if(currentYPOsition == 1 || currentXPosition == 1) {gameMap[currentYPOsition][currentXPosition] = 1;}
                    else {gameMap[currentYPOsition][currentXPosition] = gameMap[currentYPOsition-1][currentXPosition] + gameMap[currentYPOsition][currentXPosition-1];}
                }
                else{if (gameMap[currentYPOsition][currentXPosition] == 0 && gameMap[currentYPOsition][currentXPosition-1] == 0) gameMap[currentYPOsition][currentXPosition] = 0;}



            }
            
        }
    }


    public static void calcTracesToEndMap(int[][] gameMap, int startXPosition, int startYPosition) {
        int positionX = startXPosition;
        int positionY = startYPosition;
        int setter = 1;
        printIntArray(gameMap);
        if (startXPosition > 1) {for (int i = startXPosition - 1; i < gameMap.length; i++) {gameMap[i][startYPosition - 1] = 0;}        }
        if (startYPosition > 1) {for (int i = startYPosition - 1; i < gameMap[startXPosition].length; i++) {gameMap[startXPosition - 1][i] = 0;}        }
        for (positionX = startXPosition; positionX < gameMap.length - 1; positionX++) {
            for (positionY = startYPosition; positionY < gameMap[positionX].length - 1; positionY++) {
                setter = 1;
                if ((positionX == 1) || (positionY == 1)){
                    if (gameMap[positionX][positionY] == 0 ) setter = 0;
                    else gameMap[positionX][positionY] = setter;
                } 
                else {
                    //if (gameMap[posX][posY] == 0) setter = 0;
                    if (gameMap[positionX][positionY] != 0 ) {
                        gameMap[positionX][positionY] = (gameMap[positionX][positionY - 1] + gameMap[positionX - 1][positionY]) * setter;
                    }
                    if ((gameMap[positionX][positionY] == 0 ) || (gameMap[positionX][positionY-1] == 0) ) {
                        gameMap[positionX][positionY] = 0;
                    }
                }
            }
        }
        printIntArray(gameMap);
    }
}