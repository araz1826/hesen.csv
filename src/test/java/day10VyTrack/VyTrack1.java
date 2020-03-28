package day10VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

/*
Scenario: Verify for store manager
Login as story manager
Go to Activities --> Calls
Verify that Log Call button is displayed
Go to Activities --> Calendar Events
Verify that Create Calendar Event button is displayed
 */
public class VyTrack1 {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By activities=By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By calendar=By.xpath("//span[text()='Calendar Events']");
    private By eventButton=By.xpath("//h1[@class='oro-subtitle']");
    private By logCall=By.cssSelector("a[title='Log call']");
    private By createCalendar=By.cssSelector("a[title='Create Calendar event']");

    @Test
    public void Scenarios() throws InterruptedException {
        driver.get(URL);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        Thread.sleep(2000);
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(activities)).perform();
        Thread.sleep(2000);
        driver.findElement(calendar).click();
        Thread.sleep(2000);
        String expected="All Calendar Events";
        String actual=driver.findElement(eventButton).getText().trim();
        System.out.println(actual);

        Assert.assertEquals(actual,expected,"not equals");


    }
    @Test
    public void LogButton(){
        Assert.assertTrue(driver.findElement(logCall).isDisplayed());
    }

    @Test
    public void CalendarCreate(){
        Assert.assertTrue(driver.findElement(createCalendar).isDisplayed());
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}
