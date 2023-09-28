package _04FilesStreamsDirectories._02Exercise;

import java.io.*;
import java.util.Set;

public class _03ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "resources\\02. resourcesExercise\\Exercises Resources\\input.txt";

//        try(BufferedReader reader = new BufferedReader(new FileReader(path));
//            PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
//
//            int bytes = reader.read();
//            while(bytes != -1) {
//                char symbol = (char) bytes;
//                boolean isLetter = Character.isLetter(symbol);
//
//                if(isLetter) {
//                    writer.print(Character.toUpperCase(symbol));
//                } else {
//                    writer.print(symbol);
//                }
//
//                bytes = reader.read();
//            }
//
//        } catch(IOException e) {
//            e.printStackTrace();
//        }

        BufferedReader reader = new BufferedReader(new FileReader(path));
        PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

        reader.lines().forEach(line -> writer.println(line.toUpperCase()));

        reader.close();
        writer.close();
    }
}
