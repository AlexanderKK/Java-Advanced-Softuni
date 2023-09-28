package _04FilesStreamsDirectories._02Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class _07MergeTwoFiles2 {
    public static void main(String[] args) {
        try {
            String path1 = "resources\\02. resourcesExercise\\Exercises Resources\\inputOne.txt";
            String path2 = "resources\\02. resourcesExercise\\Exercises Resources\\inputTwo.txt";

            byte[] byteArr = Files.readAllBytes(Path.of(path1));

            byte[] byteArr1 = new byte[byteArr.length + 1];
            System.arraycopy(byteArr, 0, byteArr1, 0, byteArr.length);
            byteArr1[byteArr1.length - 1] = 10;

            byte[] byteArr2 = Files.readAllBytes(Path.of(path2));

            Path outputPath = Paths.get("merged.txt");

            if(Files.notExists(outputPath)) {
                Files.write(outputPath, new byte[0], StandardOpenOption.CREATE_NEW);
            }

            Files.write(outputPath, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
            Files.write(outputPath, byteArr1, StandardOpenOption.WRITE);
            Files.write(outputPath, byteArr2, StandardOpenOption.APPEND);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
