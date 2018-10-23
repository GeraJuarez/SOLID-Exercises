package personal.finances.solid;

public class DailyReport implements Report {
    private String date;
    private String[] payees;
    private float[] amounts;
    private int capacity;

    private float min;
    private float max;
    private float sum;
    private String commonPayee;

    public DailyReport() {
    }        
        
    public DailyReport(String date, int size){
        this.date = date;
        this.payees = new String[size];
        this.amounts = new float[size];
        this.capacity = size;

        this.min = Float.MAX_VALUE;
        this.max = 0;
        this.sum = 0;
        this.commonPayee = null;
    }

    @Override
    public String getDate(){
        return this.date;
    }
    @Override
    public String[] getPayees(){
        return this.payees;
    }
    @Override
    public float[] getAmounts(){
        return this.amounts;
    }

    public void addPayment(String payee, float amount){
        if (capacity > 0) {
            this.payees[this.payees.length - capacity] = payee;
            this.amounts[this.amounts.length - capacity] = amount;
            if (amount < this.min){
                this.min = amount;
            }
            if (amount > this.max){
                this.max = amount;
            }
            this.sum += amount;

            // TODO: CALCULATE THE COMMON
            capacity -= 1;
        }
    }	

    @Override
    public float getMin(){
        return this.min;
    }
    @Override
    public float getMax(){
        return this.max;
    }
    @Override
    public float getAvg(){
        return this.sum / this.amounts.length;
    }
    @Override
    public String getFrequentPayee(){
        return this.commonPayee;
    }

    @Override
    public String getReport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
