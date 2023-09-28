package _04FilesStreamsDirectories._02Exercise;

import java.io.File;

public class _08GetFolderSize2 {
    public static void main(String[] args) {
        String directoryPath = "resources/02. resourcesExercise/Exercises Resources";

        File root = new File(directoryPath);

        long dirSize = 0L;
        if(root.isDirectory()) {
            File[] files = root.listFiles();

            if(files != null) {
                for (File file : files) {
                    dirSize += file.length();
                }
            }
        }

        System.out.printf("Folder size: %d%n", dirSize);
    }
}
