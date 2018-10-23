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
        
        // Output with console
        DataExporter de = new ConsolePrinter();        
        // Output with File
        //DataExporter de = new FilePrinter();               
        
        // Use a Report
        Report report = new DailyReport();
        
        // Operations
        Operator op = new Operator();
        
        // Use Pesos
        Currency currency = new Peso();
        
        // Date Formater
        
        
        PersonalFinances pf = new PersonalFinances(
                dr, 
                de, 
                report,
                op,
                currency
        );
        pf.start();
    }
    
}
