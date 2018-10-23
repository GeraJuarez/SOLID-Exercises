package personal.finances.solid;

/**
 *
 * @author Zegerd
 */
public interface Report {
	public String getDate();
	public String[] getPayees();
	public float[] getAmounts();
	public void addPayment(String s, float f);
	public float getMin();
	public float getMax();
	public float getAvg();
	public String getFrequentPayee();
        public String getReport();
}
