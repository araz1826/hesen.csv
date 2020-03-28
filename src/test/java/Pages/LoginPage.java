package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.security.Key;

/*
    creating a model page for passwords usernmames. it is organizable
    used to store collection
     */
public class LoginPage {

    @FindBy (id= "prependedInput") // id: locator type,   "prependedInput": value
    public WebElement username;
    //public webelement username2=Driver.getDriver().finelement(By.id("")) it is same as above method

    @FindBy (id= "prependedInput2")
    public WebElement password;

    @FindBy (id= "_submit")
    public WebElement login;

    @FindBy (linkText = "Forgot your password?")
    public WebElement forgotPassword;

    public LoginPage(){
        //to connect our webdriver, page class and page factory
        //PageFactory-used to use @FindBy annotations
        //PageFactory-helps to find webelement
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //version #1
    public void login(String usernameValue, String passwordValue){  // this is overloaded
        this.username.sendKeys(usernameValue);  // you do not have to put this, because there is only 1 username
        this.password.sendKeys(passwordValue, Keys.ENTER);
    }
    //version #2  login as a default user (but either top or this are same)
    public void login(){
       username.sendKeys(ConfigurationReader.getProperty("store_manager"));  // you do not have to put this, because there is only 1 username
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }

}
