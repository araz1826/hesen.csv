package day14SystemProperties;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DriverTest {
    //how to open brower without creating private driver and webdriver etc...
    @Test
    public void googleTest(){
        Driver.getDriver().get("http://google.com");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Driver.closeDriver();
    }
}
