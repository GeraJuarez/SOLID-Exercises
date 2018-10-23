package personal.finances.solid;

import personal.finances.solid.readers.DataReader;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zegerd
 */
public class PersonalFinances {
    private Report report;
    private DataReader dr;
    private DataExporter de;
    private Currency currency;
    
    private int todayPurchases;
    private String[] payees;
    private float[] amounts;
    
    public PersonalFinances(DataReader dr, DataExporter de, Currency c){
        this.dr = dr;
        this.de = de;
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
        this.todayPurchases = dr.readIntData();
        
        this.payees = new String[todayPurchases];
        this.amounts = new float[todayPurchases];
        
        for (int i = 0; i < this.todayPurchases; i++) {
            this.payees[i] = dr.readStringData();
            this.amounts[i] = dr.readFloatData();
        }
        this.report = new DailyReport(this.payees, this.amounts);
    }
    
    private void calculateInformation() {
        //Operator operator = new Operator();
        
    }
    
    private void printData() {
        de.exportData(this.report.getReport());           
    }
    
}
