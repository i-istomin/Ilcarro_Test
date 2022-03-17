package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends MainTests {
    @Test

    public void registrationSuccess(){

        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index); //==sout

        app.getUserHelper().openLoginRegistrationForm();//open regform
        app.getUserHelper().fillLoginRegistrationForm("missira22"+index+"@gmail.com","Irinka555$"); //fill email +   //fill password
        app.getUserHelper().submitRegistration(); //click registration
        Assert.assertTrue(app.getUserHelper().isLoginRegistrationSuccess());

    }
}
