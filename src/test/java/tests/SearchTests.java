package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends MainTests {

    @BeforeMethod
    public void precondition() { //is login?->log out
        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logout();
        }
    }

    @Test
    public void searchCurrentMonth() {
    //    app.getSearch().cklickSearch();
        app.getSearch().deleteFieldCity();
        app.getSearch().searchCurrentMonth("Tel Aviv", "04/10/2022", "04/20/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test
    public void searchCurrentMonthInPast() {
    //    app.getSearch().cklickSearch();
      //  app.getSearch().deleteFieldCity();
        app.getSearch().searchCurrentMonthInPast("Tel Aviv", "4/01/2022", "4/20/2022");
        app.getSearch().submitWithoutWait();
        Assert.assertTrue(app.getSearch().isDatesAreRequired());//nujno vpisat is submiit cklickable i pereneste v testbase
        Assert.assertFalse(app.getUserHelper().isYallaButtonNotActive());
    }

    @Test
    public void searchPeriodInPast() {

     //   app.getSearch().cklickSearch();
     //   app.getSearch().deleteFieldCity();
        app.getSearch().searchPeriodInPast("Tel Aviv", "2/01/2022", "04/20/2022");
        app.getSearch().submitWithoutWait();

        Assert.assertFalse(app.getUserHelper().isYallaButtonNotActive());
        Assert.assertTrue(app.getSearch().isPeriodInPast());
    }

    @Test
    public void searchAnyPeriod() {
        app.getSearch().deleteFieldCity();
        app.getSearch().searchAnyPeriod("Tel Aviv", "05/07/2022", "04/05/2023");
        app.getSearch().submit();
    }

    @AfterMethod
    public void postCondition() {
        app.getSearch().returnToHomePage();
    }
}
