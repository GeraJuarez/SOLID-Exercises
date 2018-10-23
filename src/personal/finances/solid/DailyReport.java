package personal.finances.solid;

import java.util.Calendar;

public class DailyReport implements Report {
    String[] payees;
    float[] amounts;
    String date;
    
    public DailyReport(String[] s, float[] a){
      this.payees = s;
      this.amounts = a;
      this.date = Calendar.getInstance().getTime().toString();
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

    @Override
    public String getReport() {
        String result = "";
        Operator op = new Operator();
        result += "Purchases of " + date + "\n";
        result += "Min: " + op.getMin(this.getAmounts()) + "\n";
        result += "Max: " + op.getMax(this.getAmounts()) + "\n";
        result += "Avg: " + op.getAvg(this.getAmounts()) + "\n";
        result += "Frequent Payee: " + op.getCommonString(this.getPayees()) + "\n";
        System.out.println("TEST - > " + result);
        return result;
    }
}
