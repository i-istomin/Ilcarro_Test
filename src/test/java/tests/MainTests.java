package tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import manager.ApplicationManager;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import java.lang.reflect.Method;


public class MainTests {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger=LoggerFactory.getLogger(MainTests.class);

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method m) {
        logger.info("Start test --->" + m.getName());

    }

   // @BeforeMethod//method dlia kajdogo opredelennogo testa
    @BeforeSuite (alwaysRun = true)// metod dlia vseh testov srazu
    public void setUp() { //browser+https
        app.init();
    }

    //@AfterMethod //method dlia kajdogo opredelennogo testa
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}