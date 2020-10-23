package moneytracker.com;

import java.io.IOException;
/**
 * The MyFinanceTrack program implements an application that
 * simply do  Finance tracking and query can be done through console.
 * This is the main class of the application
 *
 * @author  Haleemath Sameena
 * @version 1.0
 * @since   2020-10-23
 */


public class Main {

    public static void main(String[] args) throws IOException {

        TrackManage  service=new TrackManage();
        service.showMenu();
	// write your code here
    }
}
