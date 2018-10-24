package personal.finances.solid;

import DateFormats.DateFormat;
import personal.finances.solid.CurrencyFormats.Currency;
import personal.finances.solid.Reports.Report;
import personal.finances.solid.Exporters.DataExporter;
import personal.finances.solid.readers.DataReader;

/**
 *
 * @author GeraJuarez
 * @author JOSECARLOS
 */
public class PersonalFinances {
    private final Report report;
    private final DataReader dr;
    private final DataExporter de;
    private final Currency currency;
    private final DateFormat dateformat;
    
    private Purchase[] purchases;
    
    public PersonalFinances(DataReader dr, DataExporter de, Report r, Currency c, DateFormat df){
        this.dr = dr;
        this.de = de;         
        this.report = r;
        this.currency = c;
        this.dateformat = df;
    }
    
    public void start() {
        System.out.println("reading...");
        this.readData();
        
        System.out.println("calculating...");
        this.calculateInformation();
        
        System.out.println("exporting...");
        this.printData();
        
        System.out.println("Done");
    }
    
    private void readData() {       
        int todayPurchases = dr.readIntData();
        this.purchases = new Purchase[todayPurchases];         
        
        for (int i = 0; i < todayPurchases; i++) {
            String newPayee = dr.readStringData();
            float newAmount = dr.readFloatData();
            purchases[i] = new Purchase(newPayee, newAmount);            
        }        
    }
    
    private void calculateInformation() {
        Operator op = new Operator(purchases);
        this.report.setOperator(op);
    }
    
    private void printData() {
        de.exportData(this.report.getReport(this.currency, this.dateformat));           
    }
    
}
