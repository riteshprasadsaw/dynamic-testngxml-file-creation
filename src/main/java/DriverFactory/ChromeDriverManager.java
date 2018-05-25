package DriverFactory;

//import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {



    @Override
    public void startService() {

    }

    @Override
    public void stopService() {

    }

    @Override
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

}
