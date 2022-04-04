package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase {
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
        typeCity(city);//pechataem slovo v inpute
        selectPeriod(dataFrom, dataTo);

    }

    private void typeCity(String city) {

        type(By.id("city"), city);//pechataem slovo v inpute
        click(By.cssSelector(".pac-item"));//otkrivaetsia dropdown
        pause(500);

    }


    private void selectPeriod(String dataFrom, String dataTo) {//"04/10/2022", "04/20/2022"
        click(By.id("dates"));
        click(By.xpath("//div[contains(text(),'10')]"));// klikat 10
        click(By.xpath("//div[contains(text(),'20')]"));// klikat 20

// ne poluchilos**********************
//      String[] from = dataFrom.split("/");
//      String locator="//div[contains(text(),'"+ dataFrom+"']";
//      wd.findElement(By.xpath(locator)).click();
//**********************

    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.xpath("//h1[.=' Find your car now! ']"));
    }


    public void searchCurrentMonthInPast(String city, String dataFrom, String dataTo) {
        typeCity(city);//pechataem slovo v inpute
        typePeriodInPast(dataFrom, dataTo);

    }


    private void typeCity1(String city) {
        type(By.id("city"), city);//pechataem slovo v inpute
        click(By.cssSelector(".pac-item"));//otkrivaetsia dropdown
        pause(500);

    }

    private void typePeriodInPast(String dataFrom, String dataTo) {
        click(By.id("dates"));
        click(By.cssSelector(".cdk-overlay-container"));
        type(By.id("dates"), "4/01/2022" + "-" + "4/20/2022");
        click(By.cssSelector(".cdk-overlay-container"));


    }

    public boolean isDatesAreRequired() {
        // return isElementPresent(By.cssSelector("error ng-star-inserted"));
        return isElementPresent(By.cssSelector("div[class='ng-star-inserted']"));

    }
}
