package personal.finances.solid.Reports;

import DateFormats.DateFormat;
import personal.finances.solid.CurrencyFormats.Currency;
import personal.finances.solid.Operator;

/**
 *
 * @author GeraJuarez
 * @author JOSECARLOS
 */
public class DailyReport implements Report {
    private Operator operator;
    @Override
    public String getReport(Currency cu, DateFormat df) {
        StringBuilder result = new StringBuilder();
        
        result.append("Purchases of ");
        result.append(df.formatDate(operator.getToday()));
        result.append("\n");
        
        result.append("Min: ");
        result.append(cu.getAmount(operator.getMin()));
        result.append("\n");
        
        result.append("Max: ");
        result.append(cu.getAmount(operator.getMax()));
        result.append("\n");
        
        result.append("Avg: ");
        result.append(cu.getAmount(operator.getAvg()));
        result.append("\n");
        
        result.append("Frequent Payee: ");
        result.append(operator.getFrequent());
        result.append("\n");
        
        return result.toString();
    }

    @Override
    public void setOperator(Operator op) {
        this.operator = op;
    }
}
