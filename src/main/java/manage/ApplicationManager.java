package manage;

import models.Car;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;
    CarHelper car;

    public void init() {
        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/home/i-istomin/TelRan/SYSTEMS/ilcaro_project/chromedriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/search");

        userHelper=new UserHelper(wd);
        car=new CarHelper(wd);
    }

    public void stop() {
       // wd.quit();
     //If there are one or more browser windows open, it will close all the open browser windows

        //************************************
        //Explanation use case quit(): You should use driver.quit whenever you want to end the program.
        // It will close all opened browser windows and terminates the WebDriver session.
        // If you do not use driver.quit at the end of the program,
        // the WebDriver session will not close properly and files would not be cleared from memory.
        // This may result in memory leak errors.
        //************************************
        //WebDriver.Dispose() This method closes all Browser windows and safely ends the session
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CarHelper getCar() {
        return car;
    }
}
