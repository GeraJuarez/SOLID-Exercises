package personal.finances.solid;

import personal.finances.solid.readers.FileReader;
import personal.finances.solid.readers.DataReader;

/**
 *
 * @author Zegerd
 */
public class PersonalFinancesSOLID {
    public static void main(String[] args) {
       
        // Read input with console
        //DataReader dr = new ConsoleReader();
        
        // Read input with file
        DataReader dr = new FileReader("data.txt");
        
        // Report
        Report report = new DailyReport();
        
        // Use Pesos
        Currency currency = new Peso();
        
        // Output with console
        DataExporter de = new ConsolePrinter();
        
        PersonalFinances pf = new PersonalFinances(report, dr, de, currency);
        pf.start();
    }
    
}
