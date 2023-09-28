package _04FilesStreamsDirectories._02Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class _07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String path1 = "resources\\02. resourcesExercise\\Exercises Resources\\inputOne.txt";
        String path2 = "resources\\02. resourcesExercise\\Exercises Resources\\inputTwo.txt";

//        BufferedReader reader1 = new BufferedReader(new FileReader(path1));
//        BufferedReader reader2 = new BufferedReader(new FileReader(path2));
//
//        FileOutputStream writer = new FileOutputStream("merged.txt");
//
//        int bytes;
//
//        while((bytes = reader1.read()) != -1) {
//            writer.write(bytes);
//        }
//        reader1.close();
//
//        writer.write('\n');
//
//        while((bytes = reader2.read()) != -1) {
//            writer.write(bytes);
//        }
//        reader2.close();
//
//        writer.close();

        Path firstFile = Paths.get(path1);
        List<String> firstFileLines = Files.readAllLines(firstFile);

        Path secondFile = Paths.get(path2);
        List<String> secondFileLines = Files.readAllLines(secondFile);

        Path output = Paths.get("merged.txt");

        if(!Files.exists(output)) {
            Files.write(output, new byte[0], StandardOpenOption.CREATE_NEW);
        }
        Files.write(output, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
        Files.write(output, firstFileLines, StandardOpenOption.WRITE);
        Files.write(output, secondFileLines, StandardOpenOption.APPEND);
    }
}
