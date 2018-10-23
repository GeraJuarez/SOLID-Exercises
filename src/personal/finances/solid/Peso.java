package personal.finances.solid;

/**
 *
 * @author Zegerd
 */
public class Peso implements Currency {

    @Override
    public String getAmount(float amount) {
       return "$" + amount;
    }
}
