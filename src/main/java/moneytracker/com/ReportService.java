package moneytracker.com;
import java.time.LocalDate;
import java.util.*;
import java.io.Serializable;
public class ReportService
/**
 * @author Haleemath Sameena
 * @version 1.0
 * @since   2020-10-23
 */
{
    /**
     * @param expenses array
     * @param incomes array
     *
     */
    private Double total;
    private ArrayList<Expense> expenses;
    private  ArrayList<Income>incomes;
    //public List<Savings>income=new ArrayList<>();

    public ReportService(Object in, Object ex)
    {
        if (in == null)
            incomes = new ArrayList<>();
        else
            incomes = (ArrayList<Income>) in;

        if (ex == null)
            expenses = new ArrayList<>();
        else
            expenses = (ArrayList<Expense>) ex;

    }

    public void save()
    {
        /*FileHandler fh = new FileHandler();
        fh.save(incmoes, "incomes");
        fh.save(expences, "expences");

         */
    }

  /**
   * @return monthly expense list
   */

    public  Map<String,Double> calculateMonthlyExpense() {
        Map<String,Double>  m =new TreeMap<>();

        for(Expense esp:expenses){
            LocalDate expDate= esp.getDate();
            String yearMonth=DateUtility.getYearAndMonth(expDate);
            if(m.containsKey(yearMonth)){
                total =m.get(yearMonth);
                total=total+ esp.getAmount();
                m.put(yearMonth,total);//new total amount replaces old one
            }else{
                m.put(yearMonth,esp.getAmount());


            }

        }
        return m;
    }

    /**
     *
     * @return yearly expense list
     */

    public  Map<Integer,Double> calculateYearlyExpense()
    {
        Map<Integer,Double>  m =new TreeMap<>();
        for(Expense esp1:expenses){
            LocalDate expDate= esp1.getDate();
            Integer year=DateUtility.getYear(expDate);
            if(m.containsKey(year)){
                total =m.get(year);
                total=total+ esp1.getAmount();
                m.put(year,total);//new total amount replaces old one
            }else{
                m.put(year,esp1.getAmount());


            }

        }
        return m;
    }
    /**
     *
     * @return yearly income list
     */

    public  Map<Integer,Double> calculateYearlyIncome() {
        Map<Integer,Double>  m =new TreeMap<>();
        for(Income inc1:incomes){
            LocalDate expDate= inc1.getDate();
            Integer year=DateUtility.getYear(expDate);
            if(m.containsKey(year)){
                total =m.get(year);
                total=total+ inc1.getAmount();
                System.out.println("The Year OF Expense and the Total Expense are:");
                m.put(year,total);//new total amount replaces old one
            }else{
                System.out.println("The Year OF Expense and the Total Expense are:");
                m.put(year,inc1.getAmount());


            }

        }
        return m;
    }
    /**
     *
     * @return category  expense list
     */

    public  Map<String,Double> calculateCategoryExpense() {
        Map<String,Double>  m =new TreeMap<>();
        for(Expense esp2:expenses){
            String category=esp2.getExpenseType();


            if(m.containsKey(category)){
                total =m.get(category);
                total=total+ esp2.getAmount();
                m.put(category,total);//new total amount replaces old one
            }else{
                m.put(category,esp2.getAmount());


            }

        }
        return m;
    }
    /**
     *
     * @return monthly income list
     */

    public  Map<String,Double> calculateMonthlyIncome() {
        Map<String,Double>  m =new TreeMap<>();
        for(Income Inc:incomes){
            LocalDate incDate= Inc.getDate();
            String yearMonth=DateUtility.getYearAndMonth(incDate);
            if(m.containsKey(yearMonth)){
                total =m.get(yearMonth);
                total=total+ Inc.getAmount();
                m.put(yearMonth,total);//new total amount replaces old one
            }else{
                m.put(yearMonth,Inc.getAmount());


            }

        }
        return m;
    }

    /**
     *
     * @return category income list
     */

    public  Map<String,Double> calculateCategoryIncome() {
        Map<String,Double>  m =new TreeMap<>();
        for(Income esp2:incomes){
            String category=esp2.getIncomeType();


            if(m.containsKey(category)){
                total =m.get(category);
                total=total+ esp2.getAmount();
                m.put(category,total);//new total amount replaces old one
            }else{
                m.put(category,esp2.getAmount());


            }

        }
        return m;
    }

    public ArrayList<Expense> getExpenses()
    {
        return expenses;
    }
    public ArrayList<Income> getIncomes()
    {
        return incomes;
    }
}

