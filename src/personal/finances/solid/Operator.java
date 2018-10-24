package personal.finances.solid;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GeraJuarez
 * @author JOSECARLOS
 */
public class Operator {
    private Purchase[] purchases;

    public Operator(Purchase[] pu) {
        purchases = pu;
    }        
    
    public Date getToday(){
        return Calendar.getInstance().getTime();
    }
    
    public float getMin(){
        float min = purchases[0].getAmout();
        for(int i = 1; i < purchases.length; i++){
            if(purchases[i].getAmout() < min){
                min = purchases[i].getAmout();
            }
        }
        return min;
    }
    
    public float getMax(){
        float max = purchases[0].getAmout();
        for(int i = 1; i < purchases.length; i++){
            if(purchases[i].getAmout() > max){
                max = purchases[i].getAmout();
            }
        }
        return max;
    }
    
    public float getAvg (){
        float count = 0;
        for(int i = 0; i < purchases.length; i++){
            count += purchases[i].getAmout();
        }
        return count / purchases.length;
    }
    
    public String getFrequent(){
        Map<String, Integer> arrayCount = new HashMap<>();
        int max = 0;
        String maxString = purchases[0].getPayee();
        
        for (int i = 0; i < purchases.length; i++){
            int appearances = arrayCount.getOrDefault(purchases[i].getPayee(), 0);
            if (appearances > 0){
                arrayCount.put(purchases[i].getPayee(), appearances + 1);
                if(appearances + 1 > max){
                    max = appearances + 1;
                    maxString = purchases[i].getPayee();
                }
            } else {
                arrayCount.put(purchases[i].getPayee(), 1);
                if (max == 0){
                    max = 1;
                    maxString = purchases[i].getPayee();
                }
            }
        }
        return maxString;
    }
}
