package day13WebTables;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Practice1 {
    private WebDriver driver;

    //Task: get all last names in tables 1 and verify that last names are sorted
    @Test
    public void VerifyLastNamesSosted() throws InterruptedException {
        driver.findElement(By.xpath("//table[1]//th[1]")).click();//purpose of the click is make it sorted
        Thread.sleep(2000);
        List<WebElement> lastnames=driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i <lastnames.size() ; i++) {
            String value=lastnames.get(i).getText();
            String nextvalue=lastnames.get(i+1).getText();
            Assert.assertTrue(value.compareTo(nextvalue)<=0); // compare based on their ascii because number are getting bigger so smaller -bigger will be negative
                                                                            //ex: b=68  c=83  b-c (compareto)-15. it is true
                                                                            // zero means they are same
           //assertTrue(list.get(i).compareTo(list.get(i + 1)) <= 0);
        }

        /*
        //Collections.sort(listSorted);
          List<WebElement> lastNames= driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
      List<String> textLastNames=BrowserUtils.getTextFromWebElement(lastNames);
      List<String> sortedLastNames= Arrays.asList("Bach","Conway","Doe","Smith");
        Assert.assertEquals(textLastNames,sortedLastNames);
         */
    }


    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/tables");
        Thread.sleep(2000);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
/*
 @Test
    public void test() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        //click on column name
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(2);
        //collect all values from the first column
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i < column.size() - 1; i++) {
            //take a string
            String value = column.get(i).getText();
            //take a following string
            String nextValue = column.get(i + 1).getText();

            System.out.println(value.compareTo(nextValue));

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equals
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }
 */