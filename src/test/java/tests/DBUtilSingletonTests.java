package tests;

import org.testng.annotations.Test;
import utilities.DBUtil;
import utilities.DBUtilSingleton;
import utilities.MultiThread;

public class DBUtilSingletonTests {

    @Test
    public void test(){
        DBUtilSingleton dbUtil = DBUtilSingleton.getInstance();
        dbUtil.runQuery("select * from ...1");
    }

    @Test
    public void test2(){
        DBUtilSingleton dbUtil = DBUtilSingleton.getInstance();
        dbUtil.runQuery("select * from ...2");
    }

    @Test
    public void test3(){
        DBUtilSingleton dbUtil = DBUtilSingleton.getInstance();
        dbUtil.runQuery("select * from ...3");
    }

    @Test
    public void dbUtilSingletonLazyMultiThreading(){
        for(int i=0;i<100;i++){
            MultiThread multiThread = new MultiThread();
            multiThread.start();
        }

    }
}
