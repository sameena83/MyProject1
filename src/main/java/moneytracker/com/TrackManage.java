package moneytracker.com;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * The MyFinanceTrack program implements an application that
 * simply do  Finance tracking and query can be done through console.
 * Track manage class do all the operations related to Expenses and Incomes
 *
 * @author  Haleemath Sameena
 * @version 1.0
 * @since   2020-10-23
 */

public class TrackManage {


    private final Scanner in=new Scanner(System.in);
    //storeData object provided by static method,how many times you call this method,you get only one storeData
    //object,since StoreData is a singleton object here
    private ReportService repo;

    //global
    private int  choice;
    int i;



    public TrackManage()  {
        restoreRepository();
        //prepareSampleData();//this function is used to add data to chek the function,i will delete it after checking
    }

    //when we call the show menu method a finite loop will go and it prints the menu

    /**
     *
     * @throws IOException
     *
     */
    public void  showMenu() throws IOException {
        while(true){
            show();
            //printMenu();
            switch (choice){
                case 0:
                    onExit();
                    //System. out. flush();
                    //System.exit(0);
                    //break;

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

                //case 4:
                    //onViewExpenseListByDate();
                    //pressAnyKeyToContinue();
                    //break;



                case 4:

                    onViewMonthlyExpenseList();
                    pressAnyKeyToContinue();
                    break;

                case 5:
                    onViewYearlyExpenseList();
                    pressAnyKeyToContinue();
                    break;

                case 6:
                    onAddNewIncome();
                    pressAnyKeyToContinue();
                    break;
                case 7:
                    onViewIncomeList();
                    pressAnyKeyToContinue();
                    break;

                case 8:
                    onViewIncomeListByCategory();
                    pressAnyKeyToContinue();
                    break;


                //case 10:

                    //onViewIncomeListByDate();
                    //pressAnyKeyToContinue();
                   // break;




                case 9:

                    onViewMonthlyIncomeList();
                    pressAnyKeyToContinue();
                    break;



                case 10:

                    onViewYearlyIncomeList();
                    pressAnyKeyToContinue();
                    break;


            }
        }

    }

    /**
     *  onExit will help to exit
     */
    private void onExit(){
        persistRepository();
        System.exit(0);
    }

    /**
     * shows menu of operations
     */

    public void show(){
        System.out.println("*************Welcome to MoneyTracker***********");
        System.out.println("  Press 10: To Expense Track");
        System.out.println("  Press 11: To Income Track");
        int choice1 = in.nextInt();
        if(choice1 ==10){

            System.out.println(" 1. Add New Expense");
            System.out.println(" 2. View List of Expense ");
            System.out.println(" 3. View list of Expense by Category ");
            System.out.println(" 4. Monthly Expense list");
            System.out.println(" 5. Yearly Expense list");
            System.out.println("Press 0 to exit");
            System.out.println("Select the options");
            choice = in.nextInt();

        }else if(choice1 ==11){

            System.out.println(" 6. View List of Incomes");
            System.out.println(" 7. View list of Incomes by Category ");
            System.out.println(" 8. Income list by date");
            System.out.println(" 9. Monthly Income list");
            System.out.println(" 10. Yearly Income  list");
            System.out.println("Press 0 to exit");
            System.out.println("Select the options");
            choice = in.nextInt();

        }else
        {
            System.out.println("enter a valid  options");
            in.nextInt();
        }

    }



   /** public void printMenu(){

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

        System.out.println(" 7. Add New Income");
        System.out.println(" 8. View List of Incomes");
        System.out.println(" 9. View list of Incomes by Category ");
        System.out.println(" 10. Income list by date");
        System.out.println(" 11. Monthly Income list");
        System.out.println(" 12. Yearly Income  list");
        System.out.println("Press 0 to exit");
        System.out.println("Select the options");
        choice = in.nextInt();
    }*/

    public void pressAnyKeyToContinue() throws IOException {
        System.out.println("Press any key to continue......");
        var read = System.in.read();
    }

    /**
     * to add new expenses
     */

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
        System.out.println("Enter Date(DD/MM/YYYY):");
        in.nextLine();
        String dateAsString=in.nextLine();
        LocalDate date= DateUtility.stringToDate(dateAsString);

