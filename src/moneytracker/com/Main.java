package moneytracker.com;

import java.io.IOException;
/**
 *
 * <h1> MoneyTracker !</h1>
 * The MoneyTracker program implements an application that
 * helps user to keep track of the expenses and Incomes and it is operated through commandline .
 *
 * @author  Haleemath Sameena
 * @version 1.0
 * @since   2020-10-04
 */

public class Main {
    /**
     * This is the main method
     * @param args Unused.
     * @return Nothing.
     * @exception IOException On input error.
     * @see IOException
     */

    public static void main(String[] args) throws IOException {

        TrackManage  service=new TrackManage();
        service.showMenu();

    }
}
