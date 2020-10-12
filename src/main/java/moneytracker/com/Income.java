package moneytracker.com;

import java.util.Date;

public class Income {

    private String incomeType;
    private Double amount;
    private Date date;


    public Income(){

    }



    public Income(String incomeType,Double amount,Date date){
        this.incomeType=incomeType;
        this.amount=amount;
        this.date=date;

    }



    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String  getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }










}



