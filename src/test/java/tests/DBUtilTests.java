package tests;

import org.testng.annotations.Test;
import utilities.DBUtil;

public class DBUtilTests {

    @Test
    public void test(){
        DBUtil dbUtil = new DBUtil();
        dbUtil.runQuery("select * from ...1");
    }

    @Test
    public void test2(){
        DBUtil dbUtil = new DBUtil();
        dbUtil.runQuery("select * from ...2");
    }

    @Test
    public void test3(){
        DBUtil dbUtil = new DBUtil();
        dbUtil.runQuery("select * from ...3");
    }


}
