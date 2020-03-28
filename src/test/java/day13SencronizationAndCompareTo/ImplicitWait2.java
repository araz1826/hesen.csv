package day13SencronizationAndCompareTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait2 {
    private WebDriver driver;

// because ti takes time to load the page. webelement is visible after page loading. we may not find element untill loading.
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicitWait
        // if element will be found it will not wait

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    //task: click on load page2. and print out finish(hello world)
    @Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();
        WebElement finishElement=driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());

    }
}
