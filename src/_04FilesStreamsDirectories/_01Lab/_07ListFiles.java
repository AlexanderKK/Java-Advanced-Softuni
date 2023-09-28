package _04FilesStreamsDirectories._01Lab;

import java.io.File;

public class _07ListFiles {
    public static void main(String[] args) {
        String address = "resources\\Files-and-Streams";

        File file = new File(address);
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if(f.isFile()) {
                        double size = 1.0 * f.length() / 1024;
                        String sizeStr = String.format("%.2f", size);
                        sizeStr = sizeStr.substring(0, sizeStr.length() - 1);

                        System.out.printf("%s: [%s KB]%n", f.getName(), sizeStr);
                    }
                }
            }
        }
    }
}
