package personal.finances.solid;

/**
 *
 * @author Zegerd
 */
public class ConsoleReportPrinter implements DataExporter {
    public int exportData(String data){
    	System.out.println(data);
    }
}
