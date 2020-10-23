package moneytracker.com;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
/**
 * This class is the Income class of Finance Tracker
 *
 */

public class Income implements Serializable {

    private String incomeType;
    private Double amount;
    private LocalDate date;


    public Income(){

    }

    /**
     *
     * @param incomeType
     * @param amount
     * @param date
     */

    public Income(String incomeType,Double amount,LocalDate date){
        this.incomeType=incomeType;
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

    public Double getAmount() {
        return amount;
    }

    /**
     *
     *
     * @param amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     *
     * @return income type
     */

    public String  getIncomeType() {
        return incomeType;
    }

    /**
     *
     * @param incomeType
     */

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }










}



