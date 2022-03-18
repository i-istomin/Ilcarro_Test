package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class UserHelper extends HelperBase {




    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {// // 1. click the  login regist form
           click(By.cssSelector("[href='/login?url=%2Fsearch']"));
         //  click(By.xpath("//a[text()=' Log in ']"));
    }
    public void fillLoginRegistrationForm(String email, String password) {// //2. fill email +type the #password
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void submit() {////3.click button yalla:
        click(By.xpath("//button[@type=\"submit\"]"));
        //click(By.xpath("//button[contains(text(),'Y’alla!')]"));

    }

    //5. assert if it is true or false contact when success pop up opened
    public String checkMessage(){
        String message=wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        System.out.println(message);
        return message;
    }


    public void confirmLogin() {  // //4. click button "ok"
        click(By.xpath("//*[@type='button']"));

    }

   // public boolean isLoginRegistrationSuccess() {
      //  return isElementPresent(By.xpath("//*[text()=' Logout ']"));
      //  return isElementPresent(By.xpath("//*[contains(text(),' Logout ']"));

  //  }

    public void submitRegistration() {
        click(By.xpath("//*[@class='navigator']"));
    }

    public boolean iLogOutPresent() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.id("name"),name);
        type(By.id("lastName"),lastName);
        type(By.id("email"),email);
        type(By.id("password"),password);
    }

   // public void checkPolicy() {
       // click(By.cssSelector("label[for='terms-of-use']"));-->ne poluchilos iz za shirini ekrana, nujno vishcitat ne po lokatoru a po visote i shirine

   // }

    public void checkPolicyXY(){
        WebElement label=wd.findElement(By.cssSelector("label[for='terms-of-use']")); //nahodim snachala webelement
        //label.getRect();//alt+enter+inroduce
        Rectangle rect = label.getRect();
        int offSetX=rect.getWidth()/2;//razniza na kot-yu ya budu smeshatsia
        int offSetY=rect.getHeight()/2;

        Actions actions =new Actions(wd);//action class= delat nestandartnie deystviya
        actions.moveToElement(label).release().perform();//navodim mishkoy, no ne klikaem
        actions.moveByOffset(-offSetX,-offSetY).click().release().perform();//na kakie koordinati navesti mishku, kogda on navedet na tu tochku kot-ya menia ustraivaet, govorim click

    }
}
