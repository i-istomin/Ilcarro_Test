package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RegistrationTest extends MainTests {

    @BeforeMethod(alwaysRun = true)
    public void preCondition(Method m) {
        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logout();
            logger.info(("Start test" + m.getName()));
        }
    }

    @Test
    public void registrationSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(index); //==sout

        logger.info("missmira1" + index + "@gmail.com");
        logger.info("the index is--> "+index);

        app.getUserHelper().openRegistrationForm();//open regform
        app.getUserHelper().fillRegistrationForm("ira", "black1", "missmira1" + index + "@gmail.com", "Irinka555$");
        app.getUserHelper().checkPolicyXY();
        app.getUserHelper().submit(); //click registration
        //app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "You are logged in success");

    }

    @Test(groups = {"web"})
    public void registrationSuccessModel() {

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        // System.out.println(index); //==sout
        User user = new User().withName("ira").withLastNAme("Black1").withEmail("missmira1" + index + "@gmail.com").withPassword("Irinka555$");

        app.getUserHelper().openRegistrationForm();//open regform
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().checkPolicyXY();
        app.getUserHelper().submit(); //click registration
        //app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "You are logged in success");

    }

    @Test
    public void registrationWrongPasswordModel() {

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        // System.out.println(index); //==sout
        User user = new User().withName("iraa").withLastNAme("Black1").withEmail("missmiras" + index + "@gmail.com").withPassword("12345");

        app.getUserHelper().openRegistrationForm();//open regform
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().checkPolicyXY();
      //  app.getUserHelper().submit(); //not click registration, because we don't need it

        Assert.assertTrue(app.getUserHelper().isErrorPasswordDisplayedSize());
       Assert.assertTrue(app.getUserHelper().isErrorPasswordFormat());//check if button "yalla" not cklickable
        Assert.assertFalse(app.getUserHelper().isYallaButtonNotActive());
        Assert.assertTrue(app.getUserHelper().isButtonClickable());

    }

    @AfterMethod(alwaysRun = true)
    public void postConditions() {
        app.getUserHelper().confirmLogin();
    }
}
