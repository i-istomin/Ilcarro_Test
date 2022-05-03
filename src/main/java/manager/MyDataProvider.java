package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> validLoginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"missira85@gmail.com", "Irinka777$"});
        list.add(new Object[]{"missira85@gmail.com", "Irinka777$"});
        list.add(new Object[]{"missira85@gmail.com", "Irinka777$"});
        list.add(new Object[]{"missira85@gmail.com", "Irinka777$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validModelLogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("missira85@gmail.com").withPassword("Irinka777$")});
        list.add(new Object[]{new User().withEmail("missira85@gmail.com").withPassword("Irinka777$")});
        list.add(new Object[]{new User().withEmail("missira85@gmail.com").withPassword("Irinka777$")});
        list.add(new Object[]{new User().withEmail("missira85@gmail.com").withPassword("Irinka777$")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validModelCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/login.csv")));
        String line = reader.readLine(); //misskira85@gmail.com
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])}); //mi ispolzovali tolko pervuyu stroku
            line = reader.readLine();//chitaem 2-yu stroku --> missmira85@gmail.com
            //posle posledney stroki, mi vozvrashaemsia na proverku, no t.k. tam nichego net, to mi poluchiim null
            // null nam ne podhodit, poetomu zikl zakanchivaetsia na etom

        }

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> validDataCar() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/car.csv")));
        String line=reader.readLine();

        while (line!=null){
            String[] split=line.split(";");
            list.add(new Object[]{Car.builder()
                    .address(split[0])
                    .make(split[1])
                    .model(split[2])
                    .year(split[3])
                    .engine(split[4])
                    .fuel(split[5])
                    .gear(split[6])
                    .wD(split[7])
                    .doors(split[8])
                    .seats(split[9])
                    .carClasS(split[10])
                    .fuelConsumption(split[11])
                    .carRegNumber(split[12])
                    .price(split[13])
                    .distanceIncluded(split[14])
                    .features(split[15])
                    .about(split[16])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }


}


//    Car car = Car.builder()//mejdu builder and buils zapisivaem polia
//            .address("Tel Aviv, Israel")
//            .make("BMW")
//            .model("M5")
//            .year("2022")
//            .engine("2.5")
//            .fuel("Petrol")
//            .gear("MT")
//            .wD("AWD")
//            .doors("5")
//            .seats("4")
//            .carClasS("C")
//            .fuelConsumption("6.5")
//            .carRegNumber("100-22-" + index)
//            .price("65")
//            .distanceIncluded("500")
//            .features("Type of features")
//            .about("Very good car")
//            .build();