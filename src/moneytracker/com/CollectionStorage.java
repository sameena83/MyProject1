package moneytracker.com;

import java.util.List;
//This class is used as a collection,i mean store Datas andits a singleton
public class CollectionStorage {



    //
    private static CollectionStorage CollectionStorage;
    //  here object is collectionStorage and the the instance is created
    public List<Expense> expenses;
    public List <ExpenseCategory>catyList;
    public List<Income>incomes;
    //public List<IncomeType>incomeTypes;
    //The use of private constructor is to serve singleton classes. object cannot be created fromoutside class,
    // if wanted we can create frominside by calling getcollectionstorage method.
    // A singleton class is one which limits the number of objects creation to one.
    // Using private constructor we can ensure that no more than one object can be created at a time.

    private CollectionStorage(){

    }

    //TO CALL PRIVATE CONSTRUCOR,STATIC ONE,

    private static CollectionStorage getCollectionStorage(){

          //if collectionis nullitcreatesit
        if(CollectionStorage==null) {
            CollectionStorage = new CollectionStorage();
        }
        return CollectionStorage;

    }

}






