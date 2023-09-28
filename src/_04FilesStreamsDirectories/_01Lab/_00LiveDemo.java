package _04FilesStreamsDirectories._01Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _00LiveDemo {
    public static void main(String[] args) {
        Scanner scanner;

        //1.

//        Declare a path
//        String path = "D:\\SOFTUNI\\Java Advanced MAY- 23\\4 Streams, Files and Directories\\resources\\input.txt";
//
//        try {
//            //Declare input stream
//            FileInputStream fileInputStream = new FileInputStream(path);
//
//            //Read input from this stream(text file)
//            scanner = new Scanner(fileInputStream);
//
//            //Declare a collection
//            ArrayList<String> fileContent = new ArrayList<>();
//
//            String input;
//            while(!"END".equals(input = scanner.nextLine())) {
//                //Add line of content from text file to collection
//                fileContent.add(input);
//            }
//
//            //Print file contents
//            System.out.println(String.join(System.lineSeparator(), fileContent));
//        } catch (FileNotFoundException e) {
//            //If file does not exist or has an incorrect filename, handle the exception
//            throw new RuntimeException(e);
//        }

        //2.

        //Declare a path
        String path = "D:\\SOFTUNI\\Java Advanced MAY- 23\\4 Streams, Files and Directories\\resources\\input.txt";

        try {
            //Declare input stream
            FileInputStream fileInputStream = new FileInputStream(path);
            //1010101 -> byte
            int bytes = fileInputStream.read();

            //While there are bytes of data read bytes (data is always in bytes, but different data types)
            while(bytes != -1) {
                System.out.print((char) bytes);
                bytes = fileInputStream.read();
            }
            System.out.println();
        } catch (IOException e) {
            System.out.printf("File %s is missing%n", path);
        } finally {
            System.out.println("I am always executed no matter what");
        }
    }
}
