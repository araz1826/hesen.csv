package day11ActionsClass;
/*
Java Script is a interface so we can not create an object out of it.
 so are casting our webdriver interface to javascriptexecutor interface, so we can execute the java scrtipt code in selenium webdriwer
 \scroll down method
 /*
  //JavascriptExecutor js= (JavascriptExecutor) driver;  this is casting
       driver.executeScript("windows.scrollBy(0,250)");
 */

//why do  we use: to execute the script.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//this is for infitine class
public class JVscript4 {     // RemoteWebDriver  is a super type ,
    private RemoteWebDriver driver;   //(check picture in secure folder) instead of Webdriver we use RemoteWebdrie. it is super class of chromedriver.
    private String URL="http://practice.cybertekschool.com/infinite_scroll";

    @Test
    public void scrollTest() throws InterruptedException {
        driver.get(URL);

        //JavascriptExecutor js= (JavascriptExecutor) driver;  this is casting
       driver.executeScript("windows.scrollBy(0,250)");

        for (int i = 0; i <10 ; i++) {
            driver.executeScript("windows.scrollBy(0,250)"); //scroll down 10 times.  // 0 is x , 250 is y axis
        }

        //scroling down the webpage untill you see the note:


    }
    @Test
    public void scrolldownElement() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement link=driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)",link); //argument[0] means until you  get link
                                                //scrollIntoView(true) it means scroll until this element is visible
        Thread.sleep(2000);
    }
   
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
