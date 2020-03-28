package day13SencronizationAndCompareTo;
/*
Interview questions: what is fluentwait
Fluent wait. why because layover load is not reliable that much. instead of avoiding page loading and
        because of that throws to exceptions we use fluent wait.

 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FluentWait4 {
    private WebDriver driver;

    @Test
    public void fluentWaitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        Wait<WebDriver> wait=new FluentWait<>(driver);


    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
