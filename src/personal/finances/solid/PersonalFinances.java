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
    
    private int todayPurchases;
    private String[] payees;
    private float[] amounts;
    
    Map<String, Integer> payeesCount;
    float min;
    float max;
    float avg;
    
    String frequentPayee;
    Date today;
    
    public PersonalFinances(){
        //this.report = report;
        
        this.todayPurchases = 0;
        
        payeesCount = new HashMap<>();
        min = Float.MAX_VALUE;
        max = 0;
        avg = 0;
        
        frequentPayee = "";
        today = Calendar.getInstance().getTime();
    }
    
    public void readData(DataReader dr) {
        todayPurchases = dr.readIntData();
        
        payees = new String[todayPurchases];
        amounts = new float[todayPurchases];
        
        for (int i = 0; i < todayPurchases; i++) {
            payees[i] = dr.readStringData();
            amounts[i] = dr.readFloatData();
        }
    }
    
    public void calculateInformation() {
       
        for (int i = 0; i < todayPurchases; i++){
            if (min > amounts[i]){
                min = amounts[i];
            }
            if (max < amounts[i]){
                 max = amounts[i];
            }
            avg += amounts[i];
            payeesCount.put(payees[i], payeesCount.getOrDefault(payees[i], 0) + 1);
        }

        avg /= todayPurchases;
        
        int maxPayeeFreq = 0;
        for (String key: payeesCount.keySet()) {
            int freq = payeesCount.get(key);
            if (maxPayeeFreq < freq) {
                maxPayeeFreq = freq;
                frequentPayee = key;
            }
        }
    }
    
    public void printData(Currency c, DataExporter de) {
        
        de.exportData("Purchases of " + today);
        de.exportData("Min: " + c.getAmount(min));
        de.exportData("Max: " + c.getAmount(max));
        de.exportData("Avg: " + c.getAmount(avg));
        de.exportData("Frequent Payee: " + frequentPayee);            
    }
    
}
