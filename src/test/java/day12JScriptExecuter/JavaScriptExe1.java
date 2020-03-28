package day12JScriptExecuter;
// this is an alternative way to when your code does not in selenium

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExe1 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
  //task, verify page title with JSCRIPT. you can also do that with driver.getTitle
    @Test
    public void verifyTitle(){
        String expected = "Practice";
        //we create javascriptexecutor object by casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //executeScript - this method executes javascript code
        //we provide js code as a string
        //return document.title - javascript code
        //document - represents HTML page
        //.toString() - to avoid additional casting from Object to String
        String actual = js.executeScript("return document.title").toString();

        Assert.assertEquals(actual, expected);
    }

    //task we can click with java script as well
    @Test
    public void clickButton() throws InterruptedException {
        WebElement link=driver.findElement(By.linkText("Multiple Buttons"));
        //link.click();  // instead of clicking we use JS executor
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //after "" you can list your webelements that will be used as part of ur JS code
        js.executeScript("arguments[0].click()",link);   //you do not have to put link

        WebElement button6=driver.findElement(By.id("disappearing_button"));

        js.executeScript("arguments[0].click", button6);
        Thread.sleep(2000);

        //how to verift that after scilcking button6 result is same."Now it's gone!"
        WebElement result=driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"Now it's gone!");

        //enter task with JS


    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
