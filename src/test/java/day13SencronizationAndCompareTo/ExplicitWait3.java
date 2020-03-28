package day13SencronizationAndCompareTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait3 {
    private WebDriver driver;

    @Test
    public void waitForTitle(){
        driver.get("http://google.com");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        //wait up to 10 seconds until title contains Google
        wait.until(ExpectedConditions.titleContains("Google"));

        driver.navigate().to("http://amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));   // this already verifies

    }
    @Test
    public void waitForVisibility() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.tagName("button")).click();
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual, expected);
    }

    //task element is clickable
    @Test
    public void elementCilickable(){
      driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

      WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
      WebElement button5=driver.findElement(By.xpath("//button[@type='submit']"));

        WebElement loadingOverlayIcon = driver.findElement(By.xpath("//div[@class='loadingoverlay']")); //wait untill overlay is disapper. when oading is completed it is gone. means wait until overlay disasspera
        wait.until(ExpectedConditions.invisibilityOf(loadingOverlayIcon));


        wait.until(ExpectedConditions.elementToBeClickable(button5));

      username.sendKeys("tomsmith");
      password.sendKeys("SuperSecretPassword");
      button5.click();

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual, expected);


    }
    @Test
    public void elementToBeClickableTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[type = 'submit']"))));
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[type = 'submit']"))));
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
