package personal.finances.solid;

import java.util.Calendar;
import java.util.Map;

public class DailyReport implements Report {
    private Map<String, String> data;

    public DailyReport() {
    }
    
    @Override
    public void feedInfo(Map<String, String> newData) {
        data = newData;
    }

    @Override
    public String getReport() {
        StringBuilder result = new StringBuilder();
        
        result.append("Purchases of ");
        result.append(data.get("today"));
        result.append("\n");
        
        result.append("Min: ");
        result.append(data.get("min"));
        result.append("\n");
        
        result.append("Max: ");
        result.append(data.get("max"));
        result.append("\n");
        
        result.append("Avg: ");
        result.append(data.get("avg"));
        result.append("\n");
        
        result.append("Frequent Payee: ");
        result.append(data.get("frequent"));
        result.append("\n");
        
        return result.toString();
    }
}
