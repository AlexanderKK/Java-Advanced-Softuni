package _04FilesStreamsDirectories._02Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class _06WordCount2 {
    public static void main(String[] args) throws IOException {
        String pathWords = "resources/02. resourcesExercise/Exercises Resources/words.txt";
        String pathText = "resources/02. resourcesExercise/Exercises Resources/text.txt";

        Map<String, Integer> wordOccurrences = new HashMap<>();

        Scanner scannerWords = new Scanner(new FileInputStream(pathWords));
        Scanner scannerText = new Scanner(new FileInputStream(pathText));

        Set<String> words = new HashSet<>();

        while(scannerWords.hasNext()) {
            words.add(scannerWords.next());
        }
        scannerWords.close();

        while(scannerText.hasNext()) {
            String currentWord = scannerText.next();

            if(words.contains(currentWord)) {
                wordOccurrences.putIfAbsent(currentWord, 0);
                wordOccurrences.put(currentWord, wordOccurrences.get(currentWord) + 1);
            }
        }
        scannerText.close();

        PrintWriter writer = new PrintWriter(new FileOutputStream("results.txt"));

        wordOccurrences.entrySet().stream()
                .sorted((left, right) -> right.getValue() - left.getValue())
                .forEach(entry -> {
                    writer.printf("%s - %d%n", entry.getKey(), entry.getValue());
                });

        writer.close();
    }
}
