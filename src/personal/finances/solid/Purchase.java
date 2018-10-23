/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal.finances.solid;

/**
 *
 * @author JOSECARLOS
 */
public class Purchase {
    private String store;
    private float amount;
    
    public Purchase(String s, float a){
        this.store = s;
        this.amount = a;
    }
    
    public String getStore(){
        return this.store;
    }
    
    public float getAmout(){
        return this.amount;
    }
}
