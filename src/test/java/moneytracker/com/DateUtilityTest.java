package moneytracker.com;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

import org.junit.jupiter.api.Test;

class DateUtilityTest {



    private Object assertTrue;





    @Test
    public void getYearAndMonth() {
        DateUtility d = new DateUtility();
        assertTrue(DateTimeFormatter.ofPattern("yyyy, MMM"));
        


    }

    private void assertTrue(DateTimeFormatter ofPattern) {
    }

    @Test
    public void getYear() {
        DateUtility d = new DateUtility();
        assertTrue(DateTimeFormatter.ofPattern("yyyy"));

    }



    }




