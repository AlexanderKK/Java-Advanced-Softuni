package _04FilesStreamsDirectories._02Exercise;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class _12CreateZipArchive {
    public static void main(String[] args) throws IOException {
        File file1 = new File("results.txt");
        File file2 = new File("merged.txt");
        File file3 = new File("output.txt");

        List<File> files = List.of(file1, file2, file3);
        zipFiles(files, "files.zip");
    }

    public static void zipFiles(List<File> files, String zipName) throws IOException {
        //Declare output stream
        FileOutputStream outputStream = new FileOutputStream(zipName);

        //Declare zip stream stepping over it
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);

        for (File file : files) {
            FileInputStream inputStream = new FileInputStream(file);

            byte[] fileBytes = inputStream.readAllBytes();

            inputStream.close();

            ZipEntry zipEntry = new ZipEntry(file.getName());

            zipOutputStream.putNextEntry(zipEntry);

            zipOutputStream.write(fileBytes);
        }

        zipOutputStream.close();
    }
}
