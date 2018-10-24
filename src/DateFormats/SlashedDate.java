
package DateFormats;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author GeraJuarez
 */
public class SlashedDate implements DateFormat {

    @Override
    public String formatDate(Date d) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        return format.format(d);
    }
    
}
