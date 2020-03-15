package day8TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

//task
//click on checkbOX1 AND VERIFY THAT IT IS SELECTED
public class CheckBox {
    private WebDriver driver;

    @Test
    public void forgetPassword() throws InterruptedException {

        driver.findElement(By.linkText("Checkboxes")).click();
        Thread.sleep(2000);

        List<WebElement> checkboxes=driver.findElements(By.tagName("input"));
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected());

        //or
        /*
        WebElement check1= driver.findElement(By.xpath("//form[@id='checkboxes'][1]"));
        check1.click();
        Thread.sleep(5000);
        Assert.assertTrue(check1.isSelected(), "checkbox #1 is not selected");// after comma works if it is work otherwise does not print this out.

         */
    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
