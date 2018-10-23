package personal.finances.solid;

import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilePrinter implements DataExporter {

    @Override
    public void exportData(String data) {
        File file = new File("output_report.txt");
        try {            
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            pw.print(data);
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(FilePrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
