package tests;

import manage.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MainTests {

    protected static ApplicationManager app = new ApplicationManager();


    @BeforeMethod

    public void setUp() { //browser+https
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }




}