package _04FilesStreamsDirectories._01Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class _02WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "resources/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        int bytes = fileInputStream.read();
        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');

        while(bytes != -1) {
            char symbol = (char) bytes;

            //Do not put 'Not' in boolean declaration (always make it positive)
            boolean isPunctuation = punctuationTable.contains(symbol);
//            boolean isPunctuation = ",.!?".contains(symbol + "");

            if(!isPunctuation) {
                fileOutputStream.write(symbol);
            }

            bytes = fileInputStream.read();
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
