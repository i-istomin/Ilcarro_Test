package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class MainTests {

    WebDriver wd;


    @BeforeMethod

    public void init() { //browser+https
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/home/i-istomin/TelRan/SYSTEMS/ilcaro_project/chromedriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/search");
    }

    @AfterMethod
    public void tearDown() {
        wd.close(); // Close the browser window that the driver has focus of
        wd.quit(); //If there are one or more browser windows open, it will close all the open browser windows

        //Explanation use case quit(): close():- Suppose you have opened multiple browser windows with same driver instance,
        // now calling close() on the driver instance will close the current window the driver instance is pointed to.
        // But the driver instance still remain in memory and can be used to handle other open browser windows.
        //************************************
        //Explanation use case quit(): You should use driver.quit whenever you want to end the program.
        // It will close all opened browser windows and terminates the WebDriver session.
        // If you do not use driver.quit at the end of the program,
        // the WebDriver session will not close properly and files would not be cleared from memory.
        // This may result in memory leak errors.
        //************************************
        //WebDriver.Dispose() This method closes all Browser windows and safely ends the session
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator){//vajno chtob mne vernuli true/false
        return wd.findElements(locator).size() > 0;
    }



}