package Locators;

import org.openqa.selenium.By;

import java.text.MessageFormat;

public interface Locators {

    By lSignupButton= By.xpath("//a[contains(.,'Signup / Login')]");
    By lInputEmail= By.xpath("(//input[@placeholder='Email Address'])[1]");
    By lInputPassword= By.xpath("//input[@placeholder='Password']");
    By lSubmitButton= By.xpath("//button[contains(.,'Login')]");
    By lLogoutButton= By.xpath("//a[contains(.,'Logout')]");

    By lSingUpName=By.xpath("//input[@placeholder='Name']");
    By lSingUpEMail=By.xpath("(//input[@placeholder='Email Address'])[2]");
    By lSingUpButton=By.xpath("//button[contains(.,'Signup')]");



    String gender="//label[contains(.,\"{0}\")]";

    String singupInput="//input[@id=\"{0}\"]";
    String singupSelect="//select[@id=\"{0}\"]";
    By singupSubmitButton=By.xpath("//button[contains(.,'Create Account')]");





    public static By xpath(String locator,String text){
       return By.xpath(MessageFormat.format(locator,text));

    }
}