        //Date date=new Date();
        ex.setDate(date);
        //store expense object in repository
        repo.getExpenses().add(ex);
        System.out.println("Success:Expense Added");

        //Expense obj = new Expense(obj1,obj2);
        //repo.expenses.add(obj);




    }

    /**
     *
     * @throws ArrayIndexOutOfBoundsException
     * to view expense list
     */

    private void onViewExpenseList()throws ArrayIndexOutOfBoundsException{
        System.out.println("The expenses available in the list are :");
        List<Expense> list=repo.getExpenses();
        for(i=0;i<=list.size()-1;i++){
            Expense ex=list.get(i);
            String dateString=DateUtility.dateToString(ex.getDate());
            System.out.println((i+1)+" : "+ex.getExpenseType()+"  ,"+ ex.getAmount()+" ,"+dateString);
        }
    }

    /**
     * to view expense list by category
     */

    private void onViewExpenseListByCategory(){
        System.out.println("view expense list by category");
        Map<String,Double>resultMap= repo.calculateCategoryExpense();
        Set<String>category=resultMap.keySet();
        for(String categories:category){
            System.out.println(categories+":"+resultMap.get(categories));
        }



    }
    //* *Double getExpenseAmountByCategory(String name){
    // for(Expense e: repo.expenses) {
    //if(e.getExpenseType().equals(name)){
    //return e.getAmount();
    //}
    //}*//
    //return null; //invalid expense name
    //}

    //private void onViewExpenseListByDate(){
        //System.out.println("view expense list by date");
    //}

    /**
     * to view monthly expense list
     */

    private  void onViewMonthlyExpenseList(){
        System.out.println("view monthly expense list ");
        Map<String,Double> result= repo.calculateMonthlyExpense();
        Set<String> keys=result.keySet();
        for(String yearMonth  :keys){
            //String [] arr=yearMonth.split(",");
            //String year=arr[0];
            //Integer  monthNo= Integer.valueOf(arr[1]);
            //String monthName=DateUtility.getMonthName(monthNo);

            System.out.println(yearMonth +" " + result.get(yearMonth));
        }

    }

    /**
     * to view yearly expense list
     */
    private  void onViewYearlyExpenseList(){
        System.out.println(" Yearly expense list ");
        Map<Integer,Double>resultMap= repo.calculateYearlyExpense();
        Set<Integer>years =resultMap.keySet();
        for(Integer year:years){
            System.out.println(year+":"+resultMap.get(year));
        }

    }

    /**
     * to add new income
     */
    private void onAddNewIncome(){

        in.nextLine();
        System.out.println("Enter new  Income category ");
        String incomeName=in.nextLine();
        //Expense exp1=new Expense(obj1);
        System.out.print("Enter Income Amount");
        Double amount=in.nextDouble();
        Income inc=new Income();
        inc.setAmount(amount);
        inc.setIncomeType(incomeName);

        System.out.print("Enter Date(DD/MM/YYYY):");
        in.nextLine();
        String dateAsString1=in.nextLine();
        LocalDate date1= DateUtility.stringToDate(dateAsString1);



        inc.setDate(date1);
        //store expense object in repository
        repo.getIncomes().add(inc);
        System.out.println("Success:New Income Added");

    }

    /**
     *
     * @throws ArrayIndexOutOfBoundsException
     * to view income list
     */
    private void onViewIncomeList()throws ArrayIndexOutOfBoundsException{
        System.out.println("The Income available in the list are :");
        List<Income> list1=repo.getIncomes();
        for(i=0;i<=list1.size()-1;i++){
            Income in=list1.get(i);

            String dateString=DateUtility.dateToString(in.getDate());

            System.out.println((i+1)+" : "+in.getIncomeType()+"  ,"+ in.getAmount()+" ,"+dateString);

        }
    }

    /**
     * to view income list by category
     */
    private void onViewIncomeListByCategory(){
        System.out.println("view Income list by category");

        Map<String,Double>resultMap= repo.calculateCategoryIncome();
        Set<String>category=resultMap.keySet();
        for(String categories:category){
            System.out.println(categories+":"+resultMap.get(categories));
        }

    }

    //private void onViewIncomeListByDate(){
        //System.out.println("view Income list by date");
    //}

    /**
     * to view monthly income list
     */

    private  void onViewMonthlyIncomeList(){
        System.out.println("view monthly Income list ");
        Map<String,Double> result= repo.calculateMonthlyIncome();
        Set<String> keys=result.keySet();
        for(String yearMonth  :keys){
            //String [] arr=yearMonth.split(",");
            //String year=arr[0];
            //Integer  monthNo= Integer.valueOf(arr[1]);
            //String monthName=DateUtility.getMonthName(monthNo);

            System.out.println(yearMonth +" " + result.get(yearMonth));
        }

    }

    /**
     * to view yearly income list
     */
    private  void onViewYearlyIncomeList(){
        System.out.println(" Yearly Income list ");
        Map<Integer, Double> resultMap= repo.calculateYearlyIncome();
        Set<Integer> years =resultMap.keySet();
        for(Integer year:years){
            System.out.println(year+":"+resultMap.get(year));

    }
    }

    public static void wait(int  ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * to prepare sample data to store to the disk
     */


    public void prepareSampleData()  {
        Expense party =new Expense("HouseParty",1000.00,DateUtility.stringToDate("12/12/2019"));
        wait(100);
        Expense shopping =new Expense("shopping",2000.00,DateUtility.stringToDate("12/01/2020"));
        wait(100);
        Expense gift =new Expense("gift",3000.00,DateUtility.stringToDate("01/01/2020"));
        Expense gift1 =new Expense("gift",3000.00,DateUtility.stringToDate("11/01/2020"));
        Expense gift3 =new Expense("gift",3000.00,DateUtility.stringToDate("12/01/2020"));
        repo.getExpenses().add(party);
        repo.getExpenses().add(shopping);
        repo.getExpenses().add(gift);
        repo.getExpenses().add(gift1);
        repo.getExpenses().add(gift3);


        Income  salary =new Income("Salary",20000.00,DateUtility.stringToDate("01/05/2020"));
        wait(100);
        Income  pBenefit =new Income("PBenefit",1000.00,DateUtility.stringToDate("01/05/2020"));
        wait(100);
        //Expense shopping =new Expense("shopping",2000.00,DateUtility.stringToDate("12/1/2020"));
        Income  salary1 =new Income("Salary",20000.00,DateUtility.stringToDate("01/06/2020"));
        wait(100);
        Income  salary3 =new Income("Salary",20000.00,DateUtility.stringToDate("01/07/2020"));
        wait(100);
        Income  pBenefit1 =new Income("PBenefit",1000.00,DateUtility.stringToDate("01/06/2020"));
        wait(100);
        Income  pBenefit2 =new Income("PBenefit",1000.00,DateUtility.stringToDate("01/07/2020"));

        repo.getIncomes().add(salary);
        repo.getIncomes().add(salary1);
        repo.getIncomes().add(salary3);
        repo.getIncomes().add(pBenefit);
        repo.getIncomes().add(pBenefit1);
        repo.getIncomes().add(pBenefit2);





    }

    /**
     * to write to the file
     */


    private void persistRepository(){
        serialize("expenses.ser", repo.getExpenses());
        serialize("incomes.ser", repo.getIncomes());
    }

    /**
     *
     * @param file
     * @param obj
     */

    public void serialize(String file,Object obj){
        try{
            FileOutputStream fs = new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fs);
            oos.writeObject(obj);
            oos.close();
            fs.close();
        }catch (FileNotFoundException ex){
            Logger.getLogger(TrackManage.class.getName()).log(Level.SEVERE,null,ex);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param file
     * @return obj
     */
    public Object deserialize(String file)  {
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fis);

            obj=ois.readObject();

            ois.close();
        } catch (EOFException e) {
            System.out.println("The file is empty");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("the file contains wired elements");
        }

        return obj;

    }

    private void restoreRepository()
    {
        Object  expenses = deserialize("expenses.ser");
        Object incomes  = deserialize("incomes.ser");
        repo = new ReportService(incomes, expenses);

    }

}


















