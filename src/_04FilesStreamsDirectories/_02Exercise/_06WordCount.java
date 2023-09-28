package _04FilesStreamsDirectories._02Exercise;

import java.io.*;
import java.util.*;

public class _06WordCount {
    public static void main(String[] args) throws IOException {
        String path1 = "resources\\02. resourcesExercise\\Exercises Resources\\text.txt";
        String path2 = "resources\\02. resourcesExercise\\Exercises Resources\\words.txt";

        //Can read single character
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        //Can read single word
        Scanner fileReader = new Scanner(new FileInputStream(path1));
        Scanner fileReaderWords = new Scanner(new FileInputStream(path2));

        //Read words and append to set
        Set<String> words = new HashSet<>();
        while(fileReaderWords.hasNext()) {
            words.add(fileReaderWords.next());
        }
        fileReaderWords.close();

        //Declare a map
        Map<String, Integer> wordOccurrence = new HashMap<>();

        while(fileReader.hasNext()) {
            String word = fileReader.next();

            if(words.contains(word)) {
                //Add word if not present in map
                wordOccurrence.putIfAbsent(word, 0);

                //Increment occurrences of current word
                wordOccurrence.put(word, wordOccurrence.get(word) + 1);
            }
        }
        fileReader.close();

        PrintWriter writer = new PrintWriter(new FileOutputStream("results.txt"));

        wordOccurrence.entrySet().stream().sorted(
            (left, right) -> right.getValue() - left.getValue()
        ).forEach(entry -> {
            writer.printf("%s - %d%n", entry.getKey(), entry.getValue());

//            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        });

        writer.flush();
        writer.close();
    }
}
