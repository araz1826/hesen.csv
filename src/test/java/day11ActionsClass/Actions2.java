package day11ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//go below link and hover on "enabled" then hover on "download" and click on pdf
public class Actions2 {
    private WebDriver driver;
    private String URL="http://practice.cybertekschool.com/jqueryui/menu#";
    private Actions actions;

    @Test
    public void hover() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(2000);
        WebElement enabled=driver.findElement(By.id("ui-id-3"));
        WebElement download=driver.findElement(By.id("ui-id-4"));
        WebElement pdf= driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(enabled).pause(2000).
                moveToElement(download).pause(2000).click(pdf).build().perform();

        //driver.findElement(By.id("ui-id-5")).click();   //with css #ui-id-5  or you can do click seperately
        Thread.sleep(2000);

    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        actions=new Actions(driver);
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
