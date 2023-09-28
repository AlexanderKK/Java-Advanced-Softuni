package _04FilesStreamsDirectories._02Exercise;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class _14SplitPDF {
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

        PDFMergerUtility ut1 = new PDFMergerUtility();
        PDFMergerUtility ut2 = new PDFMergerUtility();

        int pages = document.getNumberOfPages() / 2;

        clearDirOrFile("first");
        clearDirOrFile("second");

        //Saving each page as an individual document
        int i = 1;
        while(iterator.hasNext()) {
            PDDocument pd = iterator.next();

            //Split by half
            if(i <= pages) {
                pd.save("first/page" + i + ".pdf");
                ut1.addSource("first/page" + i + ".pdf");
            } else {
                pd.save("second/page" + i + ".pdf");
                ut2.addSource("second/page" + i + ".pdf");
            }

            //Split by page
//            if(i <= 7) {
//                pd.save("first/page" + i + ".pdf");
//                ut1.addSource("first/page" + i + ".pdf");
//            } else {
//                pd.save("second/page" + i + ".pdf");
//                ut2.addSource("second/page" + i + ".pdf");
//            }

            i++;
        }

        clearDirOrFile("first.pdf");
        ut1.setDestinationFileName("first.pdf");
        ut1.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        clearDirOrFile("second.pdf");
        ut2.setDestinationFileName("second.pdf");
        ut2.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        document.close();
    }

    private static void splitSeveralTimes(int times, PDDocument document, Iterator<PDDocument> iterator) throws IOException {
//        int pages = document.getNumberOfPages() / times;

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
            if(i % times == 0) {
                count++;
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
        } else if(f.isFile()) {
            f.delete();
        }
    }
}