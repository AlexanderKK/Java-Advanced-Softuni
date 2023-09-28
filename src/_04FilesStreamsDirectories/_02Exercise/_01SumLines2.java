package _04FilesStreamsDirectories._02Exercise;

import java.io.*;

public class _01SumLines2 {
    public static void main(String[] args) throws IOException {
        String inputPath = "resources/02. resourcesExercise/input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));

//        int sum = 0;
//        int bytes;
//        int resetCounter = 0;

        //Reading every token - using read() method

//        while((bytes = reader.read()) != -1) {
//
//            if((char) bytes == '\n' || (char)bytes == '\r') {
//                resetCounter++;
//            }
//
//            if(resetCounter == 0) {
//                sum += bytes;
//            }
//
//            if(resetCounter == 2) {
//                System.out.println(sum);
//                sum = 0;
//                resetCounter = 0;
//            }
//        }
//        System.out.println(sum);

        //Reading every line - using readLine() method

        String line;
        while((line = reader.readLine()) != null) {
            int sum = 0;
            for(char token : line.toCharArray()) {
                sum += token;
            }
            System.out.println(sum);
        }

        reader.close();
    }
}
