package Steps;

import Utils.Browsers;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {

    WebDriver driver = Driver.getDriver(Browsers.chrome);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10_000));


    private static WebElement element;
    private static By locator;


    public BaseClass of(WebElement element) {
        this.element = element;
        return this;
    }
    public BaseClass of(By locator){
        this.element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this;
    }

    public BaseClass open(String url) {
        driver.get(url);
        return this;

    }


    public void click() {
        wait.until(ExpectedConditions.visibilityOf(element)).click();

    }

    public BaseClass sentKeys(String value) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
        return this;
    }
    public BaseClass scrollToElement() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        int element_Y_Pozisyon = element.getLocation().getY();
        int driverHeight = driver.manage().window().getSize().getHeight();
        int scrollPozisyon = element_Y_Pozisyon - (driverHeight / 2);


        int elementPositionY = element.getLocation().getY();
        int windowHeight = driver.manage().window().getSize().getHeight();
        int scrollPositionY = elementPositionY - (windowHeight / 2);
        jsExecutor.executeScript("window.scrollTo(0, " + scrollPositionY + ");");
        return this;
    }

}

