package personal.finances.solid;

import personal.finances.solid.CurrencyFormats.Currency;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GeraJuarez
 * @author JOSECARLOS
 */
public class Operator {
    
    public Map<String, String> calculatedInfo;

    public Operator() {
        calculatedInfo = new HashMap<>();
    }        
    
    public Map<String, String> calculateData(Purchase[] purchases, Currency currencyFormat) {
        Date today = Calendar.getInstance().getTime();
        
        float min = this.getMin(purchases);
        float max = this.getMax(purchases);
        float avg = this.getAvg(purchases);
        String frequent = this.getCommonString(purchases);
        
        calculatedInfo.put("today", today.toString());
        calculatedInfo.put("min", "" + currencyFormat.getAmount(min));
        calculatedInfo.put("max", "" + currencyFormat.getAmount(max));
        calculatedInfo.put("avg", "" + currencyFormat.getAmount(avg));
        calculatedInfo.put("frequent", frequent);
        
        return Collections.unmodifiableMap(calculatedInfo);
    }
    
    private float getMin(Purchase[] array){
        float min = array[0].getAmout();
        for(int i = 1; i < array.length; i++){
            if(array[i].getAmout() < min){
                min = array[i].getAmout();
            }
        }
        return min;
    }
    
    private float getMax(Purchase[] array){
        float max = array[0].getAmout();
        for(int i = 1; i < array.length; i++){
            if(array[i].getAmout() > max){
                max = array[i].getAmout();
            }
        }
        return max;
    }
    
    private float getAvg (Purchase[] array){
        float count = 0;
        for(int i = 0; i < array.length; i++){
            count += array[i].getAmout();
        }
        return count / array.length;
    }
    
    private String getCommonString(Purchase[] array){
        Map<String, Integer> arrayCount = new HashMap<>();
        int max = 0;
        String maxString = array[0].getPayee();
        
        for (int i = 0; i < array.length; i++){
            int appearances = arrayCount.getOrDefault(array[i].getPayee(), 0);
            if (appearances > 0){
                arrayCount.put(array[i].getPayee(), appearances + 1);
                if(appearances + 1 > max){
                    max = appearances + 1;
                    maxString = array[i].getPayee();
                }
            } else {
                arrayCount.put(array[i].getPayee(), 1);
                if (max == 0){
                    max = 1;
                    maxString = array[i].getPayee();
                }
            }
        }
        return maxString;
    }
}
