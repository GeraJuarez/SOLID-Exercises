/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal.finances.solid;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JOSECARLOS
 */
public class Operator {
    public float getMin(float[] array){
        float min = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
    
    public float getMax(float[] array){
        float max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
    
    public float getAvg (float[] array){
        float count = 0;
        for(int i = 0; i < array.length; i++){
            count += array[i];
        }
        return count/array.length;
    }
    
    public String getCommonString(String[] array){
        Map<String, Integer> arrayCount = new HashMap<>();
        int max = 0;
        String maxString = array[0];
        for(int i = 0; i < array.length; i++){
            int appearances = arrayCount.getOrDefault(array[i], 0);
            if(appearances > 0){
                arrayCount.put(array[i], appearances + 1);
                if(appearances + 1 > max){
                    max = appearances + 1;
                    maxString = array[i];
                }
            }else{
                arrayCount.put(array[i], 1);
                if(max == 0){
                    max = 1;
                    maxString = array[i];
                }
            }
        }
        return maxString;
    }
}
