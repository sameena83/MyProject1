package moneytracker.com;

import java.util.Date;

public class Expense {
    private Long expenseId=System.currentTimeMillis();
    private Long expCategoryId;
    private Double amount;
    private Date date;
    private String description;


    public Expense(){

    }



    public Expense(Long expCategoryId,Double amount,Date date,String description){
        this.expCategoryId=expCategoryId;
        this.amount=amount;
        this.date=date;
        this.description=description;
    }

    public void setExpCategoryId(Long expCategoryId) {
        this.expCategoryId = expCategoryId;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getExpCategoryId() {
        return expCategoryId;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

}
