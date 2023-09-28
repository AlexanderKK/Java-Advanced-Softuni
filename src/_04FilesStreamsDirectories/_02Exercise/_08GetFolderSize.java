package _04FilesStreamsDirectories._02Exercise;

import java.io.File;

public class _08GetFolderSize {
    public static void main(String[] args) {
        String path = "resources/02. resourcesExercise/Exercises Resources";

        File file = new File(path);

        int directorySize = 0;
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            
            if (files != null) {
                for (File f : files) {
                    directorySize += f.length();
                }
            }
        }
        System.out.println("Folder size: " + directorySize);
    }
}
