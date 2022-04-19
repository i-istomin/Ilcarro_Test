package tests;

import org.slf4j.Logger;
import manage.ApplicationManager;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import java.lang.reflect.Method;


public class MainTests {

    protected static ApplicationManager app = new ApplicationManager();
    Logger logger=LoggerFactory.getLogger(MainTests.class);

    @BeforeMethod
    public void startLogger(Method m) {
        logger.info("Start test --->" + m);

    }

   // @BeforeMethod//method dlia kajdogo opredelennogo testa
    @BeforeSuite // metod dlia vseh testov srazu
    public void setUp() { //browser+https
        app.init();
    }

    //@AfterMethod //method dlia kajdogo opredelennogo testa
    @AfterSuite
    public void tearDown() {
        app.stop();
    }


}