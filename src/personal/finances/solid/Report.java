package personal.finances.solid;

import java.util.Map;

/**
 *
 * @author Zegerd
 */
public interface Report {
        public String getReport();        
        public void feedInfo(Map<String, String> map);
}
