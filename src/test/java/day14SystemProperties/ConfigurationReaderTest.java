package day14SystemProperties;

//
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){
        String browser= ConfigurationReader.getProperty("browser");  //key value was browser in ConfigurationReader class. if you change chroem to firfox you will ge firefox
        System.out.println(browser);

        String url=ConfigurationReader.getProperty("qa1"); //click on qa1 and hold ctrl button see the link

        String color=ConfigurationReader.getProperty("color");

        System.out.println(browser);
        System.out.println(url);
        System.out.println(color);

        String username=ConfigurationReader.getProperty("username");
        String password=ConfigurationReader.getProperty("password");
        String driver=ConfigurationReader.getProperty("driver");
        System.out.println(username);
        System.out.println(password);
        System.out.println(driver);

    }
}
