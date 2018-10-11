package personal.finances.solid;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Zegerd
 */
public class PersonalFinancesSOLID {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many purchases did you did today?");
        
        int todayPurchases = scanner.nextInt();
        String[] payees = new String[todayPurchases];
        float[] amounts = new float[todayPurchases];
        
        for (int i = 0; i < todayPurchases; i++) {
            payees[i] = scanner.next();
            amounts[i] = scanner.nextFloat();
        }
        
        Map<String, Integer> payeesCount = new HashMap<>();
        float min = Float.MAX_VALUE;
        float max = 0;
        float avg = 0;
        
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
        String frequentPayee = "";
        int maxPayeeFreq = 0;
        Date today = Calendar.getInstance().getTime();
        
        for (String key: payeesCount.keySet()) {
            int freq = payeesCount.get(key);
            if (maxPayeeFreq < freq) {
                maxPayeeFreq = freq;
                frequentPayee = key;
            }
        }
        
        System.out.println("Purchases of " + today);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Avg: " + avg);
        System.out.println("Frequent Payee: " + frequentPayee);
    }
    
}
