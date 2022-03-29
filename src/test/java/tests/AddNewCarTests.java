package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddNewCarTests extends MainTests {

    @BeforeMethod
    public void preCondition(){//if login button display, so make login
        if (!app.getUserHelper().isLogOutPresent()){
            app.getUserHelper().login(new User().withEmail("missira85@gmail.com").withPassword("Irinka777$"));
        }
    }



    @Test
    public void addNewCarSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
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
        app.getCar().submit();
        Assert.assertTrue(app.getCar().isCarAdded());



    }

}
