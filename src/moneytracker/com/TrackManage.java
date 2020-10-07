package moneytracker.com;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TrackManage {

    private final Scanner in=new Scanner(System.in);
    //storeData object provided by static method,how many times you call this method,you get only one storeData
    //object,since StoreData is a singleton object here
    Repository repo=Repository.getRepository();

    //global
    private int  choice;
    int i;
    //when we call the show menu method a finite loop will go and it prints the menu
    public void showMenu() throws IOException {
        while(true){
            printMenu();
            switch (choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    onAddNewExpense();
                    pressAnyKeyToContinue();
                    break;




                case 2:
                    onViewExpenseList();
                    pressAnyKeyToContinue();
                    break;


                case 3:
                    onViewExpenseListByCategory();
                    pressAnyKeyToContinue();
                    break;

                case 4:
                    onViewExpenseListByDate();
                    pressAnyKeyToContinue();
                    break;



                case 5:
                    onViewMonthlyExpenseList();
                    pressAnyKeyToContinue();
                    break;

                case 6:
                    onViewYearlyExpenseList();
                    pressAnyKeyToContinue();
                    break;

                case 7:
                    onAddNewIncome();
                    pressAnyKeyToContinue();
                    break;
                case 8:
                    onViewIncomeList();
                    pressAnyKeyToContinue();
                    break;

                case 9:
                    onViewIncomeListByCategory();
                    pressAnyKeyToContinue();
                    break;


                case 10:

                    onViewIncomeListByDate();
                    pressAnyKeyToContinue();
                    break;




                case 11:

                    onViewMonthlyIncomeList();
                    pressAnyKeyToContinue();
                    break;



                case 12:

                    onViewYearlyIncomeList();
                    pressAnyKeyToContinue();
                    break;


        }
    }

        }



    public void printMenu(){

        System.out.println("*************************Welcome To My MoneyTracker App**********************");
        System.out.println("----------------------------OptionList For Expense Tracking--------------------------------------");



        System.out.println("Select the options");
        System.out.println(" 1. Add New Expense");
        System.out.println(" 2. View List of Expense ");
        System.out.println(" 3. View list of Expense by Category ");
        System.out.println(" 4. Expense list by date");
        System.out.println(" 5. Monthly Expense list");
        System.out.println(" 6. Yearly Expense list");

        System.out.println("----------------------------OptionList For Income Tracking--------------------------------------");

        System.out.println(" 7. Add New Expense");
        System.out.println(" 8. View List of Expense ");
        System.out.println(" 9. View list of Expense by Category ");
        System.out.println(" 10. Expense list by date");
        System.out.println(" 11. Monthly Expense list");
        System.out.println(" 12. Yearly Expense list");
        System.out.println("Press 0 to exit");
        System.out.println("Select the options");
        choice = in.nextInt();
    }
    
    public void pressAnyKeyToContinue() throws IOException {
        System.out.println("Press any key to continue......");
        System.in.read();
    }

    private void onAddNewExpense(){
        in.nextLine();
        System.out.println("Enter new  expense Name");
        String expenseName=in.nextLine();
        //Expense exp1=new Expense(obj1);
        System.out.print("Enter Expense Amount");
        Double amount=in.nextDouble();
        Expense ex=new Expense();
        ex.setAmount(amount);
        ex.setExpenseType(expenseName);

        Date date=new Date();
        ex.setDate(date);
        //store expense object in repository
        repo.expenses.add(ex);
        System.out.println("Success:Expense Added");

        //Expense obj = new Expense(obj1,obj2);
        //repo.expenses.add(obj);




    }

    private void onViewExpenseList()throws ArrayIndexOutOfBoundsException{
        System.out.println("The expenses available in the list are :");
        List<Expense> list=repo.expenses;
        for(i=0;i<=list.size()-1;i++){
            Expense ex=list.get(i);
            System.out.println((i+1)+" : "+ex.getExpenseType()+"  ,"+ ex.getAmount()+" ,"+ex.getDate());
        }
    }

    private void onViewExpenseListByCategory(){
        System.out.println("view expense list by category");

    }
    Double getExpenseAmountByCategory(String name){
        for(Expense e: repo.expenses) {
            if(e.getExpenseType().equals(name)){
                return e.getAmount();
            }
        }
        return null; //invalid expense name
    }

    private void onViewExpenseListByDate(){
        System.out.println("view expense list by date");
    }

    private  void onViewMonthlyExpenseList(){
        System.out.println("view monthly expense list ");

    }
    private  void onViewYearlyExpenseList(){
        System.out.println("view yEARLY expense list ");

  }
    private void onAddNewIncome(){
      System.out.println("new income");
  }
   private void onViewIncomeList(){
      System.out.println("income list");
  }
   private void onViewIncomeListByCategory(){
      System.out.println("view Income list by category");
  }

  private void onViewIncomeListByDate(){
      System.out.println("view IIncome list by date");
  }

   private  void onViewMonthlyIncomeList(){
      System.out.println("view monthly expense list ");

  }
  private  void onViewYearlyIncomeList(){
      System.out.println("view yEARLY expense list ");

        }

          }

































































