package seminar4;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Queue;

public class AlgoLi {
    public static void main(String[] args) {
        // Integer[][] arrMap = new Integer[12][12];  
        // createMap(arrMap);  
        // for (int i = 0; i < arrMap.length; i++) {
        //     for (int j = 0; j < arrMap.length; j++) {
        //         System.out.print(arrMap[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.println(arrMap[5][5]);
        String filesFolder = "seminar3\\";
        String inputFile = new String();
        
        try {
            String folderPath = AlgoLi.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            System.out.println(folderPath);
            inputFile = folderPath.concat(filesFolder.concat("map.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] data = fileRead(inputFile);
        int[][] dataInt = convertToNumMap(data);

    }
    public static void createMap(Integer[][] arrMap){
        
        for(int i = 0; i<arrMap.length; i++) {

            arrMap[i][0] = -1;
            arrMap[i][arrMap.length] = -1;
            arrMap[0][i] = -1;
            arrMap[arrMap.length][i] = -1;
        }
        for (int i = 1; i < 4; i++) {
            arrMap[1][i] = -1;
            arrMap[7][i] = -1;
       
        }
        for (int i = 1; i < 3; i++) {
            arrMap[i][4] = -1;
            arrMap[7][i+5] = -1;
        }
        for (int i = 1; i < 3; i++) {
            arrMap[i][4] = -1;
            arrMap[7][i+5] = -1;
        }
        
        
        
        arrMap[2][4] = -1;
        arrMap[1][1] = -1;

    }

    public static void paintArr(Integer[][] arrMap){
        // Queue <> turn = new LinkedList<>();

    




    }

    public static void li(Integer[][] arrMap){

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
}