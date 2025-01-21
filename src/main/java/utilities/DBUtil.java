package utilities;

public class DBUtil {

    public DBUtil(){
        System.out.println("DbUtil Constructor called, Database connection opened"+ this.hashCode());
        //initialize connection
    }

    public void runQuery(String query){
        System.out.println("Query : "+ query + " ran");
    }

    public void printConfit(){
        System.out.println("DbUtil Configuration");
    }

}