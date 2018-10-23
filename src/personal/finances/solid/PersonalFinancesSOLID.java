package personal.finances.solid;

import personal.finances.solid.CurrencyFormats.Peso;
import personal.finances.solid.CurrencyFormats.Currency;
import personal.finances.solid.CurrencyFormats.Yen;
import personal.finances.solid.Reports.DailyReport;
import personal.finances.solid.Reports.Report;
import personal.finances.solid.Exporters.ConsolePrinter;
import personal.finances.solid.Exporters.DataExporter;
import personal.finances.solid.readers.FileReader;
import personal.finances.solid.readers.DataReader;

/**
 *
 * @author GeraJuarez
 * @author JOSECARLOS
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
        
        // Currency with Peso
        //Currency currency = new Peso();
        // Currency with Yen
        Currency currency = new Yen();
        
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
