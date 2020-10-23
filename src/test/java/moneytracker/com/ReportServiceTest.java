package moneytracker.com;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReportServiceTest {


    private Object Income;
    private Object Expense;


    @Test
    public void getExpenses(){
        ReportService rep= new ReportService(Income,Expense);
        rep.getExpenses();
    }
    @Test
    public void getIncomes(){
        ReportService rep= new ReportService(Income,Expense);
        rep.getIncomes();
    }

    @Test
    void calculateMonthlyExpense() {
        ReportService rep= new ReportService(Income,Expense);



    }

    @Test
    void calculateYearlyExpense() {
    }

    @Test
    void calculateYearlyIncome() {
    }

    @Test
    void calculateCategoryExpense() {
    }

    @Test
    void calculateMonthlyIncome() {
    }

    @Test
    void calculateCategoryIncome() {
    }
}