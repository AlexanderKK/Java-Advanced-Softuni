package _04FilesStreamsDirectories._02Exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _01SumLines {
    public static void main(String[] args) {
        String path = "resources\\02. resourcesExercise\\Exercises Resources\\input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = reader.readLine()) != null) {
                int sumASCII = 0;

                for (int i = 0; i < line.length(); i++) {
                    sumASCII += line.charAt(i);
                }

                System.out.println(sumASCII);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}