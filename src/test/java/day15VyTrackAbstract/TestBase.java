package day15VyTrackAbstract;
/*Implicit wait does not get along with Explicit wait, if u use together it may cause unexpecttedlt long waits.
Implicit wait- it would go into BeforeMethod if u use
Explicit wait---used inside a test itself, since we have to provide a webelement,
TestBase class: abstract class, uses as a basement for all tet classes. This class provides essential setup and cleanup for
                the project. abstract because meant to be extended. to test inside
Actions class object- not in the utilities package,
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.Driver;

public abstract class TestBase {  //abstract meant to be exteded, reuseability
    protected WebDriverWait wait;  // it means visibile in this package and subclass (if only be visible to sub class should be protected)
    protected Actions actions;
  //Select: you can not create Select here because has to be created on there. it it generic,

    @BeforeMethod
    public void setup() {
        String URL= ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait=new WebDriverWait(Driver.getDriver(),15);
    }
    @AfterMethod
    public void teardown() {
       Driver.closeDriver();
    }  // it is a blueprint for all test classes
}
