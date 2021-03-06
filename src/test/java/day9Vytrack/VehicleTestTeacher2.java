package day9Vytrack;
/*
Actions actions =new Actions(driver);  //instead of clicking this is for hover over and perform
        actions.moveToElement(driver.findElement(fleetBy)).perform();
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

import javax.swing.*;

/*
         ######## TASK
         under fleet package create a class called VehiclesPageTests
        In this class, you will need to create @beforemethod with setup and @aftermethod with teardown part. Use LoginPageTests class as a reference.
        create a test called verifyPageSubTitle
        - in this test, you will need to navigate to Fleet --> Vehicles and verify that page subtitle is equals to "All Cars"
        user assertions for validation.
        */
public class VehicleTestTeacher2 {

    private String URL = "https://qa2.vytrack.com/user/login";
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private WebDriver driver;
    @Test
    public void verifyPageSubTitle() throws InterruptedException {
        //login
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        //put more wait here as well, if didn't click
        Thread.sleep(3000);
/*
        //your test may fail beacuse of the new codded added below.

        Actions actions =new Actions(driver);  //instead of clicking this is for hover over and perform
        actions.moveToElement(driver.findElement(fleetBy)).perform();  // movetoElement means hoverover,
*/

        //click on fleet
        driver.findElement(fleetBy).click();
        Thread.sleep(3000);
        //click on Vehicles
        driver.findElement(By.linkText("Vehicles")).click(); // for links you can do that
        //put more wait time if you are getting Cars, Dashboard...
        //this application is slooooow...
        Thread.sleep(3000);
        //find subtitle element
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());
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
