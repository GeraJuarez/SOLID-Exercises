package personal.finances.solid.readers;

import java.util.Scanner;

/**
 *
 * @author Zegerd
 */
public class ConsoleReader implements DataReader {
    private final Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }    
    
    @Override
    public int readIntData() {
        System.out.println("How many purchases did you did today?");
        return this.scanner.nextInt();
    }

    @Override
    public String readStringData() {
        return this.scanner.next();
    }

    @Override
    public float readFloatData() {
        return this.scanner.nextFloat();
    }
    
}
