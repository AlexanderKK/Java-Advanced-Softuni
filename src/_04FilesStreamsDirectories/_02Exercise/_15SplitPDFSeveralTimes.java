package _04FilesStreamsDirectories._02Exercise;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class _15SplitPDFSeveralTimes {
    public static void main(String[] args) throws IOException {
        //Loading an existing PDF document
        File file = new File("joined.pdf");
        PDDocument document = Loader.loadPDF(file);

        //Instantiating Splitter class
        Splitter splitter = new Splitter();

        //splitting the pages of a PDF document
        List<PDDocument> Pages = splitter.split(document);

        //Creating an iterator
        Iterator<PDDocument> iterator = Pages.listIterator();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Times to split a pdf: ");
        int times = scanner.nextInt();
        if(times <= 0) {
            times = 1;
        }

        //Split Document
        splitSeveralTimes(times, document, iterator);

        document.close();
    }

    private static void splitSeveralTimes(int times, PDDocument document, Iterator<PDDocument> iterator) throws IOException {
        String root = "E:\\IdeaProjects\\JavaAdvanced-May";
        File rootDir = new File(root);
        for(File f : Objects.requireNonNull(rootDir.listFiles())) {
            if(f.getName().contains("part")) {
                if(f.isFile()) {
                    f.delete();
                } else if(f.isDirectory()) {
                    File[] contents = f.listFiles();
                    for (File content : contents) {
                        content.delete();
                    }
                    f.delete();
                }
            }
        }

        int segment = document.getNumberOfPages() / times;
        int count = 1;

        Map<Integer, PDFMergerUtility> utList = new LinkedHashMap<>();
        for (int i = 1; i <= times; i++) {
            utList.put(i, new PDFMergerUtility());
            clearDirOrFile("part" + i);

            Files.createDirectory(Paths.get("part" + i));
        }

        PDFMergerUtility ut;
        //Saving each page as an individual document
        int i = 1;
        while(iterator.hasNext()) {
            //Get current utility
            ut = utList.get(count);

            PDDocument pd = iterator.next();

            pd.save("part" + count + "/page" + i + ".pdf");
            ut.addSource("part" + count + "/page" + i + ".pdf");

            //Split by times
            if(i % segment == 0) {
                count++;

                if(count > times) {
                    count = times;
                }
            }

            i++;
        }

        for (var entry : utList.entrySet()) {
            clearDirOrFile("part" + entry.getKey() + ".pdf");
            PDFMergerUtility utility = entry.getValue();

            utility.setDestinationFileName("part" + entry.getKey() + ".pdf");
            utility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        }
    }

    private static void clearDirOrFile(String path) {
        File f = new File(path);

        if(f.isDirectory()) {
            File[] contents = f.listFiles();
            for (File content : contents) {
                content.delete();
            }
            f.delete();
        } else if(f.isFile()) {
            f.delete();
        }
    }
}