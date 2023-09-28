package _04FilesStreamsDirectories._02Exercise;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class _04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuationMarks = Set.of(',', '.', '!', '?');
        Set<Character> excludingTokens = Set.of('\n', '\r', ' ');

        String path = "resources\\02. resourcesExercise\\Exercises Resources\\input.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt"));

        int vowelsCount = 0;
        int marksCount = 0;
        int othersCount = 0;

        int bytes = reader.read();
        while(bytes != -1) {
            char token = (char)bytes;
            boolean isVowel = vowels.contains(token);
            boolean isPunctuationMark = punctuationMarks.contains(token);
            boolean isForbidden = excludingTokens.contains(token);

            if(isVowel) {
                vowelsCount ++;
            } else if(isPunctuationMark) {
                marksCount++;
            } else if(!isForbidden) {
                othersCount++;
            }

            bytes = reader.read();
        }

        reader.close();

        writer.println("Vowels: " + vowelsCount);
        writer.println("Other symbols: " + othersCount);
        writer.println("Punctuation: " + marksCount);

        writer.close();
    }
}
