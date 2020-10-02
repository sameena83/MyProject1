package moneytracker.com;

public class ExpenseCategory {
    //automatically generate id,temporarytotrack
    Long expCategoryId=System.currentTimeMillis();
    String expCategoryName;

    public ExpenseCategory(Long expCategoryId,String name){
        this.expCategoryId=expCategoryId;
        this.expCategoryName=name;
    }

    public ExpenseCategory(){

    }
    public  ExpenseCategory(String name){
        this.expCategoryName=name;
    }


    public Long getExpCategoryId() {
        return expCategoryId;
    }

    public String getExpCategoryName() {
        return expCategoryName;
    }

    public void setExpCategoryId(Long expCategoryId) {
        this.expCategoryId = expCategoryId;
    }

    public void setExpCategoryName(String expCategoryName) {
        this.expCategoryName = expCategoryName;
    }
}
