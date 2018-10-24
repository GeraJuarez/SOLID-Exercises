package personal.finances.solid.Reports;

import DateFormats.DateFormat;
import personal.finances.solid.CurrencyFormats.Currency;
import personal.finances.solid.Operator;

/**
 *
 * @author GeraJuarez
 * @author JOSECARLOS
 */
public interface Report {
    public String getReport(Currency cu, DateFormat df);
    public void setOperator(Operator op);
}
