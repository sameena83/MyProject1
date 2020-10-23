package moneytracker.com;

import java.util.ArrayList;
import java.util.List;
//This class is used as a collection,i mean store Data's and its a singleton
public class Repository {

    //
    private static Repository repository;
    //  here object is StoreData and the the instance is created
    public List<Expense> expenses;

    public List<Income>incomes;
    //public List<Savings>income=new ArrayList<>();


    //public List<IncomeType>incomeTypes;
    //The use of private constructor is to serve singleton classes. object cannot be created from outside class,
    // if wanted we can create from inside by calling get collection storage method.
    // A singleton class is one which limits the number of objects creation to one.
    // Using private constructor we can ensure that no more than one object can be created at a time.

    public Repository(){

    }

    public Repository(Object in, Object ex)
    {
        if (in == null)
            incomes = new ArrayList<>();
        else
            incomes = (ArrayList<Income>) in;

    }

    //TO CALL PRIVATE CONSTRUCTOR,STATIC ONE,if you want to create object ,call this method and this method will provide
    //you with object conditionally
    public  static Repository getRepository(){

          //if collection is null .it creates
        if(repository==null) {
            repository= new Repository();
        }
        return repository;

    }

}






