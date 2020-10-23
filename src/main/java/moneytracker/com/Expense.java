package moneytracker.com;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * This class is the expense class of Finance Tracker
 *
 */

public class Expense implements Serializable {

    private String expenseType;
    private double amount;
    private LocalDate date;



    public Expense(){

    }

    /**
     *
     * @param amount
     */

    public Expense(double amount){
        this.amount=amount;

    }

    /**
     *
     * @param expenseType
     */

    public Expense(String expenseType){
        this.expenseType=expenseType;

    }

    /**
     *
     * @param expenseType
     * @param amount
     */


    public Expense(String expenseType,double amount){
        this.expenseType=expenseType;
        this.amount=amount;

    }


    /**
     *
     * @param expenseType
     * @param amount
     * @param date
     */
    public Expense(String  expenseType,double amount,LocalDate date){
        this.expenseType=expenseType;
        this.amount=amount;
        this.date=date;

    }

    /**
     *
     * @return date
     */


    public LocalDate getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *
     * @return amount
     */

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     *
     * @return expensetype
     */

    public String getExpenseType() {
        return expenseType;
    }

    /**
     *
     * @param expenseType
     */
    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }






}
