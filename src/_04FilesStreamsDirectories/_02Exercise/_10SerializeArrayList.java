package _04FilesStreamsDirectories._02Exercise;

import java.io.*;
import java.util.List;

public class _10SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Double> obj = List.of(2.4, 3.3, 4.7, 5.1, 7.0);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("list.ser"));

        outputStream.writeObject(obj);
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("list.ser"));

        List<Double> result = (List) inputStream.readObject();

        result.forEach(System.out::println);
    }
}
