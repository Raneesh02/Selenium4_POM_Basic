package utilities;

public class DBUtilSingleton {

    private DBUtilSingleton(){
        System.out.println("DbUtilSingleton Constructor called, Database connection opened"+ this.hashCode());
        //initialize connection
    }

    public static DBUtilSingleton dbUtilSingleton;

    public static DBUtilSingleton getInstance(){
        if(dbUtilSingleton==null){
            System.out.println("Lazy Loading creating an instance of dbutil singleton");
            dbUtilSingleton=new DBUtilSingleton();
        }
        return dbUtilSingleton;
    }

    public void runQuery(String query){
        System.out.println("Query : "+ query + " ran");
    }

    public void printConfit(){
        System.out.println("DbUtil Configuration");
    }

}