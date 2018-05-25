package tests;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import SuiteReader.Environment;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TC001_EnvironmentConfigTest {



    Environment testEnvironment ;
    Fairy fairy = Fairy.create();

    @Test
    public void newtest1(){

        //Create person object
        Person person = fairy.person();

        System.out.println(person.getFullName());
        System.out.println(person.getAddress());
        System.out.println(person.getAge());
        System.out.println(person.getEmail());
        System.out.println(person.getDateOfBirth());
        System.out.println(person.getPassportNumber());
        System.out.println(person.getCompanyEmail());
        System.out.println(person.getNationalIdentityCardNumber());
    }

    @Test
    public void configTest() {

        ConfigFactory.setProperty("env", "dev");

        testEnvironment= ConfigFactory.create(Environment.class);
        // prints http://qa.testautomationguru.com
        System.out.println(testEnvironment.url());

        // prints qa.db.testautomationguru.com
        System.out.println(testEnvironment.getDBHostname());

        System.out.println(testEnvironment.servername());

        assertThat("db.testautomationguru.com").isEqualTo(testEnvironment.getDBHostname());
    }
}
