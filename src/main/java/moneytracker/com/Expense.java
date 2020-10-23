package moneytracker.com;

import java.io.Serializable;
import java.util.Date;

public class Expense implements Serializable {

    private String expenseType;
    private Double amount;
    private Date date;

    public Expense(){

    }

    public Expense(Double amount){
        this.amount=amount;

    }



    public Expense(String expenseType){
        this.expenseType=expenseType;

    }


    public Expense(String expenseType,Double amount){
        this.expenseType=expenseType;
        this.amount=amount;

    }






    public Expense(String  expenseType,Double amount,Date date){
        this.expenseType=expenseType;
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


    public String getExpenseType() {
        return expenseType;
    }
    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }






}
