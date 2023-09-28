package _04FilesStreamsDirectories._02Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class _04CountCharacterTypes2 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/02. resourcesExercise/input.txt"));
             PrintWriter writer = new PrintWriter("output.txt")) {

            Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
            Set<Character> punctuationMarks = Set.of('.', '!', '?', ',');
            Set<Character> excludingTokens = Set.of('\n', '\r', ' ');

            int vowelsCount = 0;
            int punctuationMarksCount = 0;
            int otherTokensCount = 0;

            int bytes;
            while((bytes = reader.read()) != -1) {
                char currentToken = (char)bytes;

                if(vowels.contains(currentToken)) {
                    vowelsCount++;
                } else if(punctuationMarks.contains(currentToken)) {
                    punctuationMarksCount++;
                } else if(!excludingTokens.contains(currentToken)) {
                    otherTokensCount++;
                }
            }

            reader.close();
            writer.flush();
            writer.close();

            writer.printf("Vowels: %d%n", vowelsCount);
            writer.printf("Other symbols: %d%n", otherTokensCount);
            writer.printf("Punctuation: %d%n", punctuationMarksCount);


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
