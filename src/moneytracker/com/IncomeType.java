package moneytracker.com;

public class IncomeType {
    Long incomeTypeId=System.currentTimeMillis();
    String incomeTypeName;


    public IncomeType(Long incomeTypeId,String incomeTypeName){
        this.incomeTypeId=incomeTypeId;
        this.incomeTypeName=incomeTypeName;
    }

    public IncomeType(){

    }
    public  IncomeType(String incomeTypeName){
        this.incomeTypeName=incomeTypeName;
    }


    public Long getIncomeTypeId() {
        return incomeTypeId;
    }

    public String getIncomeTypeName() {
        return incomeTypeName;
    }

    public void setIncomeTypeId(Long incomeTypeId) {
        this.incomeTypeId = incomeTypeId;
    }

    public void setIncomeTypeName(String incomeTypeName) {
        this.incomeTypeName = incomeTypeName;
    }
}
