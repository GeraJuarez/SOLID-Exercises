package personal.finances.solid.CurrencyFormats;

/**
 *
 * @author GeraJuarez
 */
public class Yen implements Currency {

    @Override
    public String getAmount(float amount) {
        return "¥" + amount;
    }
    
}
