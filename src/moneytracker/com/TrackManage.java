package moneytracker.com;
import java.io.IOException;
import java.util.Scanner;

public class TrackManage {
    private Scanner in=new Scanner(System.in);
    //global
    private int  choice;

    public void showMenu(){
        while(true){
            printMenu();
            switch (choice){

                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Adding category of expense");
                    continueOperation();

            }


        }
    }
    public void printMenu() {

        System.out.println("::::::::::::::::::::::::::::Welcome To My MoneyTracker App::::::::::::::::");
        System.out.println(":::::::::::::::::::::::::OptionList::::::::::::::::::::::::::::::::");
        System.out.println("Select the options");
        System.out.println("Press 1 to  Adding Category Of  Expense");
        System.out.println("Press 2 to  Category List of Expense");
        System.out.println("Press 3 to  Enter  Expense");
        System.out.println("Press 4 to get monthly  Expense list");
        System.out.println("Press 5 to get categorized Expense list");
        System.out.println("Press 6 to enter typeof income");
        System.out.println("Press 7 to enter income amount ");

        System.out.println("Press 0 to exit");
        System.out.println("ENTER  your  choice");
        choice = in.nextInt();
    }
    public void continueOperation(){
        try{
        System.out.println("Press any key to continue or 0  to quit");
        System.in.read();
        }
        catch (IOException e){
            e.printStackTrace();


        }
    }

}




