package _04FilesStreamsDirectories._02Exercise;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class _02SumBytes2 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("resources/02. resourcesExercise/input.txt")));

//            Set<Character> excludingChars = new HashSet<Character>(){{ add('\n'); add('\r'); }};
            Set<Character> excludingChars = Set.of('\n', '\r');

            int sum = 0;
            int bytes;
            while((bytes = reader.read()) != -1) {
                if(!excludingChars.contains((char)bytes)) {
                    sum += bytes;
                }
            }

            System.out.println(sum);
        } catch(IOException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
}
