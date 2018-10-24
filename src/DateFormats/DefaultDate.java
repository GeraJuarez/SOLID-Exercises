package DateFormats;


import java.util.Date;

/**
 *
 * @author GeraJuarez
 */
public class DefaultDate implements DateFormat {

    @Override
    public String formatDate(Date d) {
        return d.toString();
    }
}
