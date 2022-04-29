package tests;


import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

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
    public void precondition(Method m) { //is login?->log out
        if (app.getUserHelper().isLogOutPresent()){
            app.getUserHelper().logout();
            logger.info("Test needs logout");

        }
    }

    @BeforeMethod
    public void startLogger(Method m){
        logger.info("start test"+ m.getName());
    }


    @Test(dataProvider = "validLoginData",dataProviderClass = MyDataProvider.class)//v Test dobavili nazvanie klassa
    public void loginSuccessNew(String email, String password) {

        // 0. otslejivaem s kakoy datou ya loginus
        logger.info("Start test 'loginSuccessNew' ");
        logger.info("The test starts with email"+ email+ "and password " +password);//[missira85@gmail.com] & [Irinka777$] meniaem na email & password
        // 1. click the  login regist form
        app.getUserHelper().openLoginForm();
        //2. fill email +type the #password
        app.getUserHelper().fillLoginForm(email, password);//("missira85@gmail.com", "Irinka777$") meniaem na email & password
        //3.click button yalla:
        app.getUserHelper().submit();
        //4 make pause before
        app.getUserHelper().pause(1000);
        //5. assert if it is true or false contact when success pop up opened
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
        //6. pishem chto test proshel i ne upal
        logger.info("Test 'loginSuccessNew' passed successfully");

     //   takeScreenShot("/home/i-istomin/TelRan/SYSTEMS/PhoneBook/src/test/screenshotS/screen.png");

    }

    @Test
    public void loginSuccessNew1() {
        logger.info("Testing 'loginSuccessNew1' ");
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("missira85@gmail.com", "Irinka777$");//doljni bit dannye kot-e nujno vpisat v form
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
        logger.info("Test 'loginSuccessNew1' passed successfully");
    }

    @Test
    public void loginSuccessModel() {
        User user=new User().withEmail("missira85@gmail.com").withPassword("Irinka777$");


        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);//vpisivaem suda user. no metod rugaetsia.
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }

    @Test(dataProvider="validModelLogin", dataProviderClass = MyDataProvider.class)
    public void loginModelDataProvider(User user) {

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);//vpisivaem suda user. no metod rugaetsia.
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
       Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }

    @Test(dataProvider="validModelCSV", dataProviderClass = MyDataProvider.class)
    public void loginModelCSVDataProvider(User user) {
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);//vpisivaem suda user. no metod rugaetsia.
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
       Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }

    @AfterMethod
    public void postCondition(Method m) {
        app.getUserHelper().confirmLogin();
        logger.info("End of test"+m.getName());

    }

}



