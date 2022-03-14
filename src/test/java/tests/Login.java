package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends MainTests {

    @Test
    public void loginSuccess(){
        // 1. click the  login
        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login?url=%2Fsearch']"));
        loginItem.click();



        //2. fill email
        WebElement emailInput=wd.findElement(By.xpath("//input[@id='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("missira85@gmail.com");
        //    type(By.cssSelector("#email"), "missira85@gmail.com");

        //3. click the #password
        WebElement passwordInput=wd.findElement(By.xpath("//input[@id='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Irinka777$");

        //4.click button yalla
        wd.findElement(By.xpath("//button[contains(text(),'Y’alla!')]")).click();

        //5. click button "ok"
        // wd.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
        wd.findElement(By.xpath("//*[@type='button']")).click();


        //Assert
        // Assert.assertTrue(wd.findElements(By.xpath("[href='/logout?url=%2Fsearch']")).size()>0);
        //   Assert.assertTrue(wd.findElements(By.xpath("[//a[normalize-space()=' Logout ']")).size()>0);
        // Assert.assertTrue(wd.findElements(By.xpath("//a[normalize-space()=' Logout '])[1]")).size()>0);
        Assert.assertTrue(wd.findElements(By.xpath("//*[text()=' Logout ']")).size() > 0);


    }

    @Test
    public void loginSuccessNew(){

        click(By.cssSelector("[href='/login?url=%2Fsearch']"));
        type(By.xpath("//input[@id='email']"), "missira85@gmail.com");
        type(By.xpath("//input[@id='password']"), "Irinka777$");
        click(By.xpath("//button[contains(text(),'Y’alla!')]"));
        click(By.xpath("//*[@type='button']"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()=' Logout ']")));



    }
}
