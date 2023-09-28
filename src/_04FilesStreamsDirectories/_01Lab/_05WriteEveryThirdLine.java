package _04FilesStreamsDirectories._01Lab;

import java.io.*;

public class _05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        OutputStream outputStream = new FileOutputStream("every-third-line.txt");

        //Better performance for reading data and stream functionality
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        String line = reader.readLine();
        int lineCounter = 1;

        while(line != null) {
            if(lineCounter % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }

            line = reader.readLine();
            lineCounter++;
        }

        reader.close();

        writer.flush();
        writer.close();
    }
}
