package moneytracker.com;

import java.util.Date;

public class Income {
    private Long incomeId=System.currentTimeMillis();
    private Long incCategoryId;
    private Double amount;
    private Date date;
    private String description;

    public Income(){

    }



    public Income(Long incCategoryId,Double amount,Date date,String description){
        this.incCategoryId=incCategoryId;
        this.amount=amount;
        this.date=date;
        this.description=description;
    }

    public void setIncCategoryId(Long incCategoryId) {
        this.incCategoryId = incCategoryId;
    }
    public Long getIncCategoryId(Long incCategoryId) {
        return incCategoryId;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getExpCategoryId() {
        return incCategoryId;
    }

    public Long getIncomeId() {
        return incomeId;
    }
    public void setIncomeId(Long incomeId) {
        this.incomeId=incomeId;
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



}



