package day8TestNG;
//assertEquals (Eqauals method comes from object class.), you override a method to provide own version

/*
@test, we create test annotation to test , otherwise you can not test because there is no main method

@Before class,
@Afterclass: this only runs once to teafdown


assertEquals(1,1)    assertEquals("a","a")    assertEquals(driver.getTitle(), "Google")
no assertion no test, assertion is to verify
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// what are the annotations and order what comes first.
/*
####TASK for 10 minutes: until 4:17
Create a class called PracticeTests
- setup before/after methods
	- in before method. instantiate webdriver and navigate to: http://practice.cybertekschool.com/
	- in after method - just close webdriver.
- create a test called lofinTest
	- go to “Form Authentication” page
	- enter valid credentials
	username: tomsmith
	password: SuperSecretPassword
	- verify that following sub-header message is displayed: “Welcome to the Secure Area. When you are done click logout below.”
 */
public class PracticeSet {
    private WebDriver driver;
    @Test
    public void loginTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        Thread.sleep(3000);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        //if assertion fails - it will throw exception and message will be printed
        //3 parameters: (expected, actual, "message in case of error")
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");
    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
    }
    @AfterClass
    public void teardown(){

        driver.quit();
    }
    /*
    @AfterMethod
    public void teardown(){
    driver.close(); this close the website
     */
}
