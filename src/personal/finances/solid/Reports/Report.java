package personal.finances.solid.Reports;

import java.util.Map;

/**
 *
 * @author GeraJuarez
 * @author JOSECARLOS
 */
public interface Report {
    public String getReport();        
    public void feedInfo(Map<String, String> map);
}
