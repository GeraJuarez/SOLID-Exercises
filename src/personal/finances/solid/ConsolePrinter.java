package personal.finances.solid;

public class ConsolePrinter implements DataExporter {
    
    @Override
    public void exportData(String data){
    	System.out.println(data);
    }
}
