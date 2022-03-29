package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//create constructors by @+name
@Setter //seeters from lombok
@Getter
@ToString
@Builder

public class Car {
    String address;
    String make;
    String model;
    String year;
    String engine;
    String fuel;
    String gear;
    String wD;//nelzia wd ->eto budet kak webdriver
    String doors;
    String seats;
    String carClasS;//nelzia slovo class
    String fuelConsumption;
    String carRegNumber;
    String price;
    String distanceIncluded;
    String features;
    String about;

}
//lombok-documentation