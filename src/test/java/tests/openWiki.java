package tests;

import manager.TestNGMyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestNGMyListener.class)
public class openWiki {

    WebDriver wd;//delaem otdelniy webdriver

    @Test
    public void openWikipedia() {//klass bez naskedovaniya
        wd = new ChromeDriver();
        wd.get("https://ru.wikipedia.org/");
        wd.quit();
    }
}

