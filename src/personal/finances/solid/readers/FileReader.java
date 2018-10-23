package personal.finances.solid.readers;

import personal.finances.solid.readers.DataReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zegerd
 */
public class FileReader implements DataReader{
    private Scanner scanner;
    
    public FileReader(String path) {
        File file = new File(path);
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int readIntData() {
        return this.scanner.nextInt();
    }

    @Override
    public float readFloatData() {
        return this.scanner.nextFloat();
    }

    @Override
    public String readStringData() {        
        return this.scanner.next();
    }
    
}