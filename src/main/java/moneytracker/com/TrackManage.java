package moneytracker.com;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrackManage {

    private final Scanner in=new Scanner(System.in);
    //storeData object provided by static method,how many times you call this method,you get only one storeData
    //object,since StoreData is a singleton object here
    Repository repo = Repository.getRepository(); //tODo I didn;t like this
    ReportService  reportService=new ReportService();

    //global
    private int  choice;
    int i;


  /**public TrackManage()
    {
        prepareSampleData();//this function is used to add data to chek the function,i will delete it after checking
    }*/
    public TrackManage() throws ClassNotFoundException {
        prepareSampleData();//this function is used to add data to chek the function,i will delete it after checking
        try {
            restoreRepository();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //when we call the show menu method a finite loop will go and it prints the menu
    public void showMenu() throws IOException {
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
    private void onExit(){
        //persistRepository();
        System.exit(0);
    }

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
        Date date= DateUtility.stringToDate(dateAsString);

        //Date date=new Date();
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
            String dateString=DateUtility.dateToString(ex.getDate());
            System.out.println((i+1)+" : "+ex.getExpenseType()+"  ,"+ ex.getAmount()+" ,"+dateString);
        }
    }

    private void onViewExpenseListByCategory(){
        System.out.println("view expense list by category");
        Map<String,Double>resultMap=reportService.calculateCategoryExpense();
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

    private  void onViewMonthlyExpenseList(){
        System.out.println("view monthly expense list ");
        Map<String,Double> result= reportService.calculateMonthlyExpense();
        Set<String> keys=result.keySet();
        for(String yearMonth  :keys){
            //String [] arr=yearMonth.split(",");
            //String year=arr[0];
            //Integer  monthNo= Integer.valueOf(arr[1]);
            //String monthName=DateUtility.getMonthName(monthNo);

            System.out.println(yearMonth +" " + result.get(yearMonth));
        }

    }
    private  void onViewYearlyExpenseList(){
        System.out.println(" Yearly expense list ");
        Map<Integer,Double>resultMap=reportService.calculateYearlyExpense();
        Set<Integer>years =resultMap.keySet();
        for(Integer year:years){
            System.out.println(year+":"+resultMap.get(year));
        }

    }
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
        Date date1= DateUtility.stringToDate(dateAsString1);



        inc.setDate(date1);
        //store expense object in repository
        repo.incomes.add(inc);
        System.out.println("Success:New Income Added");

    }
    private void onViewIncomeList()throws ArrayIndexOutOfBoundsException{
        System.out.println("The Income available in the list are :");
        List<Income> list1=repo.incomes;
        for(i=0;i<=list1.size()-1;i++){
            Income in=list1.get(i);

            String dateString=DateUtility.dateToString(in.getDate());

            System.out.println((i+1)+" : "+in.getIncomeType()+"  ,"+ in.getAmount()+" ,"+dateString);

        }
    }
    private void onViewIncomeListByCategory(){
        System.out.println("view Income list by category");

        Map<String,Double>resultMap=reportService.calculateCategoryIncome();
        Set<String>category=resultMap.keySet();
        for(String categories:category){
            System.out.println(categories+":"+resultMap.get(categories));
        }

    }

    //private void onViewIncomeListByDate(){
        //System.out.println("view Income list by date");
    //}

    private  void onViewMonthlyIncomeList(){
        System.out.println("view monthly Income list ");
        Map<String,Double> result= reportService.calculateMonthlyIncome();
        Set<String> keys=result.keySet();
        for(String yearMonth  :keys){
            //String [] arr=yearMonth.split(",");
            //String year=arr[0];
            //Integer  monthNo= Integer.valueOf(arr[1]);
            //String monthName=DateUtility.getMonthName(monthNo);

            System.out.println(yearMonth +" " + result.get(yearMonth));
        }

    }
    private  void onViewYearlyIncomeList(){
        System.out.println(" Yearly Income list ");
        Map<Integer, Double> resultMap=reportService.calculateYearlyIncome();
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


    public void prepareSampleData()  {
        Expense party =new Expense("HouseParty",1000.00,DateUtility.stringToDate("12/12/2019"));
        wait(100);
        Expense shopping =new Expense("shopping",2000.00,DateUtility.stringToDate("12/1/2020"));
        wait(100);
        Expense gift =new Expense("gift",3000.00,DateUtility.stringToDate("1/1/2020"));
        Expense gift1 =new Expense("gift",3000.00,DateUtility.stringToDate("11/1/2020"));
        Expense gift3 =new Expense("gift",3000.00,DateUtility.stringToDate("12/1/2020"));
        repo.expenses.add(party);
        repo.expenses.add(shopping);
        repo.expenses.add(gift);
        repo.expenses.add(gift1);
        repo.expenses.add(gift3);


        Income  salary =new Income("Salary",20000.00,DateUtility.stringToDate("1/5/2020"));
        wait(100);
        Income  pBenefit =new Income("PBenefit",1000.00,DateUtility.stringToDate("1/5/2020"));
        wait(100);
        //Expense shopping =new Expense("shopping",2000.00,DateUtility.stringToDate("12/1/2020"));
        Income  salary1 =new Income("Salary",20000.00,DateUtility.stringToDate("1/6/2020"));
        wait(100);
        Income  salary3 =new Income("Salary",20000.00,DateUtility.stringToDate("1/7/2020"));
        wait(100);
        Income  pBenefit1 =new Income("PBenefit",1000.00,DateUtility.stringToDate("1/6/2020"));
        wait(100);
        Income  pBenefit2 =new Income("PBenefit",1000.00,DateUtility.stringToDate("1/7/2020"));

        repo.incomes.add(salary);
        repo.incomes.add(salary1);
        repo.incomes.add(salary3);
        repo.incomes.add(pBenefit);
        repo.incomes.add(pBenefit1);
        repo.incomes.add(pBenefit2);





    }


    private void persistRepository(){
        serialize("expenses.ser",repo.expenses);
        serialize("incomes.ser",repo.incomes);
    }

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
    private void restoreRepository() throws IOException, ClassNotFoundException {
        List<Expense> expenses = (ArrayList<Expense>) deserialize("expenses.ser");
        List<Expense> incomes =(ArrayList<Expense>) deserialize("incomes.ser");
        if(expenses!=null){
            repo.expenses=expenses;
        }
        if(incomes!=null){
            repo.expenses=expenses;

        }
    }

}


















