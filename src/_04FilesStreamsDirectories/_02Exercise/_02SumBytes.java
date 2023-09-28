package _04FilesStreamsDirectories._02Exercise;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _02SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "resources\\02. resourcesExercise\\Exercises Resources\\input.txt";

//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
//        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedReader reader = Files.newBufferedReader(Paths.get(path));

        BigInteger sum = new BigInteger("0");

        int bytes;
        while((bytes = reader.read()) != -1) {
            if(bytes != 10 && bytes != 13) {
                sum = sum.add(new BigInteger(bytes + ""));
            }
        }

        reader.close();
        System.out.println(sum);
    }
}
