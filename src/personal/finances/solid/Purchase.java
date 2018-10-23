package personal.finances.solid;

/**
 *
 * @author JOSECARLOS
 */
public class Purchase {
    private final String payee;
    private final float amount;
    
    public Purchase(String s, float a){
        this.payee = s;
        this.amount = a;
    }
    
    public String getPayee(){
        return this.payee;
    }
    
    public float getAmout(){
        return this.amount;
    }
}
