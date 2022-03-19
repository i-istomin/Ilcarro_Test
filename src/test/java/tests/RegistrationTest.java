package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends MainTests {

    @BeforeMethod
    public void preCondition(){
        if (app.getUserHelper().isLogOutPresent()){
            app.getUserHelper().logout();
        }
    }

    @Test
    public void registrationSuccess(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index); //==sout

        app.getUserHelper().openRegistrationForm();//open regform
        app.getUserHelper().fillRegistrationForm("ira","black1","missmira1"+index+"@gmail.com","Irinka555$");
        app.getUserHelper().checkPolicyXY();
        app.getUserHelper().submit(); //click registration
        Assert.assertEquals(app.getUserHelper().checkMessage(), "You are logged in success");

    }
    @AfterMethod
    public void postConditions(){
        app.getUserHelper().confirmLogin();
    }
}
