package tests;

import manage.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class MainTests {

    protected static ApplicationManager app = new ApplicationManager();


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