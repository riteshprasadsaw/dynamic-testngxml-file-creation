package tests;

import SuiteReader.XLSReader;
import org.testng.annotations.Test;

public class TC006_GenerateTestNGFileDynimically {
    @Test
    public void TestNgTest(){
        XLSReader suite = new XLSReader("C:\\Users\\ryani\\Downloads\\dynamic-testng-xmlfile-creation\\src\\main\\resources\\tests.xls");
        suite.getTests("Select * from TestCase where Active = 'Y' and Module = 'Order'");
    }
}
