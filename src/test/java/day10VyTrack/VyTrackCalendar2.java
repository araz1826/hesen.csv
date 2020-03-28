package day10VyTrack;
/*
Test Case: Default options
Login as sales manager
Go to Activities --> Calendar Events
Click on Create Calendar Event
Default owner name should be current user
Default title should be blank
Default start date should be current date
Default start time should be current time
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VyTrackCalendar2 {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By activities=By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By calendar=By.xpath("//span[text()='Calendar Events']");
    private By eventButton=By.xpath("//h1[@class='oro-subtitle']");
    private By createCalendar=By.cssSelector("a[title='Create Calendar event']");

    //this tasks locators
    private By userPatrick=By.cssSelector("[id='user-menu']>a");
    private By ownername=By.className("select2-chosen");
    private By titleEmpty=By.cssSelector("[id='oro_calendar_event_form_title-uid-5e716f123f283']");
    //start date and end date
    private By startDate=By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid-5e716f123f43a']"); //* means contains
    private By startTime=By.cssSelector("[id*='time_selector_oro_calendar_event_form_start']");
    //start time and date
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");
    @Test
    public void Scenarios() throws InterruptedException {

        driver.findElement(createCalendar).click();
        Thread.sleep(3000);
        String currentUserName= driver.findElement(userPatrick).getText();
        String ownerName=driver.findElement(ownername).getText().trim();
        Assert.assertEquals(currentUserName,ownerName);

        //how to say that title is empty,ex under owner title is empty
       //        Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
        //date time syntax = https://www.journaldev.com/17899/java-simpledateformat-java-date-format
        //Default start date should be current date

        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");
        Assert.assertEquals(actualDate , expectedDate);
        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");
        Assert.assertEquals(actualTime, expectedTime);
    }




    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.get(URL);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        Thread.sleep(2000);
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(activities)).perform();
        Thread.sleep(2000);
        driver.findElement(calendar).click();
        Thread.sleep(2000);


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
