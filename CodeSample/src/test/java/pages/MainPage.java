package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    public static WebElement HamburgerBtn (WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//button[@class='navbar-toggler collapsed']"));
        return element;
    }

    public static WebElement PartnersLink (WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Partners')]"));
        return element;
    }

}
