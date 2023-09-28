package _04FilesStreamsDirectories._01Lab;

import java.io.*;
import java.util.Set;

public class _03CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "resources/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

//        PrintWriter printer = new PrintWriter(fileOutputStream);

        int bytes = fileInputStream.read();
        Set<Integer> delimiterTable = Set.of(10, 32);

        while(bytes != -1) {
            boolean isDelimiter = delimiterTable.contains(bytes);

            if(isDelimiter) {
//                printer.print((char) bytes);
                fileOutputStream.write(bytes);
            } else {
//                printer.print(bytes);
                String digits = String.valueOf(bytes);

                for (int i = 0; i < digits.length(); i++) {
                    fileOutputStream.write(digits.charAt(i));
                }
            }

            bytes = fileInputStream.read();
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
