package moneytracker.com;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
/**
 * This class do all date related operations
 * @author Haleemath Sameena
 *  * @version 1.0
 *  * @since   2020-10-23
 */


public class DateUtility
{

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //public static final String[] MONTHS={"January","february","March","april","may","june","july","august","september","october","november","december"};
    public  static LocalDate stringToDate(String dateAsString){
        try{


            return LocalDate.parse(dateAsString, formatter);
        }
        catch(DateTimeParseException e){
            e.printStackTrace();
            return null;

        }

    }

    /**
     *
     * @param date
     * @return formatted date
     */

    public  static String dateToString(LocalDate date)
    {
        return formatter.format(date);
    }

    /**
     *
     * @param date
     * @return year and month
     */

    public static String getYearAndMonth(LocalDate date){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy, MMM");
        return df.format(date);

    }
    //public static String getMonthName(Integer monthNo){
    // return MONTHS[monthNo-1];
    //}

    /**
     *
     * @param date
     * @return year
     */

    public static Integer getYear(LocalDate date){
        DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy");
        return Integer.valueOf(df.format(date));

    }


}

