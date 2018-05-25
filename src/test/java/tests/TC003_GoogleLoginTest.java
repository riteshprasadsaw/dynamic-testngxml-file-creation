package tests;

import PageObjects.googlepage;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.testng.Arquillian;
import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@RunAsClient
public class TC003_GoogleLoginTest extends Arquillian {

    @Page
    googlepage google;

    @Test(dataProvider = "search-keywords")
    public void googleTest(String searchKeyword) {
        google.goTo();
        google.searchFor(searchKeyword);
        Assert.assertTrue(google.getResults().size()>0);
    }

    @DataProvider(name = "search-keywords")
    public static Object[][] credentials() {
        return new Object[][] {
                { "test automation guru" },
                { "selenium webdriver" },
                { "dockerized selenium grid" },
                { "test automation blog" },
                { "jmeter docker" } ,
                { "test automation guru" },
                { "selenium webdriver" },
                { "dockerized selenium grid" },
                { "test automation blog" },
                { "jmeter docker" }
        };
    }

}