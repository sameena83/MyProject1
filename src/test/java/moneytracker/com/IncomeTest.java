package moneytracker.com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncomeTest {


    @Test
    public void setAmount() {
        Income in=new Income();
        in.setAmount(2.00);

        assertEquals(2.00, in.getAmount());

    }
    @Test
    public void getAmount() throws NoSuchFieldException, IllegalAccessException {
        Income inc = new Income();
        inc.setAmount(2.00);
        assertEquals(2.00, inc.getAmount());

    }

    @Test
    public void setIncomeType() {
        Income inc = new Income();

        inc.setIncomeType("toy");
        assertEquals("toy", inc.getIncomeType());


    }

    @Test
    public void getIncomeType() {
        Income inc = new Income();

        inc.setIncomeType("toy");
        String s="toy";
        assertEquals(s, inc.getIncomeType());


    }






    @Test
    void getDate() {
    }

    @Test
    void setDate() {
    }








}