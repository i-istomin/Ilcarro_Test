package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    //  1. click the  login regist form
    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']")); // click(By.cssSelector("[href='/login?url=%2Fsearch']"));
    }

    //2. fill email +type the #password
    public void fillLoginForm(String email, String password) { //delaem copy paste
        type(By.xpath("//input[@id='email']"), email); //type(By.id("email"),email);
        type(By.xpath("//input[@id='password']"), password); //type(By.id("password"),password);
    }

    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

//    //3.click button yalla:
//    public void submit() {
//        click(By.xpath("//button[@type='submit']")); //click(By.xpath("//button[contains(text(),'Y’alla!')]"));
//    }

    //4. assert if it is true or false contact when success pop up opened
    public String checkMessage() {
        new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
              //webdriver budet jdat max 5 sec opredelenniy element
        String message = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        System.out.println(message);
        return message;
    }

    //4. submit/click button "ok"
    public void confirmLogin() {
        if (isElementPresent(By.xpath("//button[text()='Ok']"))){
            click(By.xpath("//button[text()='Ok']"));  //click(By.xpath("//*[@type='button']"));

        }


    }

    //5. is word  "log out" display on the screen
    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));//return isElementPresent(By.xpath("//*[contains(text(),' Logout ']"));
    }

//6. click on button "log out"
    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }

    //7. click on button "Sign up"
    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    //8. fill in all fields in registration form
    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastNAme());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicyXY() {
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']")); //nahodim snachala webelement
        //label.getRect();//alt+enter+inroduce
        Rectangle rect = label.getRect();
        int offSetX = rect.getWidth() / 2;//razniza na kot-yu ya budu smeshatsia
        int offSetY = rect.getHeight() / 2;

        Actions actions = new Actions(wd);//action class= delat nestandartnie deystviya
        actions.moveToElement(label).release().perform();//navodim mishkoy, no ne klikaem
        actions.moveByOffset(-offSetX, -offSetY).click().release().perform();//na kakie koordinati navesti mishku, kogda on navedet na tu tochku kot-ya menia ustraivaet, govorim click

    }

    public boolean isErrorPasswordDisplayedSize() {
        //Password must contain minimum 8 symbols  div.error div:first-child
        //Password must contain 1 uppercase letter, 1 lowercase letter and one number  div.error div:last-child
        Boolean firstChild = new WebDriverWait(wd, 5).until(ExpectedConditions
                .textToBePresentInElement
                        (wd.findElement(By.cssSelector("div.error div:first-child")), "Password must contain minimum 8 symbols"));
        return firstChild;
    }
     public boolean  isErrorPasswordFormat(){
        Boolean lastChild =new WebDriverWait(wd,5).until(ExpectedConditions
                .textToBePresentInElement
                        (wd.findElement(By.cssSelector("div.error div:last-child")),"Password must contain 1 uppercase letter, 1 lowercase letter and one number"));
      return lastChild;

    }

    public boolean isYallaButtonNotActive() {
        return wd.findElement(By.cssSelector("[type='submit']")).isEnabled();

    }

    public boolean isButtonClickable() {
        return isElementPresent(By.cssSelector("button[disabled]")); //when button id disabled, so our test passed because we are waiting for inactive button
        //we are waiting for true when this button doesn't cklickable
    }

    public void login(User user) {//soberem vse shagi chtoby sdelat login
        openLoginForm();
        fillLoginForm(user);
        submit();
        confirmLogin();
    }
}
