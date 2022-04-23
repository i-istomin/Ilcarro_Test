package manager;

//nastroyka v proekte


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);


    public MyListener() {//dobavliaem constructor
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {//etot metod vizovet metod superclassa
        super.beforeFindBy(by, element, driver);
        logger.info("'Start find' element--->" + by);  //budet pisat chto nachinaetsia sobitie poiska elementa
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element with locator --->" + by + "<----was found");   //budet pisat chto  sobitie poiska elementa zakonchilos

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {//kogda proizoydet oshibka, suda priydet exception
        super.onException(throwable, driver);
        logger.info("We have a 'throwable' ---> " + throwable.getMessage());//i tut mi dobavim zapis
        logger.info("We have a 'throwable' ---> " + throwable.getStackTrace().toString());
        //Метод fillInStackTrace(), реализованный в классе Throwable позволяет получить объект типа Throwable.
        // Этот метод записывает в этот объект Throwable информацию о текущем состоянии кадров стека для текущего потока.
        //*********************
        // getStackTrace() - Предоставляет программный доступ к информации о трассировке стека, напечатанной функцией printStackTrace().
        //Как правило, это точка, в которой этот метательный объект был создан и брошен.


        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        HelperBase helperBase = new HelperBase(driver);//sozdaem obyekt
        helperBase.takeScreenShot("src/test/screenshots/screen-" + index + ".png");

        logger.info("This is the link to screen with problem-->src/test/screenshots/screen-"+index+".png" );

    }
}
