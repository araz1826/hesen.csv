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

public class ForgetPassword {
    private WebDriver driver;

    @Test
    public void forgetPassword() throws InterruptedException {

        driver.findElement(By.linkText("Forgot Password")).click();
        Thread.sleep(2000);
    driver.findElement(By.name("email")).sendKeys("arazismailov@yahoo.com",Keys.ENTER);


    Assert.assertEquals(driver.findElement(By.name("confirmation_message")).getText(),"Your e-mail's been sent!");





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
