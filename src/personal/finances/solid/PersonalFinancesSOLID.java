package personal.finances.solid;

/**
 *
 * @author Zegerd
 */
public class PersonalFinancesSOLID {
    public static void main(String[] args) {
       
        // Use console
        DataReader dr = new ConsoleReader();
        
        // Use file
        // DataReader dr = new ...
        
        // Use Pesos
        Currency currency = new Peso();
        
        PersonalFinances pf = new PersonalFinances();
        pf.readData(dr);
        pf.calculateInformation();
        pf.printData(currency);
    }
    
}
