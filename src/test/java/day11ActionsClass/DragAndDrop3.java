package day11ActionsClass;

//actions.dragAndDrop(smallCircle,bigCirle).perform();     //source and target
//drag and drop is one of the actions

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

public class DragAndDrop3 {
    private WebDriver driver;
    private String URL="https://demos.telerik.com/kendo-ui/dragdrop/index";
    private Actions actions;

    @Test
    public void dragandDrop() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(2000);
        WebElement bigCirle=driver.findElement(By.id("droptarget"));
        WebElement smallCircle=driver.findElement(By.id("draggable"));

        actions.dragAndDrop(smallCircle,bigCirle).perform();     //source and target

        String expected="You did great!";
        String actual=bigCirle.getText();
        Assert.assertEquals(actual,expected);

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
