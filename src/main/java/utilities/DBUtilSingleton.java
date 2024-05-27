package utilities;

//There is a limit on number of connections that database can handle
public class DBUtilSingleton {
    private DBUtilSingleton(){
        System.out.println("DBUtilSingleton constructor called" + this.hashCode());
    }

    //Early/Eager initialization => will always initialize even if not needed
//    private static final DBUtilSingleton dbUtil =new DBUtilSingleton();
//
//    public static DBUtilSingleton getInstance() {
//        System.out.println("DBUtilSingleton Instance Returned" + dbUtil.hashCode());
//        return dbUtil;
//    }
    //Early/Eager initialization => will always initialize even if not needed

//    // Lazy Initialization
//    private static DBUtilSingleton dbUtil;
//
//    public static DBUtilSingleton getInstance() {
//        if(dbUtil == null){
//            dbUtil = new DBUtilSingleton();
//            System.out.println("DBUtilSingleton Instance Created" + dbUtil.hashCode());
//        }
//        System.out.println("DBUtilSingleton Instance Returned" + dbUtil.hashCode());
//        return dbUtil;
//    }
//    // Lazy Initialization

//     // Thread Safe
//    private static DBUtilSingleton dbUtil;
//
//    public static synchronized DBUtilSingleton getInstance() {
//        if(dbUtil == null){
//            dbUtil = new DBUtilSingleton();
//            System.out.println("DBUtilSingleton Instance Created" + dbUtil.hashCode());
//        }
//        System.out.println("DBUtilSingleton Instance Returned" + dbUtil.hashCode());
//        return dbUtil;
//    }
//    //Thread Safe

    //Double Locking Thread Safe
    private static DBUtilSingleton dbUtil;

    public static DBUtilSingleton getInstance() {
        if(dbUtil == null){
            System.out.println("Thread inside if waiting to create resource");
            synchronized (DBUtilSingleton.class) {
                if(dbUtil == null){
                    dbUtil = new DBUtilSingleton();
                    System.out.println("DBUtilSingleton Instance Created" + dbUtil.hashCode());
                }
                else {
                    System.out.println("Double locking worked");
                }
            }
        }
        System.out.println("DBUtilSingleton Instance Returned" + dbUtil.hashCode());
        return dbUtil;
    }
    //Double Locking Thread Safe

    public void runQuery(String query){
        System.out.println("DBUtilSingleton Query  run successful" + query + " " + this.hashCode() );
    }

    public static void testCreation(){
        System.out.println("DBUtilSingleton test creation called");
    }

}