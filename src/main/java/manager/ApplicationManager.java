package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    EventFiringWebDriver wd;// WebDriver wd; vmesto webdriver nujen eventfiring chtobi rabotat s listener
    UserHelper userHelper;
    CarHelper car;
    HelperSearch search;
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);//pechataet v file "logback.xml"

    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());//vnutri utochniaem kakoy browser mi otkrivaem
        logger.info("All tests start in ChromeDriver");
        System.setProperty("webdriver.chrome.driver", "/home/i-istomin/TelRan/SYSTEMS/ilcaro_project/chromedriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/search");

        userHelper=new UserHelper(wd);
        car=new CarHelper(wd);
        search=new HelperSearch(wd);

        wd.register(new MyListener());//listener budet vse slishat, no otslejivat budet tolko 3 metoda kot-e ukazali v "Mylistener"
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

    public HelperSearch getSearch() {
        return search;
    }

}
