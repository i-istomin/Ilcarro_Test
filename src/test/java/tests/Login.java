package tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends MainTests {

 //   @Test
//    public void loginSuccess() {
        // 1. click the  login
//        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login?url=%2Fsearch']"));
//        loginItem.click();
//
//        //2. fill email
//        WebElement emailInput=wd.findElement(By.xpath("//input[@id='email']"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("missira85@gmail.com");
//        //    type(By.cssSelector("#email"), "missira85@gmail.com");
//
//        //3. type the #password
//        WebElement passwordInput=wd.findElement(By.xpath("//input[@id='password']"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("Irinka777$");
//
//        //4.click button yalla
//        wd.findElement(By.xpath("//button[contains(text(),'Y’alla!')]")).click();
//        //esli mi sobiraemsia sdelat tolko odno deystview kak najat na knopku "login", to nam ne obazatelno zayavliat WEbElement
//        //nam ne nujen eshe odin element i nichego s nim delat
//
//
//        //5. click button "ok"
//        wd.findElement(By.xpath("//*[@type='button']")).click();
//
//
//        //Assert
//       // Assert.assertTrue(wd.findElements(By.xpath("//*[@href='/logout?url=%2Fsearch']")).size()>0);
//        Assert.assertTrue(wd.findElements(By.xpath("//*[text()=' Logout ']")).size() > 0);
 //   }

    @BeforeMethod
    public void precondition() { //is login?->log out
        if (app.getUserHelper().isLogOutPresent()){
            app.getUserHelper().logout();
        }
    }


    @Test
    public void loginSuccessNew() {
        // 1. click the  login regist form
        app.getUserHelper().openLoginForm();
        //2. fill email +type the #password
        app.getUserHelper().fillLoginForm("missira85@gmail.com", "Irinka777$");//doljni bit dannye kot-e nujno vpisat v form
        //3.click button yalla:
        app.getUserHelper().submit();
        //4 make pause before
        app.getUserHelper().pause(1000);
        //5. assert if it is true or false contact when success pop up opened
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }

    @Test
    public void loginSuccessNew1() {

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("missira85@gmail.com", "Irinka777$");//doljni bit dannye kot-e nujno vpisat v form
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }

    @AfterMethod
    public void postCondition() {
        app.getUserHelper().confirmLogin();
    }

}



