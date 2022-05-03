package tests;

import manager.MyDataProvider;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AddNewCarTests extends MainTests {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {//if login button display, so make login
        if (!app.getUserHelper().isLogOutPresent()) {
          //  app.getUserHelper().login(new User().withEmail("missira85@gmail.com").withPassword("Irinka777$"));
            User user = new User().withEmail("missira85@gmail.com").withPassword("Irinka777$");
            app.getUserHelper().login(user);
            logger.info("Test start with user -->  " + user.toString());
        }
    }


    @Test(groups = {"web","smoke"})
    public void addNewCarSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        logger.info(" 'Car Reg number' 100-22" +index);
//bolshe ne sozdaem cherez slovo "NEW", a cherez builder
        Car car = Car.builder()//mejdu builder and buils zapisivaem polia
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2022")
                .engine("2.5")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .carClasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("100-22-" + index)
                .price("65")
                .distanceIncluded("500")
                .features("Type of features")
                .about("Very good car")
                .build();

        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);//peredali obyekt car ko-e sozdali reanee
        app.getCar().attachPhoto("/home/i-istomin/TelRan/SYSTEMS/Ilcarro_Test/orange-car.png");//daem ssilku na foto
        logger.info("Attach photo --> /home/i-istomin/TelRan/SYSTEMS/Ilcarro_Test/orange-car.png" );
        app.getCar().submit();
        Assert.assertTrue(app.getCar().isCarAdded());


    }


    @Test(dataProvider="validDataCar", dataProviderClass = MyDataProvider.class)
    public void addNewCarSuccessProviderCSV(Car car) {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        logger.info(" 'Car Reg number' 100-22" +index);

        car.setCarRegNumber("100-22-" + index);


        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);//peredali obyekt car ko-e sozdali reanee
        app.getCar().attachPhoto("/home/i-istomin/TelRan/SYSTEMS/Ilcarro_Test/orange-car.png");//daem ssilku na foto
        logger.info("Attach photo --> /home/i-istomin/TelRan/SYSTEMS/Ilcarro_Test/orange-car.png" );
        app.getCar().submit();

        Assert.assertTrue(app.getCar().isCarAdded());


    }

}
