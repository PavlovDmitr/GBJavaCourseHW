package seminar2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Sem2Hw2 {

    public static void main(String[] args) {
        Map<String, Double> data = new HashMap<>();
        String filesFolder = "seminar2\\";
        String inputFile = new String();
        String outputFile = new String();
        try {
            //System.out.println(new File(System.getProperty(outputFile)));
            String folderPath = Sem2Hw2.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            System.out.println(folderPath);
            inputFile = folderPath.concat(filesFolder.concat("input.txt"));
            outputFile = folderPath.concat(filesFolder.concat("output.txt"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        fileRead(inputFile, data);
        System.out.println(data.get("a"));
        System.out.println(data.get("b"));
        double c = Math.pow(data.get("a"), data.get("b"));

        System.out.println(c);
        data.put("result", c);
        System.out.println(data);
        File fs = new File(outputFile);
        if (fs.exists())
            fileWrite(outputFile, data);
        else {
            System.out.println("Файл для записи не существует! Попытка созднаия нового файла!");
            try {
                fs.createNewFile();
                System.out.println("Успех!");
            } catch (IOException e) {
                System.out.println("Провал!");
                System.out.println(e.getMessage());
            }
        }

    }

    public static Boolean fileWrite(String filename, Map<String, Double> data) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            // записываем значения
            dos.writeChars(data.get("result").toString());
            System.out.println("Output.txt file has been written");
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static void fileRead(String filename, Map<String, Double> data) {
        try (DataInputStream doc = new DataInputStream(new FileInputStream(filename))) {
            StringBuilder name = new StringBuilder();
            // Map <String, Integer> data = new HashMap<String, Integer>();
            int i = -1;
            while ((i = doc.read()) != -1) {
                name.append((char) i);
            }
            String[] tempStrArr = name.toString().split(System.lineSeparator());
            for (String string : tempStrArr) {
                String[] tempWordArr = string.split(" ");
                data.put(tempWordArr[0], Double.parseDouble(tempWordArr[1]));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
