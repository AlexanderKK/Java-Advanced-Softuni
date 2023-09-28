package _04FilesStreamsDirectories._01Lab;

import java.io.*;
import java.util.ArrayDeque;

public class _08NestedFolders {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String address = "resources\\Files-and-Streams";

        //BFS algorithm
        File root = new File(address);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(root);

        int countFiles = 1;
        while(!queue.isEmpty()) {
            File file = queue.poll();

            if(file.isDirectory()) {
                System.out.println(file.getName());

                File[] files = file.listFiles();

                if (files != null) {
                    for (File f : files) {
                        if(f.isDirectory()) {
                            queue.offer(f);
                            countFiles++;
                        }
                    }
                }
            }
        }
        System.out.println(countFiles + " folders");
    }
}
