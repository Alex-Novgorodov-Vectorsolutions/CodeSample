package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PartnersPage {

 public static WebElement PageTitle (WebDriver driver){
  WebElement element = driver.findElement(By.xpath("//strong[contains(text(),'Our Partners')]"));
  return element;
 }

 public static List<WebElement> ListOfPartners (WebDriver driver){
  List<WebElement> list = driver.findElements(By.xpath("//div[@class='row h-100 ']"));
  return list;
 }
}
