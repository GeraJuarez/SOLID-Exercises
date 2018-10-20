package personal.finances.solid;

/**
 *
 * @author Zegerd
 */
public class Peso extends Currency {

    public Peso() {
        super();
    }
    
    @Override
    public String getAmount() {
       return "$" + this.amount;
    }
}
