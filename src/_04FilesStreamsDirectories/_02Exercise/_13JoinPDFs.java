package _04FilesStreamsDirectories._02Exercise;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import java.io.*;

public class _13JoinPDFs {
    public static void main(String[] args) throws IOException {
        String path1 = "resources/1_-_.pdf";
        String path2 = "resources/3_-_.pdf";

        PDFMergerUtility ut = new PDFMergerUtility();
        ut.addSource(path1);
        ut.addSource(path2);

//        PDFPageable pdf = new PDFPageable("joined.pdf");

        ut.setDestinationFileName("joined.pdf");
        ut.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }
}
