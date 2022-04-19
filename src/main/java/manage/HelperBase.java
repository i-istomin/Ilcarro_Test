package manage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {//vajno chtob mne vernuli true/false
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis); //metod sleep trebuet brosit exception ili try catch
            //lucheshe try catch, potomu chto exception mi doljni budem dobavit vezde v proekte
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //3.click button yalla:---> vziali etot metot iz userhelper
    public void submit() {
        // click(By.xpath("//button[@type='submit']")); //click(By.xpath("//button[contains(text(),'Y’alla!')]"));
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector("[type='submit']"))));
        click(By.cssSelector("[type='submit']"));
    }

    public void submitWithoutWait() {

        click(By.cssSelector("[type='submit']"));
    }
    public void takeScreenShot(String pathToFile){
        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);

        File screenshot = new File(pathToFile);

        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}