package _04FilesStreamsDirectories._01Lab;

import java.io.*;
import java.util.Scanner;

public class _04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "resources/input.txt";
        //Input stream
        FileInputStream inputStream = new FileInputStream(path);

        //Output stream
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        PrintWriter printer = new PrintWriter(outputStream);

        //Enhanced functionality over input stream
        //Implementation of many useful input stream algorithms
        Scanner scanner = new Scanner(inputStream);

        while(scanner.hasNext()) {
            if(scanner.hasNextInt()) {
                printer.println(scanner.nextInt());
            }
            scanner.next();
        }

        inputStream.close();
        printer.close();
    }
}
