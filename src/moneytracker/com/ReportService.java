package moneytracker.com;
import java.util.Map;
import java.util.TreeMap;
import java.util.Date;

public class ReportService {

    Repository repo=Repository.getRepository();
    Double total;


    public  Map<String,Double> calculateMonthlyExpense() {
        Map<String,Double>  m =new TreeMap<>();
        for(Expense esp:repo.expenses){
            Date expDate= esp.getDate();
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



    public  Map<Integer,Double> calculateYearlyExpense() {
        Map<Integer,Double>  m =new TreeMap<>();
        for(Expense esp1:repo.expenses){
            Date expDate= esp1.getDate();
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

    public  Map<String,Double> calculateCategoryExpense() {
        Map<String,Double>  m =new TreeMap<>();
        for(Expense esp2:repo.expenses){
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

}