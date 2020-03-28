package day13SencronizationAndCompareTo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckAllButton {
    private WebDriver driver;

    @Test
    public void fluentWaitTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fweborders%2fDefault.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

        List<WebElement> checkBox=driver.findElements(By.xpath("//table[@class='SampleTable']//tbody//td[1]"));
        for (WebElement boxes:checkBox) {
            boxes.click();
        }

    }
    //verify that steve john zipcode is 21233 and update to 20002 then verofy is zipcode is 20002
    @Test
    public void updateZipcode(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fweborders%2fDefault.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

        WebElement zipcode=driver.findElement(By.xpath("//table//tr[4]//td[9]"));
        Assert.assertEquals(zipcode.getText(),"21233");

        //click on update --edit image
        driver.findElement(By.xpath("(//input[@alt='Edit'])[3]")).click();

        WebElement zipcodeInput=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipcode.clear();  //clear ot first before typing
        zipcodeInput.sendKeys("20002");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();

        zipcode=driver.findElement(By.xpath("//table//tr[4]//td[9]")); // we have to re find element again
        Assert.assertEquals(zipcode.getText(),"20002");

    }
    @Test
    public void updateZipCode(){
        WebElement zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        Assert.assertEquals(zipcode.getText(), "21233");
        //click on update image
        driver.findElement(By.xpath(" //td[text()='Steve Johns']//following-sibling::td/input")).click();
        WebElement zipcodeInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipcodeInput.clear();
        zipcodeInput.sendKeys("20002");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        Assert.assertEquals(zipcode.getText(), "20002");
    }


    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        Thread.sleep(2000);
        driver=new ChromeDriver();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
