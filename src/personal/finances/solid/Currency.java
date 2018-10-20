package personal.finances.solid;

/**
 *
 * @author Zegerd
 */
public abstract class Currency {
    float amount;

    public Currency() {
        this(0);
    }        
    
    public Currency(float amount) {
        this.amount = amount;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    public String getAmount() {
        return "" + this.amount;
    }
}
