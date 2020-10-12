package moneytracker.com;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtility {
    //public static final String[] MONTHS={"January","february","March","april","may","june","july","august","september","october","november","december"};
    public  static Date stringToDate(String dateAsString){
        try{

            SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
            return df.parse(dateAsString);
        }catch(ParseException e){
            e.printStackTrace();
            return null;

        }

    }

    public  static String dateToString(Date date){


        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);


    }

    public static String getYearAndMonth(Date date){
        SimpleDateFormat df=new SimpleDateFormat("yyyy, MMM");
        return df.format(date);

    }
    //public static String getMonthName(Integer monthNo){
    // return MONTHS[monthNo-1];
    //}

    public static Integer getYear(Date date){
        SimpleDateFormat df=new SimpleDateFormat("yyyy");
        return Integer.valueOf(df.format(date));

    }


}

