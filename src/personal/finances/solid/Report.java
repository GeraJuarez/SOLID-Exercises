package personal.finances.solid;

/**
 *
 * @author Zegerd
 */
public interface Report {
	public String getDate();
	public String[] getPayees();
	public float[] getAmounts();

        public String getReport();
}
