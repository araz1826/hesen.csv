package day9Vytrack;
/*
https://qa2.vytrack.com/user/login  (there are 3 environments like below 1,2,3)
https://qa3.vytrack.com/user/login
https://qa2.vytrack.com/user/login
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// static import of all assertions
import static org.testng.Assert.*;

/// invalid user name and password task then verify that invalid message is displayed  ( [class='alert alert-error']>div") parent to child move, but you can not move from child to parent)

public class Login1 {
   private WebDriver driver;
   private String URL="https://qa2.vytrack.com/user/login";
   private By Username=By.id("prependedInput");    //By is a class. we can also do in this way
   private By Password=By.id("prependedInput2");
   private By warning=By.cssSelector("[class='alert alert-error']>div"); //>div means in css get to child class

   @Test(description = "verify that warning message displays when user enters invalid username and password")
   public void login(){
       driver.findElement(Username).sendKeys("invalidusername");
       driver.findElement(Password).sendKeys("wrongpassword", Keys.ENTER);

       WebElement warnings=driver.findElement(warning);
       assertTrue(warnings.isDisplayed());
   }
@Test (description = "login as store manager and verify that title is Dashboard")
public void loginastoreManager() throws InterruptedException {
       driver.findElement(Username).sendKeys("storemanager85");
       driver.findElement(Password).sendKeys("UserUser123",Keys.ENTER);
       Thread.sleep(3000);
       String Expected="Dashboard";
       String Actual=driver.getTitle(); //because Dashborad is a title

    Assert.assertEquals(Actual,Expected,"page title is not correct");

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
