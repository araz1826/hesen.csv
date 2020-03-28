package day11ActionsClass;
/*
you can change method/ actions and and perform them as one event.
move your mouse and click on some point or context is action too.
build pattern also is one of the actions.
//drag and drop is one of the actions

pause(1000).build().perform

New method (By.xpath("//h5[text()='name: user1']"));//(//h5)[1]
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClass1 {
    private WebDriver driver;
    private String URL="http://practice.cybertekschool.com/hovers";
    private Actions actions;

    @Test
    public void hover() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        WebElement image1=driver.findElement(By.xpath("(//img)[1]"));   //() means gets all in and choose the 1st one
        WebElement image2=driver.findElement(By.xpath("(//img)[2]"));  // or (//img[@alt='User Avatar'])[1]
        WebElement image3=driver.findElement(By.xpath("(//img)[3]"));

        actions.moveToElement(image1).pause(1000).  //this pause 1 sec
                moveToElement(image2).pause(1000).
                moveToElement(image3).pause(1000).
                build().perform();//build means when you combine couple actions together. if there is 1 actions we do not use build




    }  //verify that after clicking image 1  "name: user1" is displayed
    //hoverOver the image and make sure that text is visible
    @Test
    public void FirstImage(){
        driver.findElement(By.xpath("(//img)[1]")).click();

        WebElement imgtext1=driver.findElement(By.xpath("//h5[text()='name: user1']"));//(//h5)[1]
        Assert.assertTrue(imgtext1.isDisplayed());

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
