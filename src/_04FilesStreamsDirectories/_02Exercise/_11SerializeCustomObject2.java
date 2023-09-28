package _04FilesStreamsDirectories._02Exercise;

import java.io.*;

public class _11SerializeCustomObject2 {
    public static class Course implements Serializable {
        private String title;
        private int students;

        public Course(String title, int students) {
            this.title = title;
            this.students = students;
        }

        @Override
        public String toString() {
            return "title: " + title + '\n' + "students: " + students;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("course.ser"));
        objectOutputStream.writeObject(new Course("Java Advanced", 230));

        objectOutputStream.flush();
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("course.ser"));
        Course deserializedData = (Course) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(deserializedData);
    }
}
