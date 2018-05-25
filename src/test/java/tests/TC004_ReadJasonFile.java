package tests;

import JasonFileReader.Data;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC004_ReadJasonFile {

    public Data data;

    @Test
    public void JasonTest(){

            try {
                data = Data.get(System.getProperty("user.dir")+"/src/main/resources/user_data.json");
                System.out.println(data.getBillingAddress());


            } catch (IOException e) {
                e.printStackTrace();
            }



    }


}
