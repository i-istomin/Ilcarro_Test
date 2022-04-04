package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends MainTests {


    @Test
    public void searchCurrentMonth() {
        app.getSearch().searchCurrentMonth("Tel Aviv", "04/10/2022", "04/20/2022");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test
    public void searchCurrentMonthInPast() {
        app.getSearch().searchCurrentMonthInPast("Tel Aviv", "4/01/2022", "4/20/2022");
       // app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isDatesAreRequired());//nujno vpisat is submiit cklickable i pereneste v testbase
    }
}
