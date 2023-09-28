package _04FilesStreamsDirectories._01Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _01ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "resources\\input.txt";

        try {
            //Declare input stream
            FileInputStream fileInputStream = new FileInputStream(path);
            //1010101 -> byte
            int bytes = fileInputStream.read();

            //While there are bytes of data read bytes (data is always in bytes, but different data types)
            while(bytes != -1) {
                //Parse integer to byte representation (sequence of bits)
                System.out.print(Integer.toBinaryString(bytes) + " ");

                bytes = fileInputStream.read();
            }
            System.out.println();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.printf("File %s is missing%n", path);
        }
    }
}
