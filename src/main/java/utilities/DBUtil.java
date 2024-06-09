package utilities;

public class DBUtil {

    public DBUtil(){
        System.out.println("DB Util constructor called hash:" + this.hashCode());
    }


    public void runQuery(String query){
        System.out.println("DB Util  Query  run successful" + query + " " + this.hashCode());
    }
}