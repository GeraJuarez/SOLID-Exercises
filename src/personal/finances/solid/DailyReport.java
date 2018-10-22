package personal.finances.solid;

/**
 *
 * @author Zegerd
 */
public class DailyReport implements Report {
	private String date;
	private String[] payees;
	private float[] amounts;
	private int capacity;

	private float min;
	private float max;
	private float sum;
	private String commonPayee;

	public Report(String date, int size){
		this.date = date;
		this.payees = new String[size];
		this.amounts = new float[size];
		this.capacity = size;

		this.min = null;
		this.max = null;
		this.sum = 0;
		this.commonPayee = null;
	}

	public Date getDate(){
		return this.date;
	}
	public String[] getPayees(){
		return this.payees;
	}
	public float[] getAmounts(){
		return this.amounts;
	}

	public void addPayment(String payee, float amount){
		if(capacity>0){
			this.payees[this.payees.lenght - capacity] = payee;
			this.amount[this.amount.lenght - capacity] = amount;
			if(this.min == null || amount < this.min){
				this.min = amount;
			}
			if(this.max == null || amount > this.max){
				this.max = amount;
			}
			this.sum += amount;
			//TODO CALCULATE THE COMMON
			capacity -= 1;
		}
	}	

	public float getMin(){
		return this.min;
	}
	public float getMax(){
		return this.max;
	}
	public float getAvg(){
		return this.sum/this.amounts.lenght;
	}
	public String getFrequentPayee(){
		return this.commonPayee;
	}
}
