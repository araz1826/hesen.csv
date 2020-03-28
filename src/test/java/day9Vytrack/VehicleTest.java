package day9Vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

//task: under fleet package create a class called Vehicletest, create @beforemethod with setup and @aftermethod
// with teardown  and use loginpagetest class as reference,
  //create a test called verify that page subtitle is "All cars"
//use assertions for validation

public class VehicleTest {



        private WebDriver driver;
        private String URL = "https://qa2.vytrack.com/user/login";
        private By Username = By.id("prependedInput");    //By is a class. we can also do in this way
        private By Password = By.id("prependedInput2");
        private By warning = By.cssSelector("[class='alert alert-error']>div"); //>div means in css get to child class


        @Test (description = "login as store manager and verify that title is Dashboard")
        public void loginastoreManager() throws InterruptedException {
            driver.findElement(Username).sendKeys("storemanager85");
            driver.findElement(Password).sendKeys("UserUser123",Keys.ENTER);
            Thread.sleep(3000);

        }


        @Test (description = "get into fleet")
        public void flee(){
            List<WebElement> modules=driver.findElements(By.className("fa-asterisk menu-icon"));
            modules.get(0).click();
            List<WebElement>list=driver.findElements(By.className("dropdown-menu-wrapper dropdown-menu-wrapper__scrollable"));
            list.get(0).click();

            String Expected="All\n" +
                    "                        Cars";
            String Actual=driver.findElement(By.className("oro-subtitle")).getText();
            Assert.assertEquals(Actual,Expected,"is not same");
        }

        @BeforeMethod
        public void setup(){
            WebDriverManager.chromedriver().version("79").setup();
            driver=new ChromeDriver();
            driver.get(URL); // since int this task we gonna work on the this link so we called the url in before method
            driver.manage().window().maximize();

        }

        @AfterMethod
        public void teardown(){
            if(driver!=null){
                driver.quit();   //destroy object, it means get rid of the object from heap.
            }

        }

    }

/*
@Test(description = "verify you can list all cars in fleet")
public void fleetTask(){
    BrowserUtils.wait(2);
    driver.findElement(userNameBy).sendKeys(storeManager);  //truck driver login
    driver.findElement(passwordBy).sendKeys(storeManagerPassword);
    driver.findElement(loginBy).click();
    BrowserUtils.wait(2);
    String userNameText=driver.findElement(logOnUserName).getText().trim();
    System.out.println("userNameText = " + userNameText);
    assertEquals(userNameText, "Lorenzo Weissnat");
    driver.findElement(fleetMenu).click();
    driver.findElement(vehiclesLink).click();
    BrowserUtils.wait(2);
    assertTrue(driver.findElement(carsHeader).isDisplayed());
 */
/*
//    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private WebDriver driver;
    @Test
    public void verifyPageSubTitle(){
        //login
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        //put more wait here as well, if didn't click
        BrowserUtils.wait(5);
        //click on fleet
        driver.findElement(fleetBy).click();
        BrowserUtils.wait(2);
        //click on Vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        //put more wait time if you are getting Cars, Dashboard...
        //this application is slooooow...
        BrowserUtils.wait(5);
        //find subtitle element
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());
    }
 */