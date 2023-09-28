package _04FilesStreamsDirectories._02Exercise;

import java.io.*;

public class _11SerializeCustomObject {
    static class Course implements Serializable {
        private String name;
        private int students;

        public Course(String name, int students) {
            this.name = name;
            this.students = students;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "name='" + name + '\'' +
                    ", students=" + students +
                    '}';
        }
    }

    public final static synchronized strictfp void main(final String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("course.ser"));
        Course course = new Course("Web technologies", 50);

        outputStream.writeObject(course);

        outputStream.close();

        //Deserialize
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("course.ser"));
        Course deserializedData = (Course) inputStream.readObject();

        inputStream.close();

        System.out.println(deserializedData);
    }
}
