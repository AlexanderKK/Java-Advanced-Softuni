package _04FilesStreamsDirectories._01Lab;

import java.io.*;

public class _09SerializeCustomObject {
    static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "Cube{" +
                    "color='" + color + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    ", depth=" + depth +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Object cube = new Cube("green", 15.3, 12.4, 3.0);

        //Serialize
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("save.txt"));

        //Write object to file
        outputStream.writeObject(cube);

        //Close stream
        outputStream.close();

        //Deserialize
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("save.txt"));

        //Get data as type Cube
        Cube data = (Cube) inputStream.readObject();
        System.out.println(data);

        inputStream.close();


//        SERIALIZATION!!!

//        List<Integer> numbers = new ArrayList<>();
//
//        numbers.add(13);
//        numbers.add(42);
//        numbers.add(69);
//        numbers.add(73);
//
//
//        //Serialization
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serialization.txt"));
//
//        outputStream.writeObject(numbers);
//
//        outputStream.close();
//
//
//        //Deserialization
//        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serialization.txt"));
//
//        List<Integer> list = (List)inputStream.readObject();
//        list.forEach(System.out::println);
    }
}
