package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import pages.MainPage;
import  pages.PartnersPage;


public class PartnersPageTests{
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anov5\\IdeaProjects\\CodeSample\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = (new WebDriverWait(driver, 10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public  void clearCookies(){
        driver.manage().deleteAllCookies();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test (priority = 0)
    public void VerifyPartnersPage_Logo(){
        // Open webpage
        driver.get("https://www.achieve3000.com/");

        // Wait until 'hamburger' button will be clickable and click on it
        wait.until(ExpectedConditions.elementToBeClickable(MainPage.HamburgerBtn(driver)));
        MainPage.HamburgerBtn(driver).click();

        // Wait until 'Partners' link will be clickable and click on it
        wait.until(ExpectedConditions.elementToBeClickable(MainPage.PartnersLink(driver)));
        MainPage.PartnersLink(driver).click();

        // Wait until Partners page uploaded
        wait.until(ExpectedConditions.visibilityOf(PartnersPage.PageTitle(driver)));

        // Get count of Partners on the page
        int countOfPartners = PartnersPage.ListOfPartners(driver).size();

        for(int i = 1; i <= countOfPartners; i++)
        {
            // For each partner verify LOGO image present
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'row h-100 ')][" + i + "]/div[1]/a[1]/img[1]")).isDisplayed());
        }
    }

    @Test (priority = 1)
    public void VerifyPartnersPage_Title(){
        // Open webpage
        driver.get("https://www.achieve3000.com/");

        // Wait until 'hamburger' button will be clickable and click on it
        wait.until(ExpectedConditions.elementToBeClickable(MainPage.HamburgerBtn(driver)));
        MainPage.HamburgerBtn(driver).click();

        // Wait until 'Partners' link will be clickable and click on it
        wait.until(ExpectedConditions.elementToBeClickable(MainPage.PartnersLink(driver)));
        MainPage.PartnersLink(driver).click();

        // Wait until Partners page uploaded
        wait.until(ExpectedConditions.visibilityOf(PartnersPage.PageTitle(driver)));

        // Get count of Partners on the page
        int countOfPartners = PartnersPage.ListOfPartners(driver).size();

        for(int i = 1; i <= countOfPartners; i++)
        {
            // For each partner verify title present
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'row h-100 ')][" + i + "]/div[2]/a[1]/h3[1]")).isDisplayed());
            // Show the list of partners in console output
            System.out.println(driver.findElement(By.xpath("//div[contains(@class,'row h-100 ')][" + i + "]/div[2]/a[1]/h3[1]")).getText());
        }
    }

    @Test (priority = 2)
    public void VerifyPartnersPage_DescriptionText(){
        // Open webpage
        driver.get("https://www.achieve3000.com/");

        // Wait until 'hamburger' button will be clickable and click on it
        wait.until(ExpectedConditions.elementToBeClickable(MainPage.HamburgerBtn(driver)));
        MainPage.HamburgerBtn(driver).click();

        // Wait until 'Partners' link will be clickable and click on it
        wait.until(ExpectedConditions.elementToBeClickable(MainPage.PartnersLink(driver)));
        MainPage.PartnersLink(driver).click();

        // Wait until Partners page uploaded
        wait.until(ExpectedConditions.visibilityOf(PartnersPage.PageTitle(driver)));

        // Get count of Partners on the page
        int countOfPartners = PartnersPage.ListOfPartners(driver).size();

        for(int i = 1; i <= countOfPartners; i++)
        {
            // For each partner verify text of description present
            String partnerDescriptionText = driver.findElement(By.xpath("//div[contains(@class,'row h-100 ')][" + i + "]/div[2]/div[1]/p[1]")).getText();

            Assert.assertTrue(partnerDescriptionText != null); // check for 'null'
            Assert.assertTrue(!partnerDescriptionText.trim().isEmpty()); // check for 'empty' string
        }
    }
}
