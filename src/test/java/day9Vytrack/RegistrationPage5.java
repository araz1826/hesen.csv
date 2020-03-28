package day9Vytrack;

//import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationPage5 {

    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    // p tag name of success message
    // one xpath for all inputs: //label[text()='Label name']/..//input
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    //gender
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");

    //languages
    ////input[@value='cplusplus']  xpath
    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
    //sign up button
    private By signUpBy = By.id("wooden_spoon");

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(firstNameBy).sendKeys("Patrick");
        driver.findElement(lastNameBy).sendKeys("White");
        driver.findElement(usernameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@email.com");
        driver.findElement(passwordBy).sendKeys("123455678");
        driver.findElement(phoneBy).sendKeys("234-123-1231");

        driver.findElement(maleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("01/02/1940");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        Thread.sleep(3000);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);

    }//TASK
    //put 1 character to first name and verify(lentght of char) that it shows invalid text as below, we only checn visible or not
    @Test
    public void verifyFirstNameLength() throws InterruptedException {
        driver.findElement(firstNameBy).sendKeys("a");
        Thread.sleep(3000);
        WebElement warningMessage=driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
    Assert.assertTrue(warningMessage.isDisplayed());
    }

    //Task= verfy that you can not enter number to username and display warning message
    @Test
    public void verifyByEnteringNumber() throws InterruptedException {
        driver.findElement(firstNameBy).sendKeys("123");
        Thread.sleep(3000);
        WebElement byNumberWarning=driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
   Assert.assertTrue(byNumberWarning.isDisplayed());

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}