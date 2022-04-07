package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase {
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void searchCurrentMonth(String city, String dataFrom, String dataTo) {
        pause(500);
        typeCity(city);//pechataem slovo v inpute
        selectPeriod(dataFrom, dataTo);

    }

    private void typeCity(String city) {

        type(By.id("city"), city);//pechataem slovo v inpute
        pause(500);
        click(By.cssSelector(".pac-item"));//otkrivaetsia dropdown
        pause(500);

    }




    private void selectPeriod(String dataFrom, String dataTo) {//"04/10/2022", "04/20/2022"
        click(By.id("dates"));
//*************************** prostoy metod
//        click(By.xpath("//div[text()=' 10 ']"));// klikat 10
//        click(By.xpath("//div[text()=' 20 ']"));// klikat 20


//***************************bolee slohniy metod

        String[] from = dataFrom.split("/"); //[04][10][2022] --> a nujen tolko sredniy
        String dayF = from[1];//nas interesuet index 1. kladem ego v peremennuyu
        String locatorFrom = String.format("//div[text()=' %s ']", dayF);
        click(By.xpath(locatorFrom));

        String[] to = dataTo.split("/");//[04][20][2022] --> a nujen tolko sredniy
        String dayT = to[1];//nas interesuet index 1. kladem ego v peremennuyu
        String locatorTo = String.format("//div[text()=' %s ']", dayT);
        wd.findElement(By.xpath(locatorTo)).click();


    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.xpath("//h1[.=' Find your car now! ']"));
    }


    public void searchCurrentMonthInPast(String city, String dataFrom, String dataTo) {

        typeCity(city);//pechataem slovo v inpute
        pause(500);
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
        type(By.id("dates"),dataFrom + " - "+dataTo); // type(By.id("dates"), "4/01/2022" + "-" + "4/20/2022");
        click(By.cssSelector(".cdk-overlay-container"));


    }

    public boolean isDatesAreRequired() {
               return isElementPresent(By.cssSelector("div[class='ng-star-inserted']"));

    }

    public void searchAnyPeriod(String city, String dataFrom, String dataTo) {
        typeCity(city);
        selectPeriodAnyData(dataFrom, dataTo);
    }

    private void selectPeriodAnyData(String dataFrom, String dataTo) {
        //mi doljni iz pervogo stringa vziat god i zatem cherez local date procerit kakoy seychas god
        //no delo v tom chto local date daet otvet v int i sravnit string s int, uje bolee slojno
        //poetomu nash string srazu peredelivaem v localdate a zatem ih sravnivaem
        // "04/05/2022" [04][05][2022]String yearFrom="2022" int 2022
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        click(By.id("dates"));
        int diffYear;// nujno vsegda znat esli est raniza mejdu godami
        int diffMonth; // nujno vsegda znat esli est raniza mejdu mesiazami

        diffYear = from.getYear()- now.getYear();// god nineshniy proveriaem s tem chto najali
        if (diffYear == 0) {//esli tam lejit 0, to mi vnujnom godu
            diffMonth = from.getMonthValue() - now.getMonthValue();//to budem schitat raznizu mejdu mesiazami
        } else {//no esli mi ne v nuhnom godu
            diffMonth =12- now.getMonthValue() +from.getMonthValue();
        }
        clickByNextMonth(diffMonth);

        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));
        //***********************************************************************************************

        //kogda nujno poniat v nujnom li ya godu nahojus posle togo kak ya uje naklikala nobuyu datu
        //zabirae, god gde kliknula i stavnivau s nujnim godom
        diffYear = to.getYear() - from.getYear();
        if (diffYear == 0) { //esli razniza ravna 0, to mi v nujnom godu
            diffMonth = to.getMonthValue() - from.getMonthValue();//vozmem mesiaz v kot-m doljen zakonchitsia period
        } else {
            diffMonth = 12 - from.getMonthValue() + to.getMonthValue();
        }//doklikali do nujnogo mesiaza

        clickByNextMonth(diffMonth);
        locator = String.format("//div[text()=' %s ']",to.getDayOfMonth());

        click(By.xpath(locator));


    }

    private void selectPeriodAnyData2(String dataFrom, String dataTo) {
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        //"04/05/2022"     [04][05][2022] String yearfFrom = "2022" int 2022

        click(By.id("dates"));


        int diffMonth = from.getYear()- now.getYear()
                ==0 ? from.getMonthValue()-now.getMonthValue() :12- now.getMonthValue() +from.getMonthValue();

        clickByNextMonth(diffMonth);

        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));
        //***********************************************************************************************


        diffMonth = to.getYear()-from.getYear()
                ==0 ? to.getMonthValue()-from.getMonthValue() :  12-from.getMonthValue()+to.getMonthValue();

        clickByNextMonth(diffMonth);

        locator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));

    }


    private void clickByNextMonth(int count) {
        for (int i = 0; i < count; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }


    public void searchPeriodInPast(String city, String dataFrom, String dataTo) {
        typeCity(city);
        typePeriodInPast(dataFrom,dataTo);

    }

    public boolean isPeriodInPast() {
        pause(1000);
        WebElement el = wd.findElement(By.xpath("//div[@class='ng-star-inserted']"));
        String error = el.getText();
        System.out.println(error);
        return error.equals("You can't pick date before today");
    }

    public void cklickSearch() {
        click(By.id("0"));

    }

    public void deleteFieldCity() {
        click(By.id("city"));
        //wd.findElement(By.id("city")).sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b\b");//Tel Aviv-Yafo
        wd.findElement(By.id("city")).clear();

    }

    public void deleteFieldDate() {

        click(By.id("dates"));
        wd.findElement(By.id("dates")).clear();
    }
}

