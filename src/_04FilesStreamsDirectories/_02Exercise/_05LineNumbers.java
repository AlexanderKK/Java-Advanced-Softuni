package _04FilesStreamsDirectories._02Exercise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _05LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "resources\\02. resourcesExercise\\inputLineNumbers.txt";

        Stream<String> lines = Files.lines(Paths.get(path));
        List<String> fileLines = lines.collect(Collectors.toList());

        PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));

        int lineCounter = 0;
        for(String line : fileLines) {
//            System.out.printf("%d. %s%n", lineCounter++, line);   //Print to console
            writer.printf("%d. %s%n", ++lineCounter, line);   //Write to file
        }

        writer.close();
    }
}
