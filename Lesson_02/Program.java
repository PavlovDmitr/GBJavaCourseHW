package Lesson_02;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
 
public class Program {
  
    public static void main(String[] args) {
        
        


        Person tom = new Person("Tom", 34, 1.68, false);
        // запись в файл
        
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin")))
        {
           // записываем значения
            dos.writeChars(tom.name);
            dos.writeChars(String.valueOf(tom.age));
            System.out.println("File has been written");
        }
        catch(IOException ex){
              
            System.out.println(ex.getMessage());
        }  
          
        // обратное считывание из файла
        try(DataInputStream dos = new DataInputStream(new FileInputStream("input.txt")))
        {
           // записываем значения
            String name = dos.readUTF();
            int age = dos.readInt();
            System.out.printf("Name: %s  Age: %d", 
                    name, age);
        }
        catch(IOException ex){
              
            System.out.println(ex.getMessage());
        }  
    } 
}
  
class Person
{
    public String name;
    public int age;
    public double height;
    public boolean married;
      
    public Person(String n, int a, double h, boolean m)
    {
        this.name=n;
        this.height=h;
        this.age=a;
        this.married=m;
    }



    public static void readFile(Path path) throws IOException {

        // Files.newByteChannel() defaults to StandardOpenOption.READ
        try (SeekableByteChannel sbc = Files.newByteChannel(path)) {
            final int BUFFER_CAPACITY = 10;
            ByteBuffer buf = ByteBuffer.allocate(BUFFER_CAPACITY);

            // Read the bytes with the proper encoding for this platform. If
            // you skip this step, you might see foreign or illegible
            // characters.
            String encoding = System.getProperty("file.encoding");
            while (sbc.read(buf) > 0) {
                buf.flip();
                System.out.print(Charset.forName(encoding).decode(buf));
                buf.clear();
            }
        }    
    }
}