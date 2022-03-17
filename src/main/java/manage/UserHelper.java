package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {// // 1. click the  login regist form
           click(By.cssSelector("[href='/login?url=%2Fsearch']"));
    }
    public void fillLoginRegistrationForm(String email, String password) {// //2. fill email +type the #password
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void submitLogin() {////3.click button yalla:
        click(By.xpath("//button[contains(text(),'Y’alla!')]"));
    }

    public void confirmLogin() {  // //4. click button "ok"
        click(By.xpath("//*[@type='button']"));
    }

    public boolean isLoginSuccess() {

     //   return isElementPresent(By.xpath("//*[text()=' Logout ']"));
        return isElementPresent(By.xpath("//*[contains(text(),' Logout ']"));

    }

}
