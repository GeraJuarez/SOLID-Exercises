package personal.finances.solid;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Zegerd
 */
public class PersonalFinancesSOLID {
    public static void main(String[] args) {
       
        PersonalFinances pf = new PersonalFinances();
        pf.readData();
        pf.calculateInformation();
        pf.printData();
    }
    
}
