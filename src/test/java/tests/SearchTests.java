package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SearchTests extends MainTests {

    @BeforeMethod(alwaysRun = true)
    public void precondition(Method m) {
      if (app.getUserHelper().isLogOutPresent()) {
          app.getUserHelper().logout();
          logger.info("logout succeded");
      } else

    {
        User user = new User().withEmail("missira85@gmail.com").withPassword("Irinka777$");
        app.getUserHelper().login(user);
        logger.info("Test start with user -->  " + user.toString());
        app.getSearch().returnToHomePage();
        logger.info(("Start test" + m.getName()));

    }
       }

//    @Test
//    public void searchCurrentMonth() {
//    //    app.getSearch().cklickSearch();
//        app.getSearch().deleteFieldCity();
//        app.getSearch().searchCurrentMonth("Tel Aviv", "05/01/2022", "05/30/2022");
//        app.getSearch().submit();
//        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
//    }

    @Test(groups = {"web"})
    public void searchCurrentMonthInPast() {
     //   app.getSearch().cklickSearch();
       app.getSearch().deleteFieldCity();
        app.getSearch().searchCurrentMonthInPast("Tel Aviv", "4/01/2022", "4/20/2022");
        app.getSearch().submitWithoutWait();
        Assert.assertTrue(app.getSearch().isDatesAreRequired());//nujno vpisat is submiit cklickable i pereneste v testbase
        Assert.assertFalse(app.getUserHelper().isYallaButtonNotActive());
    }

    @Test
    public void searchPeriodInPast() {

     //   app.getSearch().cklickSearch();
      app.getSearch().deleteFieldCity();
        app.getSearch().searchPeriodInPast("Tel Aviv", "2/01/2022", "04/20/2022");
        app.getSearch().submitWithoutWait();

        Assert.assertFalse(app.getUserHelper().isYallaButtonNotActive());
        Assert.assertTrue(app.getSearch().isPeriodInPast());
    }

    @Test
    public void searchAnyPeriod() {
       // app.getSearch().deleteFieldCity();
        app.getSearch().searchAnyPeriod("Tel Aviv", "05/07/2023", "09/05/2023");
        app.getSearch().submit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        app.getSearch().returnToHomePage();
    }
}
