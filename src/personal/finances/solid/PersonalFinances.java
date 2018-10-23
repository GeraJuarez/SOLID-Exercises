package personal.finances.solid;

import personal.finances.solid.readers.DataReader;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Zegerd
 */
public class PersonalFinances {
    private Report report;
    private DataReader dr;
    private DataExporter de;
    private Currency currency;    
    private Operator operator;
    
    private Purchase[] purchases;
    
    public PersonalFinances(DataReader dr, DataExporter de, Report r, Operator op, Currency c){
        this.dr = dr;
        this.de = de;         
        this.report = r;
        this.operator = op;
        this.currency = c;
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
        Date today = Calendar.getInstance().getTime();
        this.report.feedInfo(this.operator.calculateData(purchases));
        
        // send purchase Obj and the formater to calculator and return a dict
        // send dict to reporter
        
    }
    
    private void printData() {
        // reporter only prinst specified things of the dict
        de.exportData(this.report.getReport());           
    }
    
}
