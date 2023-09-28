package _04FilesStreamsDirectories._02Exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _09CopyAPicture {
    public static void main(String[] args) throws IOException {
        String path = "resources/404.jpg";
        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("picture-copy.jpg");

        byte[] data = inputStream.readAllBytes();
//        List<Character> data = new ArrayList<>();
//
//        for (int bytes = inputStream.read(); bytes != -1; bytes = inputStream.read()) {
//            data.add((char)bytes);
//        }

        inputStream.close();

        for (byte datum : data) {
            outputStream.write(datum);
        }

        outputStream.close();
    }
}
