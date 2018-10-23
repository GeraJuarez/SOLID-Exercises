package personal.finances.solid.Exporters;

/**
 *
 * @author GeraJuarez
 */
public class ConsolePrinter implements DataExporter {
    
    @Override
    public void exportData(String data){
    	System.out.println(data);
    }
}
