package personal.finances.solid.CurrencyFormats;

/**
 *
 * @author GeraJuarez
 */
public class Peso implements Currency {

    @Override
    public String getAmount(float amount) {
       return "$" + amount;
    }
}
