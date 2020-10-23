package moneytracker.com;
//import static org.junit.Assert.*;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {





    @Test
    public void setAmount() {
        Expense exp=new Expense();
        exp.setAmount(2.00);

        assertEquals(2.00, exp.getAmount());

    }

    @Test
    public void getAmount() throws NoSuchFieldException, IllegalAccessException {
        Expense exp = new Expense();
        exp.setAmount(2.00);
        assertEquals(2.00, exp.getAmount());

    }

    @Test
    public void setExpenseType() {
        Expense exp=new Expense();
        exp.setExpenseType("toy");
        assertEquals("toy", exp.getExpenseType());


    }


    @Test
    public void getExpenseType() {
        Expense exp = new Expense();
        exp.setExpenseType("toy");
        String s="toy";
        assertEquals(s, exp.getExpenseType());


    }


}