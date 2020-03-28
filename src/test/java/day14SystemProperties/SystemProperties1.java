package day14SystemProperties;
//we are creating map and storing all in it. and use it when necessary

//properties like a map:  ex: we need this to get the Path to add or upload. lets say couple people work on same project and u want to get your path
     //we need to get the path

//Interview: how to verify your downloaded folder.String pathToDownloads=System.getProperty("user.home")+"/Downloads"; //
//#this file is used for project configuration  check configuration.properties file

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SystemProperties1 {
    private WebDriver driver;

    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir")); // represent the path, our selenium project. it is user directory
        //System.out.println(System.getProperties()); this will print out all properties.
        System.out.println(System.getProperty("os.name")); // output: Windows 10
        System.out.println(System.getProperty("user.home"));

        String pathToDownloads=System.getProperty("user.home")+"\\Downloads"; // this is to get the download folder
        System.out.println(pathToDownloads);

        System.out.println(System.getProperty("os.arch"));

        //right click at project and add file name it configuration.properties . we set up once.
         //inside the file we add below
        /*
        #key=value
        browser=chrome  // what ever browser you put will run that

        configuration.properties// this maintain the configuration data, setttings etc...
        */

    }

}
